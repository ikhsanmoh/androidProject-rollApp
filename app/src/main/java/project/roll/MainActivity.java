package project.roll;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  // TODO: Create fragment that can call other fragment

  private TextView btnAbout;
//  private Button btnBack;
  private AlertDialog.Builder builder;
  private Fragment selectedFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btnAbout = findViewById(R.id.btn_about);
//    btnBack = findViewById(R.id.buttonTest);

    btnAbout.setOnClickListener(this);
//    btnBack.setOnClickListener(this);

    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new StarterPageFragment()).commit();
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

  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.btn_about:
        selectedFragment = new AboutFragment();
        break;
//      case R.id.buttonTest:
//        selectedFragment = new StarterPageFragment();
//        break;
      default:
        break;
    }
    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selectedFragment).commit();
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
