package com.example.lotto_vote_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    Fragment fragmentCheckNum;
    Fragment fragmentPopNum;
    Fragment fragmentCombiNum;
    Fragment fragmentRankNum;
    Fragment active;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        startActivity(new Intent(this, LoadingActivity.class));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentCheckNum = new FragmentCheckNum();
        fragmentPopNum = new FragmentPopNum();
        fragmentCombiNum = new FragmentCombiNum();
        fragmentRankNum = new FragmentRankNum();

        active = fragmentCheckNum;
//
//
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.containerFr, fragmentRankNum, "4").hide(fragmentRankNum).commit();
        fm.beginTransaction().add(R.id.containerFr, fragmentCombiNum, "3").hide(fragmentCombiNum).commit();
        fm.beginTransaction().add(R.id.containerFr, fragmentPopNum, "2").hide(fragmentPopNum).commit();
        fm.beginTransaction().add(R.id.containerFr, fragmentCheckNum, "1").commit();
//        fm.beginTransaction().show(fragmentCheckNum).commit();

//        fm.beginTransaction().replace(R.id.containerFr,fragmentCheckNum).commit();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(
                new NavigationBarView.OnItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.check_num_bar:
//                                getSupportFragmentManager().beginTransaction().replace(R.id.containerFr, fragmentCheckNum).commit();
                                fm.beginTransaction().hide(active).show(fragmentCheckNum).commit();
                                active = fragmentCheckNum;
                                return true;
                            case R.id.pop_num_bar:
                                fm.beginTransaction().hide(active).show(fragmentPopNum).commit();
                                active = fragmentPopNum;
                                return true;
                            case R.id.comb_num_bar:
                                fm.beginTransaction().hide(active).show(fragmentCombiNum).commit();
                                active = fragmentCombiNum;
                                return true;
                            case R.id.rank_num_bar:
                                fm.beginTransaction().hide(active).show(fragmentRankNum).commit();
                                active = fragmentRankNum;
                                return true;
                        }
                        return false;
                    }

                }
        );

    }
}