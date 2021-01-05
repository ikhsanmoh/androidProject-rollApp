package project.roll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import project.roll.model.Photographer;
import project.roll.utils.SampleDataSet;

import static project.roll.BookingForm.FORM_DATA_KEY;
import static project.roll.PhotographerProfileActivity.PHOTOGRAPHER_ID_KEY;

public class OrderConfirmation extends AppCompatActivity implements View.OnClickListener {

  private ImageView imgPhotographerPhoto;
  private TextView txtPhotographerName, txtPlayDate, txtTime, txtCategories, txtLocations, txtNotes;
  private Spinner spinRentDuration;
  private Button btnBack, btnOrder;

  private ArrayAdapter<String> adapter;

  private String inputDate, inputTime, inputCategories, inputLocation, inputNotes;

  private Photographer photographerData;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_order_confirmation);

    initViews();

    adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item){
      @Override
      public View getView(int position, View convertView, ViewGroup parent) {
        View v = super.getView(position, convertView, parent);
        if (position == getCount()) {
          ((TextView)v.findViewById(android.R.id.text1)).setText("");
          ((TextView)v.findViewById(android.R.id.text1)).setHint(getItem(getCount())); // Men-set Hint
        }
        return v;
      }

      @Override
      public int getCount() {
        return super.getCount()-1; // Menghilangkan item Hint
      }
    };

    // Spinner Date dengan Sample Data
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    adapter.add("1 Hour");
    adapter.add("2 Hour");
    adapter.add("3 Hour");
    adapter.add("4 Hour");
    adapter.add("5 Hour"); // dst.
    adapter.add("00:00"); // hint

    // Set Spinner Rent Duration
    spinRentDuration.setAdapter(adapter);
    spinRentDuration.setSelection(adapter.getCount()); // Menampilkan hint

    Intent myIntent = getIntent();
    if (null != myIntent){
      int photographerId = myIntent.getIntExtra(PHOTOGRAPHER_ID_KEY, -1);
      String[] formData = myIntent.getStringArrayExtra(FORM_DATA_KEY);
      if (photographerId != -1){
        photographerData = SampleDataSet.getInstance().getPhotographerById(photographerId);
        if (null != photographerData || null != formData){
          setDataViews(photographerData, formData);
        } else {
          Toast toast = Toast.makeText(getApplicationContext(),"Something is Wrong!",Toast.LENGTH_SHORT);
        }
      }
    }

    btnBack.setOnClickListener(this);
    btnOrder.setOnClickListener(this);
  }

  private void initViews() {
    imgPhotographerPhoto = findViewById(R.id.imgPhotographer);

    txtPhotographerName = findViewById(R.id.txtPhotographerName);
    txtPlayDate = findViewById(R.id.txtPlayDate);
    txtTime = findViewById(R.id.txtTime);
    txtCategories = findViewById(R.id.txtCategories);
    txtLocations = findViewById(R.id.txtLocation);
    txtNotes = findViewById(R.id.txtNotes);

    spinRentDuration = findViewById(R.id.spinRentDuration);

    btnBack = findViewById(R.id.btnBack);
    btnOrder = findViewById(R.id.btnOrder);
  }

  private void setDataViews(Photographer photographerData, String[] formData) {
    Glide.with(this)
            .asBitmap().load(photographerData.getImgUrl())
            .into(imgPhotographerPhoto);
    txtPhotographerName.setText(photographerData.getName());

    txtPlayDate.setText(formData[0]);
    txtTime.setText(formData[1]);
    txtCategories.setText(formData[2]);
    txtLocations.setText(formData[3]);
    txtNotes.setText(formData[4]);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()){
      case R.id.btnBack:
        finish();
        break;
      case R.id.btnOrder:
        Intent myInt = new Intent(this, OrderCompleted.class);
        myInt.putExtra(PHOTOGRAPHER_ID_KEY, photographerData.getId());
        Intent intent = new Intent("finish_order_activity");
        sendBroadcast(intent);
        startActivity(myInt);
        finish();
        break;
      default:
        break;
    }
  }
}
