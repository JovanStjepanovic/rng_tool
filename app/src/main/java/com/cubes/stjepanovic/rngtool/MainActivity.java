package com.cubes.stjepanovic.rngtool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.cubes.stjepanovic.rngtool.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


         getSupportFragmentManager().beginTransaction().replace(R.id.Main,CoinFragment.newInstance()).commit();





        binding.bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                Fragment selectetFragment = null;

                switch (item.getItemId()){

                    case R.id.coinFlip:

                        selectetFragment=CoinFragment.newInstance();

                     break;


                    case R.id.numberGenerator:

                        selectetFragment=RNGFragment.newInstance();

                        break;


                    case R.id.diceThrow:

                        selectetFragment=DiceFragment.newInstance();

                        break;


                }



                getSupportFragmentManager().beginTransaction().replace(R.id.Main,selectetFragment).commit();






                return true;
            }
        });

    }
}