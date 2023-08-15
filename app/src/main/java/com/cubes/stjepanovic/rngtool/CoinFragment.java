package com.cubes.stjepanovic.rngtool;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cubes.stjepanovic.rngtool.databinding.FragmentCoinBinding;

import java.util.Random;


public class CoinFragment extends Fragment {

    private FragmentCoinBinding binding;

    public CoinFragment() {

    }




    public static CoinFragment newInstance() {
        CoinFragment fragment = new CoinFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentCoinBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        binding.imageViewCoin.setImageResource(R.drawable.coinquestion);
        binding.textViewResult.setTextColor(Color.parseColor("#D8E3E4"));
        binding.textViewResult.setBackgroundColor(Color.parseColor("#D8E3E4"));




        binding.imageViewCoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onCoinClick();
            }


        });



    }
    private void onCoinClick() {


       binding.imageViewCoin.setImageResource(R.drawable.coinquestion);
       binding.textViewResult.setTextColor(Color.parseColor("#D8E3E4"));
        binding.textViewResult.setBackgroundColor(Color.parseColor("#D8E3E4"));


        Random random = new Random();

        int numb = random.nextInt(2-1+1)+1;

        if (numb==1){
            onFlip(R.drawable.coingheads,"HEADS");
        }
        else  if (numb==2){
            onFlip(R.drawable.cointails,"TAILS");
        }



    }

    private void onFlip(int coinId, String side){


        binding.imageViewCoin.setClickable(false);


        binding.imageViewCoin.animate().setDuration(1000).rotationYBy(720f).withEndAction(new Runnable() {
            @Override
            public void run() {

                binding.textViewResult.setText(side);

                binding.imageViewCoin.setImageResource(coinId);

                binding.imageViewCoin.setClickable(true);
                binding.textViewResult.setTextColor(Color.parseColor("#FFFFFF"));
                binding.textViewResult.setBackgroundColor(Color.parseColor("#6A6A6A"));



            }
        }).start();
    }


}