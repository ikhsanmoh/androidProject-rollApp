package project.roll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import project.roll.model.Photographer;
import project.roll.utils.SampleDataSet;

import static project.roll.PhotographerProfileActivity.PHOTOGRAPHER_ID_KEY;

public class BookingForm extends AppCompatActivity implements View.OnClickListener {

  public static final String FORM_DATA_KEY = "formData";

  private ImageView imgPhotographerPhoto;
  private TextView txtPhotographerName, txtLocations, txtNotes;
  private Spinner spinDate, spinTime, spinCategories;
  private Button btnCancel, btnConfirm;

  private ArrayAdapter<String> adapterForSpinDate, adapterForSpinTime, adapterForSpinCategories;

  private String inputDate, inputTime, inputCategories, inputLocation, inputNotes;

  private String[] formData;

  private Photographer photographerData;

  private BroadcastReceiver broadcastReceiver;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_booking_form);

    initViews();

    adapterForSpinDate = adapterSetup();
    adapterForSpinTime = adapterSetup();
    adapterForSpinCategories = adapterSetup();

    // Spinner Date dengan Sample Data
    adapterForSpinDate.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    adapterForSpinDate.add("01/10/2021");
    adapterForSpinDate.add("01/11/2021");
    adapterForSpinDate.add("01/12/2021");
    adapterForSpinDate.add("01/13/2021");
    adapterForSpinDate.add("01/14/2021");
    adapterForSpinDate.add("01/15/2021"); // dst.
    adapterForSpinDate.add("dd/mm/yy"); // hint

    // Spinner Time dengan Sample Data
    adapterForSpinTime.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    adapterForSpinTime.add("08:00");
    adapterForSpinTime.add("09:00");
    adapterForSpinTime.add("10:00");
    adapterForSpinTime.add("11:00");
    adapterForSpinTime.add("12:00");
    adapterForSpinTime.add("13:00");
    adapterForSpinTime.add("14:00");
    adapterForSpinTime.add("15:00");
    adapterForSpinTime.add("16:00");
    adapterForSpinTime.add("17:00");
    adapterForSpinTime.add("18:00");
    adapterForSpinTime.add("19:00");
    adapterForSpinTime.add("20:00");
    adapterForSpinTime.add("21:00");
    adapterForSpinTime.add("22:00"); // dst.
    adapterForSpinTime.add("00:00"); // hint

    // Spinner Categories dengan Sample Data
    adapterForSpinCategories.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    adapterForSpinCategories.add("Prewedding");
    adapterForSpinCategories.add("Wedding"); // dst.
    adapterForSpinCategories.add("#Wedding"); // hint

    // Set Spinner Date
    spinDate.setAdapter(adapterForSpinDate);
    spinDate.setSelection(adapterForSpinDate.getCount()); // Menampilkan hint

    // Set Spinner Time
    spinTime.setAdapter(adapterForSpinTime);
    spinTime.setSelection(adapterForSpinTime.getCount());

    // Set Spinner Categories
    spinCategories.setAdapter(adapterForSpinCategories);
    spinCategories.setSelection(adapterForSpinCategories.getCount());

    Intent myIntent = getIntent();
    if (null != myIntent){
      int photographerId = myIntent.getIntExtra(PHOTOGRAPHER_ID_KEY, -1);
      if (photographerId != -1){
        photographerData = SampleDataSet.getInstance().getPhotographerById(photographerId);
        if (null != photographerData){
          setDataViews(photographerData);
        }
      }
    }

    btnCancel.setOnClickListener(this);
    btnConfirm.setOnClickListener(this);

    broadcastReceiver = new BroadcastReceiver() {
      @Override
      public void onReceive(Context arg0, Intent intent) {
        String action = intent.getAction();
        if (action.equals("finish_order_activity")) {
          Log.d("OnReceiveTest", "Booking Form Finished");
          finish();
        }
      }
    };
    registerReceiver(broadcastReceiver, new IntentFilter("finish_order_activity"));
  }

  public ArrayAdapter<String> adapterSetup(){
    return new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item){
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
  };

  private void initViews() {
    imgPhotographerPhoto = findViewById(R.id.imgPhotographer);
    txtPhotographerName = findViewById(R.id.txtPhotographerName);
    txtLocations = findViewById(R.id.editTxtLocation);
    txtNotes = findViewById(R.id.editTxtPartnerNotes);

    spinDate = findViewById(R.id.spinDate);
    spinTime = findViewById(R.id.spinTime);
    spinCategories = findViewById(R.id.spinCategories);

    btnCancel = findViewById(R.id.btnCancel);
    btnConfirm = findViewById(R.id.btnNext);
  }

  private void setDataViews(Photographer photographerData) {
    Glide.with(this)
            .asBitmap().load(photographerData.getImgUrl())
            .into(imgPhotographerPhoto);
    txtPhotographerName.setText(photographerData.getName());
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()){
      case R.id.btnCancel:
        finish();
        break;
      case R.id.btnNext:
        inputDate = spinDate.getSelectedItem().toString();
        inputTime = spinTime.getSelectedItem().toString();
        inputCategories = spinCategories.getSelectedItem().toString();
        inputLocation = txtLocations.getText().toString();
        inputNotes = txtNotes.getText().toString();

        formData = new String[]{inputDate, inputTime, inputCategories, inputLocation, inputNotes};

        Intent myInt = new Intent(this, OrderConfirmation.class);
        myInt.putExtra(PHOTOGRAPHER_ID_KEY, photographerData.getId());
        myInt.putExtra(FORM_DATA_KEY ,formData);
        startActivity(myInt);
        break;
      default:
        break;
    }
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    unregisterReceiver(broadcastReceiver);
  }
}
