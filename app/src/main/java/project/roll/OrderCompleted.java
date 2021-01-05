package project.roll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import project.roll.model.Photographer;
import project.roll.utils.SampleDataSet;

import static project.roll.PhotographerProfileActivity.PHOTOGRAPHER_ID_KEY;

public class OrderCompleted extends AppCompatActivity {

  private Button btnFinishOrder;
  private ImageView imgPhotographer;
  private TextView txtPhotographerName;
  private Photographer photographerData;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_order_completed);

    imgPhotographer = findViewById(R.id.imgPhotographer);
    txtPhotographerName = findViewById(R.id.txtPhotographerName);
    btnFinishOrder = findViewById(R.id.btnFinishOrder);

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

    btnFinishOrder.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        finish();
      }
    });
  }

  private void setDataViews(Photographer photographerData) {
    Glide.with(this)
            .asBitmap().load(photographerData.getImgUrl())
            .into(imgPhotographer);
    txtPhotographerName.setText(photographerData.getName());
  }
}
