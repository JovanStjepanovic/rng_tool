package com.cubes.stjepanovic.rngtool;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cubes.stjepanovic.rngtool.databinding.FragmentDiceBinding;

import java.util.Random;


public class DiceFragment extends Fragment {

    private FragmentDiceBinding binding;

    public DiceFragment() {

    }




    public static DiceFragment newInstance() {
        DiceFragment fragment = new DiceFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentDiceBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.imageViewDie.setImageResource(R.drawable.dice3b);
        binding.buttonThrow.setText("THROW");

        binding.buttonThrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onDiceClick();
            }
        });





    }
     private void onDiceClick(){


         binding.imageViewDie.setImageResource(R.drawable.dice3b);

         Random random = new Random();

         int numb = random.nextInt(6-1+1)+1;


         if (numb==1){

             throwDice(R.drawable.dice1);

         }
         else if (numb==2) {
             throwDice(R.drawable.dice2);
         }

         else if (numb==3) {

             throwDice(R.drawable.dice3);
         }
         else if (numb==4) {
             throwDice(R.drawable.dicee4);

         }
         else if (numb==5) {

             throwDice(R.drawable.dice5);
         }
         else if (numb==6) {

             throwDice(R.drawable.dice6);

         }


    }


     private void throwDice(int id){

        binding.buttonThrow.setEnabled(false);
        binding.buttonThrow.setText("THROWING...");
        binding.imageViewDie.animate().setDuration(1000).rotationYBy(360f).rotationXBy(360f).withEndAction(new Runnable() {
            @Override
            public void run() {

           binding.imageViewDie.setImageResource(id);
           binding.buttonThrow.setEnabled(true);
           binding.buttonThrow.setText("THROW");


            }
        }).start();
     }
















}