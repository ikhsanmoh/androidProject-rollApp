package project.roll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  // Regist Button Event Handler
  public void onClickRegist(View v){
    //Create instance for Intent Object
    Intent myInt = new Intent(this, RegisterActivity.class);
    //Opening New Activity
    startActivity(myInt);
  }

  // Login Button Event Handler
  public void onClickLogin(View v){
    //Create instance for Intent Object
    Intent myInt = new Intent(this, LoginActivity.class);
    //Opening New Activity
    startActivity(myInt);
  }
}
