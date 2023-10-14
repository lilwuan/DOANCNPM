package edu.abcd.bcdddd.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import edu.abcd.bcdddd.R;
import edu.abcd.bcdddd.fragment.CuahangFragment;
import edu.abcd.bcdddd.fragment.DangnhapFragment;
import edu.abcd.bcdddd.fragment.DanhmucFragment;
import edu.abcd.bcdddd.fragment.TrangchinhFragment;
import edu.abcd.bcdddd.fragment.XemthemFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new TrangchinhFragment());

        BottomNavigationView  navigationView = findViewById(R.id.bottome_menu);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.trangchu:
                        replaceFragment(new TrangchinhFragment());
                        break;
                    case R.id.dangnhap:
                        replaceFragment(new DangnhapFragment());
                        break;
                    case R.id.danhmuc:
                        replaceFragment(new DanhmucFragment());
                        break;
                    case R.id.cuahang:
                        replaceFragment(new CuahangFragment());
                        break;
                    case R.id.xemthem:
                        replaceFragment(new XemthemFragment());
                        break;
                }
                return true;
            }
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}