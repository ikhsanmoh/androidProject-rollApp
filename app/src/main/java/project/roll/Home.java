package project.roll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity implements View.OnClickListener {

  private TextView btnLogout;
  private Button btnClose;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);

    btnLogout = findViewById(R.id.btnLogout);
    btnClose = findViewById(R.id.btnClose);

    btnLogout.setOnClickListener(this);
    btnClose.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.btnClose:
        finish();
        break;
      case R.id.btnLogout:
        Intent intent = new Intent("finish_all_activity");
        sendBroadcast(intent);
        finish();
        break;
      default:
        break;
    }
  }
}
