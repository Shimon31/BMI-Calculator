package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.widget.Button mCalculateBmi;


    TextView mCurrentHeight;
    TextView mCurrentAge,mCurrentWeight;
    ImageView mIncrementAge,mIncrementWeight,mDecrementWeight,mDecrementAge;
    SeekBar mSeekBarForHeight;
    RelativeLayout mMale,mFemale;

    int intWeight = 55;
    int intAge = 21;
    int currentProgress;
    String mIntProgress = "170";
    String typeOfUser = "0";
    String weight2 = "55";
    String age2 = "21";









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        mCalculateBmi = findViewById(R.id.calculateBMI);
        mCurrentAge =findViewById(R.id.currentAge);
        mCurrentWeight = findViewById(R.id.currentWeight);
        mCurrentHeight = findViewById(R.id.currentHeight);
        mIncrementAge = findViewById(R.id.incrementAge);
        mDecrementAge = findViewById(R.id.decrementAge);
        mIncrementWeight = findViewById(R.id.incrementWeight);
        mDecrementWeight = findViewById(R.id.decrementWeight);
        mSeekBarForHeight = findViewById(R.id.seekBarForHeight);
        mMale = findViewById(R.id.male);
        mFemale = findViewById(R.id.female);



        mMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mFemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeOfUser = "Male";
            }
        });

        mFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mMale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeOfUser = "Female";
            }
        });


        mSeekBarForHeight.setMax(300);
        mSeekBarForHeight.setProgress(170);
        mSeekBarForHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentProgress = progress;
                mIntProgress = String.valueOf(currentProgress);
                mCurrentHeight.setText(mIntProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        mIncrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge = intAge + 1;
                age2 = String.valueOf(intAge);
                mCurrentAge.setText(age2);
            }
        });


        mDecrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge = intAge - 1;
                age2 = String.valueOf(intAge);
                mCurrentAge.setText(age2);
            }
        });


        mIncrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight = intWeight + 1;
                weight2 = String.valueOf(intWeight);
                mCurrentWeight.setText(weight2);
            }
        });


        mDecrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight = intWeight - 1;
                weight2 = String.valueOf(intWeight);
                mCurrentWeight.setText(weight2);
            }
        });



        mCalculateBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (typeOfUser.equals("0")){

                    Toast.makeText(MainActivity.this, "Select Your Gender First", Toast.LENGTH_SHORT).show();
                    
                }
                else if (mIntProgress.equals("0")){

                    Toast.makeText(MainActivity.this, "Select Your Height First", Toast.LENGTH_SHORT).show();
                }

                else if (intAge==0 || intAge<0){
                    Toast.makeText(MainActivity.this, "Age Is Incorrect", Toast.LENGTH_SHORT).show();
                }

                else if (intWeight==0 || intWeight<0){
                    Toast.makeText(MainActivity.this, "Weight Is Incorrect", Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent intent = new Intent(MainActivity.this,bmiActivity.class);

                    intent.putExtra("gender",typeOfUser);
                    intent.putExtra("height", mIntProgress);
                    intent.putExtra("weight",weight2);
                    intent.putExtra("age",age2);
                    startActivity(intent);

                }



            }
        });
    }
}