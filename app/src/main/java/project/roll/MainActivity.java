package project.roll;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  AlertDialog.Builder builder;

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

  //Costumize Fungsi tombol back
  @Override
  public void onBackPressed() {
    //Alert Peringatan Keluar dari App
    isFinish("Keluar dari Applikasi");
  }

  public void isFinish(String alertMessage) {

    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        switch (which) {
          case DialogInterface.BUTTON_POSITIVE:
            //Keluar dari aktivitas ini
            finish();
            break;
          case DialogInterface.BUTTON_NEGATIVE:
            //Tidak ada perintah
            break;
        }
      }
    };

    builder = new AlertDialog.Builder(this);
    builder.setCancelable(false);
    builder.setMessage(alertMessage);
    builder.setPositiveButton("Ya", dialogClickListener);
    builder.setNegativeButton("Batalkan", dialogClickListener);
    builder.create().show();
  }
}
