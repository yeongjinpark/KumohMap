package com.energizo.kumohmap.view.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.energizo.kumohmap.R;
import com.energizo.kumohmap.utill.BackPressHandler;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity  extends AppCompatActivity {
    // 뒤로가기 버튼 작업
    private BackPressHandler bp;

    //바텀네비&각 페이지
    private BottomNavigationView bottomNavi;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private MenuMap menu_map;
    private Menu2 menu2;
    private Menu3 menu3;
    private Menu4 menu4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bp = new BackPressHandler(this);
        menu_map = new MenuMap();
        menu2 = new Menu2();
        menu3 = new Menu3();
        menu4 = new Menu4();
        bottomNavi = findViewById(R.id.bottom_main);

        bottomNavi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navi_map:
                        setFrag(0);
                        break;
                    case R.id.navi_two:
                        setFrag(1);
                        break;
                    case R.id.navi_three:
                        setFrag(2);
                        break;
                    case R.id.navi_four:
                        setFrag(3);
                        break;
                }
                return true;
            }
        });

        setFrag(0);

    }



    private void setFrag(int i){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (i){
            case 0:
                ft.replace(R.id.frame_main,menu_map).commit();
                break;
            case 1:
                ft.replace(R.id.frame_main,menu2).commit();
                break;
            case 2:
                ft.replace(R.id.frame_main,menu3).commit();
                break;
            case 3:
                ft.replace(R.id.frame_main, menu4).commit();
                break;
        }
        
    }

    @Override
    public void onBackPressed() {
        bp.onBackPressed(3000);
    }
}