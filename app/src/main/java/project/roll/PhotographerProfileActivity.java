package project.roll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import project.roll.model.Photographer;
import project.roll.utils.SampleDataSet;

public class PhotographerProfileActivity extends AppCompatActivity implements View.OnClickListener {

  public static final String PHOTOGRAPHER_ID_KEY = "photographerId";

  private TextView txtName, txtRating, txtDomicilie, txtPrice, txtCategories, txtServices, txtStatus;
  private Button btnCloseProfile, btnBook;
  private ImageView imgPhotoProfile, imgBestCapt1, imgBestCapt2;
  private RelativeLayout lightStatus;

  private Photographer photographerData;

  private BroadcastReceiver broadcastReceiver;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_photographer_profile);

    initViews();

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

    btnCloseProfile.setOnClickListener(this);
    btnBook.setOnClickListener(this);

    broadcastReceiver = new BroadcastReceiver() {
      @Override
      public void onReceive(Context arg0, Intent intent) {
        String action = intent.getAction();
        if (action.equals("finish_order_activity")) {
          Log.d("OnReceiveTest", "Photographer Profile Finished");
          finish();
        }
      }
    };
    registerReceiver(broadcastReceiver, new IntentFilter("finish_order_activity"));
  }

  private void initViews() {
    txtName = findViewById(R.id.txtPhotographerName);
    txtRating = findViewById(R.id.txtRating);
    txtDomicilie = findViewById(R.id.txtDomicilie);
    txtPrice = findViewById(R.id.txtPrice);
    txtCategories = findViewById(R.id.txtCategories);
    txtServices = findViewById(R.id.txtServices);
    txtStatus = findViewById(R.id.txtStatus);

    btnCloseProfile = findViewById(R.id.btnCloseProfile);
    btnBook = findViewById(R.id.btnBooking);

    imgPhotoProfile = findViewById(R.id.imagePhotoProfile);
    imgBestCapt1 = findViewById(R.id.imageBestCapt1);
    imgBestCapt2 = findViewById(R.id.imageBestCapt2);

    lightStatus = findViewById(R.id.lightStatus);
  }

  private void setDataViews(Photographer photographer) {

    String[] bestCaptures = photographer.getImgUrlBestCaptures();

    Glide.with(this)
            .asBitmap().load(photographer.getImgUrl())
            .into(imgPhotoProfile);
    Glide.with(this)
            .asBitmap()
            .load(bestCaptures[0])
            .into(imgBestCapt1);
    Glide.with(this)
            .asBitmap()
            .load(bestCaptures[1])
            .into(imgBestCapt2);
    txtName.setText(photographer.getName());
    txtRating.setText(photographer.getRating());
    txtDomicilie.setText(photographer.getDomicilie());
    txtPrice.setText(photographer.getPrice());
    txtCategories.setText(photographer.getCategories());
    txtServices.setText(photographer.getProfession());
    txtStatus.setText(photographer.getStatus());
    if (photographer.getStatus() != "Available"){
      lightStatus.setBackground(getDrawable(R.drawable.circle_shape_solid_red));
    }
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.btnCloseProfile:
        finish();
        break;
      case R.id.btnBooking:
        Intent myInt = new Intent(this, BookingForm.class);
        myInt.putExtra(PHOTOGRAPHER_ID_KEY, photographerData.getId());
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