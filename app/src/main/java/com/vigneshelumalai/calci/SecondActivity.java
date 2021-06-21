package com.vigneshelumalai.calci;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    AppCompatButton btnSem1, btnSem2, btnSem3, btnSem4, btnSem5, btnSem6, btnSem7, btnSem8, btnCGPA;
    AppCompatButton btnSaveSecondActivity;
    String choice;
    float cgpaNum;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    AppCompatEditText etSem1, etSem2, etSem3, etSem4, etSem5, etSem6, etSem7, etSem8;
    TextView tvCGPA, tvSubject;
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.toast_layout));
        TextView tvToastMessage = (TextView) layout.findViewById(R.id.tvToastMessage);
        final Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);


        btnSem1 = (AppCompatButton) findViewById(R.id.btnSem1);
        btnSem2 = (AppCompatButton) findViewById(R.id.btnSem2);
        btnSem3 = (AppCompatButton) findViewById(R.id.btnSem3);
        btnSem4 = (AppCompatButton) findViewById(R.id.btnSem4);
        btnSem5 = (AppCompatButton) findViewById(R.id.btnSem5);
        btnSem6 = (AppCompatButton) findViewById(R.id.btnSem6);
        btnSem7 = (AppCompatButton) findViewById(R.id.btnSem7);
        btnSem8 = (AppCompatButton) findViewById(R.id.btnSem8);
        btnCGPA = (AppCompatButton) findViewById(R.id.btnCGPA);


        btnSaveSecondActivity = (AppCompatButton) findViewById(R.id.btnSaveActivitySecond);
        btnSaveSecondActivity.setVisibility(View.INVISIBLE);

        etSem1 = (AppCompatEditText) findViewById(R.id.etSem1);
        etSem2 = (AppCompatEditText) findViewById(R.id.etSem2);
        etSem3 = (AppCompatEditText) findViewById(R.id.etSem3);
        etSem4 = (AppCompatEditText) findViewById(R.id.etSem4);
        etSem5 = (AppCompatEditText) findViewById(R.id.etSem5);
        etSem6 = (AppCompatEditText) findViewById(R.id.etSem6);
        etSem7 = (AppCompatEditText) findViewById(R.id.etSem7);
        etSem8 = (AppCompatEditText) findViewById(R.id.etSem8);
        tvCGPA = (TextView) findViewById(R.id.tvCGPA);
        tvSubject = (TextView) findViewById(R.id.tvSubject);
        tvCGPA.setVisibility(View.INVISIBLE);
        btnSem1.setOnClickListener(this);
        btnSem2.setOnClickListener(this);
        btnSem3.setOnClickListener(this);
        btnSem4.setOnClickListener(this);
        btnSem5.setOnClickListener(this);
        btnSem6.setOnClickListener(this);
        btnSem7.setOnClickListener(this);
        btnSem8.setOnClickListener(this);
        Intent intent = getIntent();
        choice = intent.getStringExtra("dept");
        Log.i("catch", choice);
        btnCGPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                if (etSem1.getText().toString().isEmpty() && (
                        etSem2.getText().toString().trim().length() > 0 ||
                                etSem3.getText().toString().trim().length() > 0 ||
                                etSem4.getText().toString().trim().length() > 0 ||
                                etSem5.getText().toString().trim().length() > 0 ||
                                etSem6.getText().toString().trim().length() > 0 ||
                                etSem7.getText().toString().trim().length() > 0 ||
                                etSem8.getText().toString().trim().length() > 0)) {
                    tvToastMessage.setText("Enter values in order");
                    toast.show();
                    tvCGPA.setVisibility(View.INVISIBLE);
                }
                if (etSem1.getText().toString().trim().length() > 0 ||
                        etSem2.getText().toString().trim().length() > 0 ||
                        etSem3.getText().toString().trim().length() > 0 ||
                        etSem4.getText().toString().trim().length() > 0 ||
                        etSem5.getText().toString().trim().length() > 0 ||
                        etSem6.getText().toString().trim().length() > 0 ||
                        etSem7.getText().toString().trim().length() > 0 ||
                        etSem8.getText().toString().trim().length() > 0) {
                    if (etSem1.getText().toString().trim().length() > 0) {
                        if (etSem3.getText().toString().trim().length() > 0 ||
                                etSem4.getText().toString().trim().length() > 0 ||
                                etSem5.getText().toString().trim().length() > 0 ||
                                etSem6.getText().toString().trim().length() > 0 ||
                                etSem7.getText().toString().trim().length() > 0 ||
                                etSem8.getText().toString().trim().length() > 0) {
                            tvToastMessage.setText("Enter values in order");
                            toast.show();
                            tvCGPA.setVisibility(View.INVISIBLE);
                            btnSaveSecondActivity.setVisibility(View.INVISIBLE);
                        } else {
                            btnSaveSecondActivity.setVisibility(View.VISIBLE);
                            cgpaNum = Float.parseFloat(etSem1.getText().toString().trim());
                            btnSaveSecondActivity.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    sharedPreferences = getSharedPreferences("secondToAcademics", MODE_PRIVATE);
                                    editor = getSharedPreferences("secondToAcademics", MODE_PRIVATE).edit();
                                    editor.clear();
                                    editor.apply();
                                    editor.putString("Sem1Value", (String.valueOf(cgpaNum)));
                                    Float fillHeight = ((cgpaNum * 10) / 100) * 92;
                                    Float cgpaFillHeight = ((cgpaNum * 10) / 100) * 398;
                                    editor.putFloat("Sem1FillValue", fillHeight);
                                    editor.putFloat("CGPAValue", cgpaNum / (float) 1);
                                    editor.putFloat("CGPAFillValue", cgpaFillHeight);
                                    editor.apply();
                                    tvToastMessage.setText("Saved to Your Academics");
                                    toast.show();

                                }
                            });
                            cgpaNum = (float) cgpaNum / (float) 1;

                        }
                    }

                    if (etSem1.getText().toString().trim().length() > 0 &&
                            etSem2.getText().toString().trim().length() > 0) {
                        if (etSem4.getText().toString().trim().length() > 0 ||
                                etSem5.getText().toString().trim().length() > 0 ||
                                etSem6.getText().toString().trim().length() > 0 ||
                                etSem7.getText().toString().trim().length() > 0 ||
                                etSem8.getText().toString().trim().length() > 0) {
                            tvToastMessage.setText("Enter values in order");
                            toast.show();
                            tvCGPA.setVisibility(View.INVISIBLE);
                            btnSaveSecondActivity.setVisibility(View.INVISIBLE);
                        } else {
                            btnSaveSecondActivity.setVisibility(View.VISIBLE);
                            Float gpa1 = Float.parseFloat(etSem1.getText().toString().trim());
                            Float gpa2 = Float.parseFloat(etSem2.getText().toString().trim());
                            cgpaNum = gpa1 + gpa2;
                            btnSaveSecondActivity.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    sharedPreferences = getSharedPreferences("secondToAcademics", MODE_PRIVATE);
                                    editor = getSharedPreferences("secondToAcademics", MODE_PRIVATE).edit();
                                    editor.clear();
                                    editor.apply();
                                    editor.putString("Sem1Value", (String.valueOf(gpa1)));
                                    editor.putString("Sem2Value", (String.valueOf(gpa2)));
                                    Float fillHeight1 = ((gpa1 * 10) / 100) * 92;
                                    Float fillHeight2 = ((gpa2 * 10) / 100) * 92;
                                    Float fillCGPAHeight = ((cgpaNum * 10) / 100) * 398;
                                    Log.i("tagme1", String.valueOf(cgpaNum));

                                    editor.putFloat("Sem1FillValue", fillHeight1);
                                    editor.putFloat("Sem2FillValue", fillHeight2);
                                    editor.putFloat("CGPAValue", cgpaNum);
                                    Log.i("tagme", String.valueOf(cgpaNum));
                                    editor.putFloat("CGPAFillValue", fillCGPAHeight);
                                    editor.apply();
                                    tvToastMessage.setText("Saved to Your Academics");
                                    toast.show();

                                }
                            });
                            Log.i("tagme", String.valueOf(cgpaNum));
                            cgpaNum = cgpaNum / (float) 2;
                        }
                    }
                    if (etSem1.getText().toString().trim().length() > 0 &&
                            etSem2.getText().toString().trim().length() > 0 &&
                            etSem3.getText().toString().trim().length() > 0) {
                        if (etSem5.getText().toString().trim().length() > 0 ||
                                etSem6.getText().toString().trim().length() > 0 ||
                                etSem7.getText().toString().trim().length() > 0 ||
                                etSem8.getText().toString().trim().length() > 0) {
                            tvToastMessage.setText("Enter values in order");
                            toast.show();
                            tvCGPA.setVisibility(View.INVISIBLE);
                            btnSaveSecondActivity.setVisibility(View.INVISIBLE);
                        } else {
                            btnSaveSecondActivity.setVisibility(View.VISIBLE);
                            Float gpa1 = Float.parseFloat(etSem1.getText().toString().trim());
                            Float gpa2 = Float.parseFloat(etSem2.getText().toString().trim());
                            Float gpa3 = Float.parseFloat(etSem3.getText().toString().trim());
                            cgpaNum = +gpa1 + gpa2 + gpa3;
                            btnSaveSecondActivity.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    sharedPreferences = getSharedPreferences("secondToAcademics", MODE_PRIVATE);
                                    editor = getSharedPreferences("secondToAcademics", MODE_PRIVATE).edit();
                                    editor.clear();
                                    editor.apply();
                                    editor.putString("Sem1Value", (String.valueOf(gpa1)));
                                    editor.putString("Sem2Value", (String.valueOf(gpa2)));
                                    editor.putString("Sem3Value", (String.valueOf(gpa3)));
                                    Float fillHeight1 = ((gpa1 * 10) / 100) * 92;
                                    Float fillHeight2 = ((gpa2 * 10) / 100) * 92;
                                    Float fillHeight3 = ((gpa3 * 10) / 100) * 92;
                                    Float cgpaFillHeight = (((cgpaNum * 10)) / 100) * 398;
                                    editor.putFloat("Sem1FillValue", fillHeight1);
                                    editor.putFloat("Sem2FillValue", fillHeight2);
                                    editor.putFloat("Sem3FillValue", fillHeight3);
                                    editor.putFloat("CGPAValue", cgpaNum);
                                    editor.putFloat("CGPAFillValue", cgpaFillHeight);
                                    editor.apply();
                                    tvToastMessage.setText("Saved to Your Academics");
                                    toast.show();

                                }
                            });
                            cgpaNum = cgpaNum / (float) 3;
                        }
                    }
                    if (etSem1.getText().toString().trim().length() > 0 &&
                            etSem2.getText().toString().trim().length() > 0 &&
                            etSem3.getText().toString().trim().length() > 0 &&
                            etSem4.getText().toString().trim().length() > 0) {
                        if (etSem6.getText().toString().trim().length() > 0 ||
                                etSem7.getText().toString().trim().length() > 0 ||
                                etSem8.getText().toString().trim().length() > 0) {
                            tvToastMessage.setText("Enter values in order");
                            toast.show();
                            tvCGPA.setVisibility(View.INVISIBLE);
                            btnSaveSecondActivity.setVisibility(View.INVISIBLE);
                        } else {
                            btnSaveSecondActivity.setVisibility(View.VISIBLE);
                            Float gpa1 = Float.parseFloat(etSem1.getText().toString().trim());
                            Float gpa2 = Float.parseFloat(etSem2.getText().toString().trim());
                            Float gpa3 = Float.parseFloat(etSem3.getText().toString().trim());
                            Float gpa4 = Float.parseFloat(etSem4.getText().toString().trim());
                            cgpaNum = +gpa1 + gpa2 + gpa3 + gpa4;
                            btnSaveSecondActivity.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    sharedPreferences = getSharedPreferences("secondToAcademics", MODE_PRIVATE);
                                    editor = getSharedPreferences("secondToAcademics", MODE_PRIVATE).edit();
                                    editor.clear();
                                    editor.apply();
                                    editor.putString("Sem1Value", (String.valueOf(gpa1)));
                                    editor.putString("Sem2Value", (String.valueOf(gpa2)));
                                    editor.putString("Sem3Value", (String.valueOf(gpa3)));
                                    editor.putString("Sem4Value", (String.valueOf(gpa4)));
                                    Float fillHeight1 = ((gpa1 * 10) / 100) * 92;
                                    Float fillHeight2 = ((gpa2 * 10) / 100) * 92;
                                    Float fillHeight3 = ((gpa3 * 10) / 100) * 92;
                                    Float fillHeight4 = ((gpa4 * 10) / 100) * 92;
                                    Float cgpaFillHeight = ((cgpaNum * 10) / 100) * 398;
                                    editor.putFloat("Sem1FillValue", fillHeight1);
                                    editor.putFloat("Sem2FillValue", fillHeight2);
                                    editor.putFloat("Sem3FillValue", fillHeight3);
                                    editor.putFloat("Sem4FillValue", fillHeight4);
                                    editor.putFloat("CGPAValue", cgpaNum);
                                    editor.putFloat("CGPAFillValue", cgpaFillHeight);
                                    editor.apply();
                                    tvToastMessage.setText("Saved to Your Academics");
                                    toast.show();

                                }
                            });

                            cgpaNum = cgpaNum / (float) 4;
                        }
                    }
                    if (etSem1.getText().toString().trim().length() > 0 &&
                            etSem2.getText().toString().trim().length() > 0 &&
                            etSem3.getText().toString().trim().length() > 0 &&
                            etSem4.getText().toString().trim().length() > 0 &&
                            etSem5.getText().toString().trim().length() > 0) {
                        if (etSem7.getText().toString().trim().length() > 0 ||
                                etSem8.getText().toString().trim().length() > 0) {
                            tvToastMessage.setText("Enter values in order");
                            toast.show();
                            tvCGPA.setVisibility(View.INVISIBLE);
                            btnSaveSecondActivity.setVisibility(View.INVISIBLE);
                        } else {
                            btnSaveSecondActivity.setVisibility(View.VISIBLE);
                            Float gpa1 = Float.parseFloat(etSem1.getText().toString().trim());
                            Float gpa2 = Float.parseFloat(etSem2.getText().toString().trim());
                            Float gpa3 = Float.parseFloat(etSem3.getText().toString().trim());
                            Float gpa4 = Float.parseFloat(etSem4.getText().toString().trim());
                            Float gpa5 = Float.parseFloat(etSem5.getText().toString().trim());
                            cgpaNum = +gpa1 + gpa2 + gpa3 + gpa4 + gpa5;
                            btnSaveSecondActivity.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    sharedPreferences = getSharedPreferences("secondToAcademics", MODE_PRIVATE);
                                    editor = getSharedPreferences("secondToAcademics", MODE_PRIVATE).edit();
                                    editor.clear();
                                    editor.apply();
                                    editor.putString("Sem1Value", (String.valueOf(gpa1)));
                                    editor.putString("Sem2Value", (String.valueOf(gpa2)));
                                    editor.putString("Sem3Value", (String.valueOf(gpa3)));
                                    editor.putString("Sem4Value", (String.valueOf(gpa4)));
                                    editor.putString("Sem5Value", (String.valueOf(gpa5)));
                                    Float fillHeight1 = ((cgpaNum * 10) / 100) * 92;
                                    Float fillHeight2 = ((cgpaNum * 10) / 100) * 92;
                                    Float fillHeight3 = ((cgpaNum * 10) / 100) * 92;
                                    Float fillHeight4 = ((cgpaNum * 10) / 100) * 92;
                                    Float fillHeight5 = ((cgpaNum * 10) / 100) * 92;
                                    Float cgpaFillHeight = (((cgpaNum * 10)) / 100) * 398;
                                    editor.putFloat("Sem1FillValue", fillHeight1);
                                    editor.putFloat("Sem2FillValue", fillHeight2);
                                    editor.putFloat("Sem3FillValue", fillHeight3);
                                    editor.putFloat("Sem4FillValue", fillHeight4);
                                    editor.putFloat("Sem5FillValue", fillHeight5);
                                    editor.putFloat("CGPAValue", cgpaNum);
                                    editor.putFloat("CGPAFillValue", cgpaFillHeight);
                                    editor.apply();
                                    tvToastMessage.setText("Saved to Your Academics");
                                    toast.show();

                                }
                            });
                            cgpaNum = cgpaNum / (float) 5;
                        }
                    }
                    if (etSem1.getText().toString().trim().length() > 0 &&
                            etSem2.getText().toString().trim().length() > 0 &&
                            etSem3.getText().toString().trim().length() > 0 &&
                            etSem4.getText().toString().trim().length() > 0 &&
                            etSem5.getText().toString().trim().length() > 0 &&
                            etSem6.getText().toString().trim().length() > 0) {
                        if (etSem8.getText().toString().trim().length() > 0) {
                            tvToastMessage.setText("Enter values in order");
                            toast.show();
                            tvCGPA.setVisibility(View.INVISIBLE);
                            btnSaveSecondActivity.setVisibility(View.INVISIBLE);
                        } else {
                            btnSaveSecondActivity.setVisibility(View.VISIBLE);
                            Float gpa1 = Float.parseFloat(etSem1.getText().toString().trim());
                            Float gpa2 = Float.parseFloat(etSem2.getText().toString().trim());
                            Float gpa3 = Float.parseFloat(etSem3.getText().toString().trim());
                            Float gpa4 = Float.parseFloat(etSem4.getText().toString().trim());
                            Float gpa5 = Float.parseFloat(etSem5.getText().toString().trim());
                            Float gpa6 = Float.parseFloat(etSem6.getText().toString().trim());
                            cgpaNum = +gpa1 + gpa2 + gpa3 + gpa4 + gpa5 + gpa6;
                            btnSaveSecondActivity.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    sharedPreferences = getSharedPreferences("secondToAcademics", MODE_PRIVATE);
                                    editor = getSharedPreferences("secondToAcademics", MODE_PRIVATE).edit();
                                    editor.clear();
                                    editor.apply();
                                    editor.putString("Sem1Value", (String.valueOf(gpa1)));
                                    editor.putString("Sem2Value", (String.valueOf(gpa2)));
                                    editor.putString("Sem3Value", (String.valueOf(gpa3)));
                                    editor.putString("Sem4Value", (String.valueOf(gpa4)));
                                    editor.putString("Sem5Value", (String.valueOf(gpa5)));
                                    editor.putString("Sem6Value", (String.valueOf(gpa6)));
                                    Float fillHeight1 = ((gpa1 * 10) / 100) * 92;
                                    Float fillHeight2 = ((gpa2 * 10) / 100) * 92;
                                    Float fillHeight3 = ((gpa3 * 10) / 100) * 92;
                                    Float fillHeight4 = ((gpa4 * 10) / 100) * 92;
                                    Float fillHeight5 = ((gpa5 * 10) / 100) * 92;
                                    Float fillHeight6 = ((gpa6 * 10) / 100) * 92;
                                    Float cgpaFillHeight = (((cgpaNum * 10)) / 100) * 398;
                                    editor.putFloat("Sem1FillValue", fillHeight1);
                                    editor.putFloat("Sem2FillValue", fillHeight2);
                                    editor.putFloat("Sem3FillValue", fillHeight3);
                                    editor.putFloat("Sem4FillValue", fillHeight4);
                                    editor.putFloat("Sem5FillValue", fillHeight5);
                                    editor.putFloat("Sem6FillValue", fillHeight6);
                                    editor.putFloat("CGPAValue", cgpaNum);
                                    editor.putFloat("CGPAFillValue", cgpaFillHeight);
                                    editor.apply();
                                    tvToastMessage.setText("Saved to Your Academics");
                                    toast.show();

                                }
                            });
                            cgpaNum = cgpaNum / (float) 6;
                        }
                    }
                    if (etSem1.getText().toString().trim().length() > 0 &&
                            etSem2.getText().toString().trim().length() > 0 &&
                            etSem3.getText().toString().trim().length() > 0 &&
                            etSem4.getText().toString().trim().length() > 0 &&
                            etSem5.getText().toString().trim().length() > 0 &&
                            etSem6.getText().toString().trim().length() > 0 &&
                            etSem7.getText().toString().trim().length() > 0) {
                        btnSaveSecondActivity.setVisibility(View.VISIBLE);
                        Float gpa1 = Float.parseFloat(etSem1.getText().toString().trim());
                        Float gpa2 = Float.parseFloat(etSem2.getText().toString().trim());
                        Float gpa3 = Float.parseFloat(etSem3.getText().toString().trim());
                        Float gpa4 = Float.parseFloat(etSem4.getText().toString().trim());
                        Float gpa5 = Float.parseFloat(etSem5.getText().toString().trim());
                        Float gpa6 = Float.parseFloat(etSem6.getText().toString().trim());
                        Float gpa7 = Float.parseFloat(etSem7.getText().toString().trim());
                        cgpaNum = +gpa1 + gpa2 + gpa3 + gpa4 + gpa5 + gpa6 + gpa7;
                        btnSaveSecondActivity.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sharedPreferences = getSharedPreferences("secondToAcademics", MODE_PRIVATE);
                                editor = getSharedPreferences("secondToAcademics", MODE_PRIVATE).edit();
                                editor.clear();
                                editor.apply();

                                editor.putString("Sem1Value", (String.valueOf(gpa1)));
                                editor.putString("Sem2Value", (String.valueOf(gpa2)));
                                editor.putString("Sem3Value", (String.valueOf(gpa3)));
                                editor.putString("Sem4Value", (String.valueOf(gpa4)));
                                editor.putString("Sem5Value", (String.valueOf(gpa5)));
                                editor.putString("Sem6Value", (String.valueOf(gpa6)));
                                editor.putString("Sem7Value", (String.valueOf(gpa7)));
                                Float fillHeight1 = ((gpa1 * 10) / 100) * 92;
                                Float fillHeight2 = ((gpa2 * 10) / 100) * 92;
                                Float fillHeight3 = ((gpa3 * 10) / 100) * 92;
                                Float fillHeight4 = ((gpa4 * 10) / 100) * 92;
                                Float fillHeight5 = ((gpa5 * 10) / 100) * 92;
                                Float fillHeight6 = ((gpa6 * 10) / 100) * 92;
                                Float fillHeight7 = ((gpa7 * 10) / 100) * 92;
                                Float cgpaFillHeight = (((gpa1 * 10)) / 100) * 398;
                                editor.putFloat("Sem1FillValue", fillHeight1);
                                editor.putFloat("Sem2FillValue", fillHeight2);
                                editor.putFloat("Sem3FillValue", fillHeight3);
                                editor.putFloat("Sem4FillValue", fillHeight4);
                                editor.putFloat("Sem5FillValue", fillHeight5);
                                editor.putFloat("Sem6FillValue", fillHeight6);
                                editor.putFloat("Sem7FillValue", fillHeight7);
                                editor.putFloat("CGPAValue", cgpaNum);
                                editor.putFloat("CGPAFillValue", cgpaFillHeight);
                                editor.apply();
                                tvToastMessage.setText("Saved to Your Academics");
                                toast.show();

                            }
                        });
                        cgpaNum = cgpaNum / (float) 7;
                    }
                    if (etSem1.getText().toString().trim().length() > 0 &&
                            etSem2.getText().toString().trim().length() > 0 &&
                            etSem3.getText().toString().trim().length() > 0 &&
                            etSem4.getText().toString().trim().length() > 0 &&
                            etSem5.getText().toString().trim().length() > 0 &&
                            etSem6.getText().toString().trim().length() > 0 &&
                            etSem7.getText().toString().trim().length() > 0 &&
                            etSem8.getText().toString().trim().length() > 0) {
                        btnSaveSecondActivity.setVisibility(View.VISIBLE);
                        Float gpa1 = Float.parseFloat(etSem1.getText().toString().trim());
                        Float gpa2 = Float.parseFloat(etSem2.getText().toString().trim());
                        Float gpa3 = Float.parseFloat(etSem3.getText().toString().trim());
                        Float gpa4 = Float.parseFloat(etSem4.getText().toString().trim());
                        Float gpa5 = Float.parseFloat(etSem5.getText().toString().trim());
                        Float gpa6 = Float.parseFloat(etSem6.getText().toString().trim());
                        Float gpa7 = Float.parseFloat(etSem7.getText().toString().trim());
                        Float gpa8 = Float.parseFloat(etSem7.getText().toString().trim());
                        cgpaNum = +gpa1 + gpa2 + gpa3 + gpa4 + gpa5 + gpa6 + gpa7 + gpa8;
                        btnSaveSecondActivity.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                sharedPreferences = getSharedPreferences("secondToAcademics", MODE_PRIVATE);
                                editor = getSharedPreferences("secondToAcademics", MODE_PRIVATE).edit();
                                editor.clear();
                                editor.apply();
                                editor.putString("Sem1Value", (String.valueOf(gpa1)));
                                editor.putString("Sem2Value", (String.valueOf(gpa2)));
                                editor.putString("Sem3Value", (String.valueOf(gpa3)));
                                editor.putString("Sem4Value", (String.valueOf(gpa4)));
                                editor.putString("Sem5Value", (String.valueOf(gpa5)));
                                editor.putString("Sem6Value", (String.valueOf(gpa6)));
                                editor.putString("Sem7Value", (String.valueOf(gpa7)));
                                editor.putString("Sem8Value", (String.valueOf(gpa8)));
                                Float fillHeight1 = ((gpa1 * 10) / 100) * 92;
                                Float fillHeight2 = ((gpa2 * 10) / 100) * 92;
                                Float fillHeight3 = ((gpa3 * 10) / 100) * 92;
                                Float fillHeight4 = ((gpa4 * 10) / 100) * 92;
                                Float fillHeight5 = ((gpa5 * 10) / 100) * 92;
                                Float fillHeight6 = ((gpa6 * 10) / 100) * 92;
                                Float fillHeight7 = ((gpa7 * 10) / 100) * 92;
                                Float fillHeight8 = ((gpa8 * 10) / 100) * 92;
                                Float cgpaFillHeight = (((cgpaNum * 10)) / 100) * 398;
                                editor.putFloat("Sem1FillValue", fillHeight1);
                                editor.putFloat("Sem2FillValue", fillHeight2);
                                editor.putFloat("Sem3FillValue", fillHeight3);
                                editor.putFloat("Sem4FillValue", fillHeight4);
                                editor.putFloat("Sem5FillValue", fillHeight5);
                                editor.putFloat("Sem6FillValue", fillHeight6);
                                editor.putFloat("Sem7FillValue", fillHeight7);
                                editor.putFloat("Sem8FillValue", fillHeight8);
                                editor.putFloat("CGPAValue", cgpaNum);
                                editor.putFloat("CGPAFillValue", cgpaFillHeight);
                                editor.apply();
                                tvToastMessage.setText("Saved to Your Academics");
                                toast.show();

                            }
                        });
                        cgpaNum = cgpaNum / (float) 8;
                    }
                    DecimalFormat df = new DecimalFormat("#.###");
                    String finalCGPA = df.format(cgpaNum);
                    if (cgpaNum != 0) {
                        tvCGPA.setVisibility(View.VISIBLE);
                        tvCGPA.setText(finalCGPA);
                    }
                } else {
                    tvToastMessage.setText("Enter your GPA or Find GPA");
                    toast.show();
                    tvCGPA.setVisibility(View.INVISIBLE);
                }

            }
        });
    }


    @Override
    public void onClick(View v) {
        Intent intent2 = new Intent(SecondActivity.this, ThirdActivity.class);
        switch (choice) {
            case "CSE":
                intent2.putExtra("dept", choice);
                switch (v.getId()) {
                    case R.id.btnSem1:
                        intent2.putExtra("sem", "Sem1");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem2:
                        intent2.putExtra("sem", "Sem2");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem3:
                        intent2.putExtra("sem", "Sem3");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem4:
                        intent2.putExtra("sem", "Sem4");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem5:
                        intent2.putExtra("sem", "Sem5");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem6:
                        intent2.putExtra("sem", "Sem6");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem7:
                        intent2.putExtra("sem", "Sem7");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem8:
                        intent2.putExtra("sem", "Sem8");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                }
                break;
            case "ECE":
                intent2.putExtra("dept", "ECE");
                switch (v.getId()) {
                    case R.id.btnSem1:
                        intent2.putExtra("sem", "Sem1");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem2:
                        intent2.putExtra("sem", "Sem2");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem3:
                        intent2.putExtra("sem", "Sem3");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem4:
                        intent2.putExtra("sem", "Sem4");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem5:
                        intent2.putExtra("sem", "Sem5");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem6:
                        intent2.putExtra("sem", "Sem6");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem7:
                        intent2.putExtra("sem", "Sem7");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem8:
                        intent2.putExtra("sem", "Sem8");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                }
                break;
            case "EEE":
                intent2.putExtra("dept", "EEE");
                switch (v.getId()) {
                    case R.id.btnSem1:
                        intent2.putExtra("sem", "Sem1");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem2:
                        intent2.putExtra("sem", "Sem2");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem3:
                        intent2.putExtra("sem", "Sem3");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem4:
                        intent2.putExtra("sem", "Sem4");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem5:
                        intent2.putExtra("sem", "Sem5");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem6:
                        intent2.putExtra("sem", "Sem6");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem7:
                        intent2.putExtra("sem", "Sem7");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem8:
                        intent2.putExtra("sem", "Sem8");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                }
                break;
            case "Mech":
                intent2.putExtra("dept", "Mech");
                switch (v.getId()) {
                    case R.id.btnSem1:
                        intent2.putExtra("sem", "Sem1");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem2:
                        intent2.putExtra("sem", "Sem2");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem3:
                        intent2.putExtra("sem", "Sem3");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem4:
                        intent2.putExtra("sem", "Sem4");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem5:
                        intent2.putExtra("sem", "Sem5");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem6:
                        intent2.putExtra("sem", "Sem6");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem7:
                        intent2.putExtra("sem", "Sem7");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                    case R.id.btnSem8:
                        intent2.putExtra("sem", "Sem8");
                        startActivityForResult(intent2, 2);
                        overridePendingTransition(R.anim.from_left, R.anim.from_right);
                        break;
                }
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            String sem1 = data.getStringExtra("sem");
            Log.i("recSemester", sem1);
            switch (sem1) {
                case "sem1":
                    String value1 = data.getStringExtra("Sem1GPA");
                    etSem1.setText(value1);
                    break;
                case "sem2":
                    String value2 = data.getStringExtra("Sem2GPA");
                    etSem2.setText(value2);
                    break;
                case "sem3":
                    String value3 = data.getStringExtra("Sem3GPA");
                    etSem3.setText(value3);
                    break;
                case "sem4":
                    String value4 = data.getStringExtra("Sem4GPA");
                    etSem4.setText(value4);
                    break;
                case "sem5":
                    String value5 = data.getStringExtra("Sem5GPA");
                    etSem5.setText(value5);
                    break;
                case "sem6":
                    String value6 = data.getStringExtra("Sem6GPA");
                    etSem6.setText(value6);
                    break;
                case "sem7":
                    String value7 = data.getStringExtra("Sem7GPA");
                    etSem7.setText(value7);
                    break;
                case "sem8":
                    String value8 = data.getStringExtra("Sem8GPA");
                    etSem8.setText(value8);
                    break;
            }

        }
    }

    @Override
    public void onBackPressed() {
        Log.i("valueTest", etSem1.getText().toString());
        super.onBackPressed();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.from_left, R.anim.from_right);
    }
}
