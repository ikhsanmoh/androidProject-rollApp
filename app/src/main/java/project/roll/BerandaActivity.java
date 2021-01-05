package project.roll;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import project.roll.adapter.PhotographersRecViewAdapter;
import project.roll.utils.SampleDataSet;

public class BerandaActivity extends AppCompatActivity {

  private RecyclerView photographerRecView;
  private BroadcastReceiver broadcastReceiver;

  private Toast toast;
  private Intent myInt;

  private BottomNavigationView.OnNavigationItemSelectedListener navListener =
          new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
              switch (item.getItemId()){
                case R.id.nav_home:
                  myInt = new Intent(BerandaActivity.this, Home.class);
                  startActivity(myInt);
                  break;
                case R.id.nav_categories:
                  toast = Toast.makeText(getApplicationContext(),"Categories selected, but no action!",Toast.LENGTH_SHORT);
                  toast.show();
                  break;
              }
              return true;
            }
          };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_beranda);

    photographerRecView = findViewById(R.id.photographerRecView);

    PhotographersRecViewAdapter adapter = new PhotographersRecViewAdapter(this);
    adapter.setPhotographers(SampleDataSet.getInstance().getAllPhotographers());

    photographerRecView.setAdapter(adapter);
    photographerRecView.setLayoutManager(new GridLayoutManager(this, 2));

    BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
    bottomNav.setOnNavigationItemSelectedListener(navListener);

    broadcastReceiver = new BroadcastReceiver() {
      @Override
      public void onReceive(Context arg0, Intent intent) {
        String action = intent.getAction();
        if (action.equals("finish_all_activity")) {
          Log.d("OnReceiveTest", "Beranda Finished");
          finish();
        }
      }
    };
    registerReceiver(broadcastReceiver, new IntentFilter("finish_all_activity"));
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    unregisterReceiver(broadcastReceiver);
  }
}
