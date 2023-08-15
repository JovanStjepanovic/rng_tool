package com.cubes.stjepanovic.rngtool;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cubes.stjepanovic.rngtool.databinding.FragmentRNGBinding;

import java.util.Random;


public class RNGFragment extends Fragment {


    private FragmentRNGBinding binding;
  private Random random;
    int rng;
    public RNGFragment() {

    }



    public static RNGFragment newInstance() {
        RNGFragment fragment = new RNGFragment();

        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentRNGBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        binding.buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (binding.editTextLowerScale.getText().toString().length()>0 &&
                        binding.editTextUpperScale.getText().toString().length()>0){



                int lower= Integer.parseInt(binding.editTextLowerScale.getText().toString());
                int upper = Integer.parseInt(binding.editTextUpperScale.getText().toString());


                  if (upper>lower) {

                      random = new Random();

                      rng = random.nextInt(upper - lower + 1) + lower;


                      binding.textViewResult.setText(""+rng);

                  }

                  else {

                      Toast.makeText(binding.getRoot().getContext(), "OPSEG nije dobar", Toast.LENGTH_SHORT).show();
                  }






                }




            }
        });


    }
}