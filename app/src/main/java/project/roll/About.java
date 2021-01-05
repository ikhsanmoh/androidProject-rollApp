package project.roll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class About extends AppCompatActivity {

  private TextView txtPortoDesc;
  private Button btnCloseAbout;
  private String portoDesc;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_about);

    portoDesc = "Roll is a startup engaged in the rental and marketing of photo and videography services, which has partnered with Roll. " +
            "Roll aims to connect photo and videography service providers with all of you who are looking for someone in these two fields. " +
            "Roll's partners themselves have unique skills from each individual. " +
            "The categories we provide in these two fields are various for you to choose from to meet the needs of all of you.\n";

    txtPortoDesc = findViewById(R.id.txtPortoDesc);
    btnCloseAbout = findViewById(R.id.btnCloseAbout);

    txtPortoDesc.setText(portoDesc);

    btnCloseAbout.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });
  }
}
