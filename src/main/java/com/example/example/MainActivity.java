package com.example.example;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextView ctr;
    private ImageView img;
    private int value =3 ; //카운터 값
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       getSupportActionBar().setDisplayHomeAsUpEnabled(true); //왼쪽에 home버튼 (뒤로가기 버튼 추가)
       getSupportActionBar().setHomeAsUpIndicator(Drawable.createFromPath("@android:drawable/ic_menu_sort_by_size"));  //home 버튼 모양 변경 가능
        getSupportActionBar().setTitle("");   //타이틀 공백처리
        ctr = findViewById(R.id.counter);
        img = findViewById(R.id.mapImage);
        ctr.setText(Integer.toString(value)); //항상 0으로 초기화
        ctr.setOnClickListener(ctrListener); //리스너 부착
        img.setOnClickListener(imgListener);


    }

    View.OnClickListener ctrListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        //    Toast.makeText(getApplicationContext(), "클릭됨", Toast.LENGTH_LONG).show();
            img.setVisibility(View.VISIBLE);
          //  value++;
            ctr.setText(Integer.toString(value));
        }
    };
    View.OnClickListener imgListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          //  Toast.makeText(getApplicationContext(), "클릭됨", Toast.LENGTH_LONG).show();
            img.setVisibility(View.GONE);
        }
    };

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

}

