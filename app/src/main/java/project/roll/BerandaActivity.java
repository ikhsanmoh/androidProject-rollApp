package project.roll;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import project.roll.adapter.PhotographersRecViewAdapter;
import project.roll.model.Photographer;

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

    ArrayList<Photographer> photographers = new ArrayList<>();
    photographers.add(new Photographer(
            1,
            "Dasya",
            "https://images.squarespace-cdn.com/content/v1/58febac49f7456d3c6db76d2/1502494345038-U5EHTN6D3RR91MCK0RNW/ke17ZwdGBToddI8pDm48kNO2SymwcR0CNt03aX8zdCd7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z5QHyNOqBUUEtDDsRWrJLTmyh-8_5GJNvrfz4o4yOfLS6zQbzUiTKHw9oGJVKerm66NTpMeMsHjVpXC93GFBavO/image-asset.jpeg"
    ));
    photographers.add(new Photographer(
            2,
            "Dave",
            "https://images.squarespace-cdn.com/content/v1/59d55d412aeba54362e00bb1/1547328988541-D732YCKXID8578E23KGT/ke17ZwdGBToddI8pDm48kIB81VOvDNGxlwJI2ZLVYNF7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z5QHyNOqBUUEtDDsRWrJLTm1v6GcKqh6mrhfxzW2tqo7zqSP1_RWubdYwvOv9fJrXjTUsmG1v8Fm830lrrc_XKd/_DSC7599ashleebrookecrop.jpg"
    ));
    photographers.add(new Photographer(
            3,
            "Ryuji",
            "https://images.squarespace-cdn.com/content/v1/58809eab1e5b6c46d95f3e72/1569484495705-ENC3OCQ0Z7025ZSFBBEC/ke17ZwdGBToddI8pDm48kM19vGfAY4CpRvzWg9j4Rs97gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z5QPOohDIaIeljMHgDF5CVlOqpeNLcJ80NK65_fV7S1Ucs6qC7sr7nMoIk6RghKQ5zqaVLBrlbIpJKi9eKqHOg0LjA7Zh6OR0YZYaXtoY39jA/Ryuji+Photo+My+Tokyo+photographer+profile+japan+photo+session+01.jpg"
    ));

    PhotographersRecViewAdapter adapter = new PhotographersRecViewAdapter(this);
    adapter.setPhotographers(photographers);

    photographerRecView.setAdapter(adapter);
    photographerRecView.setLayoutManager(new GridLayoutManager(this, 2));

    BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
    bottomNav.setOnNavigationItemSelectedListener(navListener);
  }
}
