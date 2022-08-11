package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class bmiActivity extends AppCompatActivity {


    android.widget.Button button;
    TextView mBMIDisplay,mBMICategory,mGender;
    Intent intent;
    ImageView mImageView;
    String mBMI;
    Float intBMI;
    String height;
    String weight;
    float intHeight, intWeight;
    RelativeLayout mBackground;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font Color = \"White\"></font>" ));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);


        intent = getIntent();
        mBMIDisplay = findViewById(R.id.bmiDisplay);
        mBMICategory = findViewById(R.id.bmiCategory);
        mGender = findViewById(R.id.genderDisplay);
        mBackground = findViewById(R.id.contentLayout);
        mImageView =findViewById(R.id.imageView);
        button = findViewById(R.id.reCalculateBMI);


        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        intHeight = Float.parseFloat(height);
        intWeight = Float.parseFloat(weight);

        intHeight = intHeight/100;

        intBMI = intWeight/ (intHeight * intHeight);

        mBMI = Float.toString(intBMI);


        if (intBMI<16){

            mBMICategory.setText("Severe Thinness");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.crosss);
        }
        else if (intBMI<16.9 && intBMI>16){
            mBMICategory.setText("Moderate Thinness");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.warning);
        }
        else if (intBMI<18.4 && intBMI>17){
            mBMICategory.setText("Mild Thinness");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.warning);
        }

        else if (intBMI<25 && intBMI>18.4){

            mBMICategory.setText("Normal");
            //mBackground.setBackgroundColor(Color.YELLOW);
            mImageView.setImageResource(R.drawable.ok);
        }
        else if (intBMI<29.4 && intBMI>25){

            mBMICategory.setText("Over Weight");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.warning);
        }
        else{
            mBMICategory.setText("Obese Class");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.warning);
        }

        mGender.setText(intent.getStringExtra("gender"));
        mBMIDisplay.setText(mBMI);





        
        getSupportActionBar().hide();
        
        button = findViewById(R.id.reCalculateBMI);
        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bmiActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        
    }
}