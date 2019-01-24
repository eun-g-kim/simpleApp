package com.example.example;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    private TextView ctr;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("ex");  //타이틀 공백처리

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //왼쪽에 home버튼 (뒤로가기 버튼 추가)
        getSupportActionBar().setHomeAsUpIndicator(Drawable.createFromPath("@android:drawable/ic_menu_sort_by_size"));  //home 버튼 모양 변경 가능

        ctr = findViewById(R.id.counter);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.g_map);
        mapFragment.getMapAsync(this);
        ctr.setOnClickListener(ctrListener); //리스너 부착
    }

    //추가된 소스, ToolBar에 menu.xml을 인플레이트함
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    //추가된 소스, ToolBar에 추가된 항목의 select 이벤트를 처리하는 함수
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.menu_edit:
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(getApplicationContext(), "편집 버튼 클릭됨", Toast.LENGTH_LONG).show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                Toast.makeText(getApplicationContext(), "나머지 버튼 클릭됨", Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item);

        }
    }


    public void onClick(View view) {
    }

    //map 관련- 출처:http://www.zoftino.com/android-google-maps-tutorial
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //seattle coordinates
        LatLng seattle = new LatLng(47.6062095, -122.3320708);
        mMap.addMarker(new MarkerOptions().position(seattle).title("Seattle"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(seattle));
    }

    View.OnClickListener ctrListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "클릭됨", Toast.LENGTH_LONG).show();
        }
    };
}

