package com.vigneshelumalai.calci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.DecimalFormat;

public class AcademicsActivity extends AppCompatActivity {
    private static String MY_PREFS = "switch_prefs";
    private static String THEME_STATUS = "dark_mode";

    LinearLayout llAcademicsSemester1,llAcademicsSemester2,llAcademicsSemester3,llAcademicsSemester4;
    LinearLayout llAcademicsSemester5,llAcademicsSemester6,llAcademicsSemester7,llAcademicsSemester8;
    LinearLayout llAcademicsCGPA;

    TextView tvAcademicsSemester1,tvAcademicsSemester2,tvAcademicsSemester3,tvAcademicsSemester4;
    TextView tvAcademicsSemester5,tvAcademicsSemester6,tvAcademicsSemester7,tvAcademicsSemester8;
    TextView tvAcademicsCGPA,tvAcademicsProfileName,tvReset;

    ImageView ivAcademicsProfilePhoto;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academics);
        linkingViews();

        sharedPreferences = getSharedPreferences("secondToAcademics", MODE_PRIVATE);
        editor = getSharedPreferences("secondToAcademics", MODE_PRIVATE).edit();

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        Glide.with(this).load(currentUser.getPhotoUrl()).centerCrop()
                .placeholder(R.drawable.ellipse).into(ivAcademicsProfilePhoto);
        Glide.with(AcademicsActivity.this)
                .load(currentUser.getPhotoUrl()) // add your image url
                .transform(new CircleTransform(AcademicsActivity.this)) // applying the image transformer
                .into(ivAcademicsProfilePhoto);
        tvAcademicsProfileName.setText(currentUser.getDisplayName());


        //Getting Current screen density
        Float resolution = getResources().getDisplayMetrics().density;
        int res=1;
        switch (String.valueOf(resolution)){
            case "1.5": res = res + (1/2);
            break;
            case "2.0": res = res + 1;
            break;
            case "3.0": res = res + 2;
            break;
            case "4.0": res = res + 3;
            break;
        }

        int fillHeightOne = (int)sharedPreferences.getFloat("Sem1FillValue",0);

        ViewGroup.LayoutParams lp1 = llAcademicsSemester1.getLayoutParams();
        lp1.height = fillHeightOne*res;
        llAcademicsSemester1.setLayoutParams(lp1);

        int fillHeightTwo = (int)sharedPreferences.getFloat("Sem2FillValue",0);
        ViewGroup.LayoutParams lp2 = llAcademicsSemester2.getLayoutParams();
        lp2.height = fillHeightTwo*res;
        llAcademicsSemester2.setLayoutParams(lp2);

        int fillHeightThree = (int)sharedPreferences.getFloat("Sem3FillValue",0);
        ViewGroup.LayoutParams lp3 = llAcademicsSemester3.getLayoutParams();
        lp3.height = fillHeightThree*res;
        llAcademicsSemester3.setLayoutParams(lp3);

        int fillHeightFour = (int)sharedPreferences.getFloat("Sem4FillValue",0);
        ViewGroup.LayoutParams lp4 = llAcademicsSemester4.getLayoutParams();
        lp4.height = fillHeightFour*res;
        llAcademicsSemester4.setLayoutParams(lp4);

        int fillHeightFive = (int)sharedPreferences.getFloat("Sem5FillValue",0);
        ViewGroup.LayoutParams lp5 = llAcademicsSemester5.getLayoutParams();
        lp5.height = fillHeightFive*res;
        llAcademicsSemester5.setLayoutParams(lp5);

        int fillHeightSix = (int)sharedPreferences.getFloat("Sem6FillValue",0);
        ViewGroup.LayoutParams lp6 = llAcademicsSemester6.getLayoutParams();
        lp6.height = fillHeightSix*res;
        llAcademicsSemester6.setLayoutParams(lp6);

        int fillHeightSeven = (int)sharedPreferences.getFloat("Sem7FillValue",0);
        ViewGroup.LayoutParams lp7 = llAcademicsSemester7.getLayoutParams();
        lp7.height = fillHeightSeven*res;
        llAcademicsSemester7.setLayoutParams(lp7);

        int fillHeightEight= (int)sharedPreferences.getFloat("Sem8FillValue",0);
        ViewGroup.LayoutParams lp8 = llAcademicsSemester8.getLayoutParams();
        lp8.height = fillHeightEight*res;
        llAcademicsSemester8.setLayoutParams(lp8);

        int fillHeightCGPA= (int)sharedPreferences.getFloat("CGPAFillValue",0);
        ViewGroup.LayoutParams lpCGPA = llAcademicsCGPA.getLayoutParams();
        lpCGPA.height = fillHeightCGPA*res;
        llAcademicsCGPA.setLayoutParams(lpCGPA);

        tvAcademicsSemester1.setText(sharedPreferences.getString("Sem1Value","0"));
        tvAcademicsSemester2.setText(sharedPreferences.getString("Sem2Value","0"));
        tvAcademicsSemester3.setText(sharedPreferences.getString("Sem3Value","0"));
        tvAcademicsSemester4.setText(sharedPreferences.getString("Sem4Value","0"));
        tvAcademicsSemester5.setText(sharedPreferences.getString("Sem5Value","0"));
        tvAcademicsSemester6.setText(sharedPreferences.getString("Sem6Value","0"));
        tvAcademicsSemester7.setText(sharedPreferences.getString("Sem7Value","0"));
        tvAcademicsSemester8.setText(sharedPreferences.getString("Sem7Value","0"));

        DecimalFormat df = new DecimalFormat("#.###");
        Float returnedCGPAValue = sharedPreferences.getFloat("CGPAValue",0);
        String finalCGPA = df.format(returnedCGPAValue);
        tvAcademicsCGPA.setText(finalCGPA);

        //Resetting Values onClick
        tvReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.apply();
                tvAcademicsSemester1.setText("0");
                tvAcademicsSemester2.setText("0");
                tvAcademicsSemester3.setText("0");
                tvAcademicsSemester4.setText("0");
                tvAcademicsSemester5.setText("0");
                tvAcademicsSemester6.setText("0");
                tvAcademicsSemester7.setText("0");
                tvAcademicsSemester8.setText("0");
                tvAcademicsCGPA.setText("0");
                lp1.height = 0;
                llAcademicsSemester1.setLayoutParams(lp1);
                lp2.height = 0;
                llAcademicsSemester2.setLayoutParams(lp1);
                lp3.height = 0;
                llAcademicsSemester3.setLayoutParams(lp1);
                lp4.height = 0;
                llAcademicsSemester4.setLayoutParams(lp1);
                lp5.height = 0;
                llAcademicsSemester5.setLayoutParams(lp1);
                lp6.height = 0;
                llAcademicsSemester6.setLayoutParams(lp1);
                lp7.height = 0;
                llAcademicsSemester7.setLayoutParams(lp1);
                lp8.height = 0;
                llAcademicsSemester8.setLayoutParams(lp1);
                lpCGPA.height = 0;
                llAcademicsSemester8.setLayoutParams(lpCGPA);

            }
        });
    }
    public void linkingViews(){
        ivAcademicsProfilePhoto = (ImageView) findViewById(R.id.ivAcademicsProfilePhoto);
        tvAcademicsProfileName = (TextView) findViewById(R.id.tvAcademicsProfileName);

        tvAcademicsSemester1= (TextView) findViewById(R.id.tvAcademicsSemester1);
        tvAcademicsSemester2= (TextView) findViewById(R.id.tvAcademicsSemester2);
        tvAcademicsSemester3= (TextView) findViewById(R.id.tvAcademicsSemester3);
        tvAcademicsSemester4= (TextView) findViewById(R.id.tvAcademicsSemester4);
        tvAcademicsSemester5= (TextView) findViewById(R.id.tvAcademicsSemester5);
        tvAcademicsSemester6= (TextView) findViewById(R.id.tvAcademicsSemester6);
        tvAcademicsSemester7= (TextView) findViewById(R.id.tvAcademicsSemester7);
        tvAcademicsSemester8= (TextView) findViewById(R.id.tvAcademicsSemester8);

        tvReset= (TextView) findViewById(R.id.tvReset);

        tvAcademicsCGPA= (TextView) findViewById(R.id.tvAcademicsCGPA);

        llAcademicsSemester1 = (LinearLayout) findViewById(R.id.llAcademicsSemester1);
        llAcademicsSemester2 = (LinearLayout) findViewById(R.id.llAcademicsSemester2);
        llAcademicsSemester3 = (LinearLayout) findViewById(R.id.llAcademicsSemester3);
        llAcademicsSemester4 = (LinearLayout) findViewById(R.id.llAcademicsSemester4);
        llAcademicsSemester5 = (LinearLayout) findViewById(R.id.llAcademicsSemester5);
        llAcademicsSemester6 = (LinearLayout) findViewById(R.id.llAcademicsSemester6);
        llAcademicsSemester7 = (LinearLayout) findViewById(R.id.llAcademicsSemester7);
        llAcademicsSemester8 = (LinearLayout) findViewById(R.id.llAcademicsSemester8);

        llAcademicsCGPA = (LinearLayout) findViewById(R.id.llAcademicsCGPA);

    }

        @Override
        public void finish() {
            super.finish();
            overridePendingTransition(R.anim.from_left, R.anim.from_right);
        }

}