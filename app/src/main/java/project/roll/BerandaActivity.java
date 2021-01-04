package project.roll;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import project.roll.adapter.PhotographersRecViewAdapter;
import project.roll.utils.SampleDataSet;

public class BerandaActivity extends AppCompatActivity {

  private RecyclerView photographerRecView;

  private BottomNavigationView.OnNavigationItemSelectedListener navListener =
          new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
              Toast toast = null;

              switch (item.getItemId()){
                case R.id.nav_home:
                  toast = Toast.makeText(getApplicationContext(),"Home Selected",Toast.LENGTH_SHORT);
                  break;
                case R.id.nav_categories:
                  toast = Toast.makeText(getApplicationContext(),"Categories Selected",Toast.LENGTH_SHORT);
                  break;
              }
              toast.show();
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
  }
}
