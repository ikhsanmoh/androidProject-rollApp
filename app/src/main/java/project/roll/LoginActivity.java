package project.roll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
  }

  // Login Button Event Handler
  public void onClickLoginSubmit(View v){
    //Create instance for Intent Object
    Intent myInt = new Intent(this, BerandaActivity.class);
    //Opening New Activity
    startActivity(myInt);
    finish();
  }
}
