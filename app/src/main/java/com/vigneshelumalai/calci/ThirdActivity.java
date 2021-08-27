package com.vigneshelumalai.calci;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class ThirdActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView tvSub1, tvSub2, tvSub3, tvSub4, tvSub5, tvSub6, tvSub7, tvSub8, tvSub9, tvSub10;
    TextView tvCreditsSub1, tvCreditsSub2, tvCreditsSub3, tvCreditsSub4, tvCreditsSub5, tvCreditsSub6, tvCreditsSub7, tvCreditsSub8;
    TextView tvCreditsSub9, tvCreditsSub10;
    ConstraintLayout constraintLayout1, constraintLayout2, constraintLayout3, constraintLayout4, constraintLayout5;
    ConstraintLayout constraintLayout6, constraintLayout7, constraintLayout8, constraintLayout9, constraintLayout10;
    int[] creditSum = new int[10];
    int totalCredit = 0;
    int reqCode = 2;
    int totalCredGrad = 0;
    int grade;
    float GPA;
    Button btnCalculate;
    int[] credGrad = new int[10];
    Intent intent1 = new Intent();
    DecimalFormat df = new DecimalFormat("#.###");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent intent1 = new Intent();
        Intent intent = getIntent();
        String dept = intent.getStringExtra("dept");
        String sem = intent.getStringExtra("sem");
        Log.i("catch", dept);
        Log.i("catch", sem);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
        Spinner spinner5 = (Spinner) findViewById(R.id.spinner5);
        Spinner spinner6 = (Spinner) findViewById(R.id.spinner6);
        Spinner spinner7 = (Spinner) findViewById(R.id.spinner7);
        Spinner spinner8 = (Spinner) findViewById(R.id.spinner8);
        Spinner spinner9 = (Spinner) findViewById(R.id.spinner9);
        Spinner spinner10 = (Spinner) findViewById(R.id.spinner10);
        constraintLayout1 = (ConstraintLayout) findViewById(R.id.constraintLayout1);
        constraintLayout2 = (ConstraintLayout) findViewById(R.id.constraintLayout2);
        constraintLayout3 = (ConstraintLayout) findViewById(R.id.constraintLayout3);
        constraintLayout4 = (ConstraintLayout) findViewById(R.id.constraintLayout4);
        constraintLayout5 = (ConstraintLayout) findViewById(R.id.constraintLayout5);
        constraintLayout6 = (ConstraintLayout) findViewById(R.id.constraintLayout6);
        constraintLayout7 = (ConstraintLayout) findViewById(R.id.constraintLayout7);
        constraintLayout8 = (ConstraintLayout) findViewById(R.id.constraintLayout8);
        constraintLayout9 = (ConstraintLayout) findViewById(R.id.constraintLayout9);
        constraintLayout10 = (ConstraintLayout) findViewById(R.id.constraintLayout10);
        tvSub1 = (TextView) findViewById(R.id.tvSub1);
        tvSub2 = (TextView) findViewById(R.id.tvSub2);
        tvSub3 = (TextView) findViewById(R.id.tvSub3);
        tvSub4 = (TextView) findViewById(R.id.tvSub4);
        tvSub5 = (TextView) findViewById(R.id.tvSub5);
        tvSub6 = (TextView) findViewById(R.id.tvSub6);
        tvSub7 = (TextView) findViewById(R.id.tvSub7);
        tvSub8 = (TextView) findViewById(R.id.tvSub8);
        tvSub9 = (TextView) findViewById(R.id.tvSub9);
        tvSub10 = (TextView) findViewById(R.id.tvSub10);
        tvCreditsSub1 = (TextView) findViewById(R.id.tvCreditsSub1);
        tvCreditsSub2 = (TextView) findViewById(R.id.tvCreditsSub2);
        tvCreditsSub3 = (TextView) findViewById(R.id.tvCreditsSub3);
        tvCreditsSub4 = (TextView) findViewById(R.id.tvCreditsSub4);
        tvCreditsSub5 = (TextView) findViewById(R.id.tvCreditsSub5);
        tvCreditsSub6 = (TextView) findViewById(R.id.tvCreditsSub6);
        tvCreditsSub7 = (TextView) findViewById(R.id.tvCreditsSub7);
        tvCreditsSub8 = (TextView) findViewById(R.id.tvCreditsSub8);
        tvCreditsSub9 = (TextView) findViewById(R.id.tvCreditsSub9);
        tvCreditsSub10 = (TextView) findViewById(R.id.tvCreditsSub10);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.grades_array, R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);
        spinner4.setAdapter(adapter);
        spinner5.setAdapter(adapter);
        spinner6.setAdapter(adapter);
        spinner7.setAdapter(adapter);
        spinner8.setAdapter(adapter);
        spinner9.setAdapter(adapter);
        spinner10.setAdapter(adapter);

        switch (dept) {
            case "CSE":
                switch (sem) {
                    case "Sem1":
                        constraintLayout9.setVisibility(View.INVISIBLE);
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("HS8151- Communicative \nEnglish");
                        tvCreditsSub1.setText("4");
                        tvSub2.setText("MA8151- Engineering \nMathematics - I");
                        tvCreditsSub2.setText("4");
                        tvSub3.setText("PH8151- Engineering \nPhysics");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("CY8151- Engineering \nChemistry");
                        tvCreditsSub4.setText("3");
                        tvSub5.setText("GE8151- Problem Solving \nand Python Programming");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("GE8152- Engineering \nGraphics");
                        tvCreditsSub6.setText("4");
                        tvSub7.setText("GE8161- Problem Solving \nand Python \nProgramming Laboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("BS8161- Physics and \nChemistry Laboratory");
                        tvCreditsSub8.setText("2");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem1");
                                intent1.putExtra("Sem1GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;

                    case "Sem2":
                        constraintLayout9.setVisibility(View.INVISIBLE);
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("HS8251- Technical \nEnglish");
                        tvCreditsSub1.setText("4");
                        tvSub2.setText("MA8251- Engineering \nMathematics - II");
                        tvCreditsSub2.setText("4");
                        tvSub3.setText("PH8252- Physics for \nInformation Science");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("BE8255- Basic Electrical, \nElectronics and Measurement \nEngineering");
                        tvCreditsSub4.setText("3");
                        tvSub5.setText("GE8291- Environmental \nScience and Engineering");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("CS8251- Programming in \nC");
                        tvCreditsSub6.setText("3");
                        tvSub7.setText("GE8261- Engineering \nPractices Laboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("CS8261- C \nProgramming Laboratory");
                        tvCreditsSub8.setText("2");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem2");
                                intent1.putExtra("Sem2GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem3":
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("MA8351- Discrete \nMathematics");
                        tvCreditsSub1.setText("4");
                        tvSub2.setText("CS8351- Digital \nPrinciples and System \nDesign");
                        tvCreditsSub2.setText("4");
                        tvSub3.setText("CS8391- Data \nStructures");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("CS8392- Object Oriented \nProgramming");
                        tvCreditsSub4.setText("3");
                        tvSub5.setText("EC8395- Communication \nEngineering");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("CS8381- Data \nStructures \nLaboratory");
                        tvCreditsSub6.setText("2");
                        tvSub7.setText("CS8383- Object \nOriented Programming \nLaboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("CS8382- Digital \nSystems Laboratory");
                        tvCreditsSub8.setText("2");
                        tvSub9.setText("HS8381- Interpersonal \nSkills Listening \n&Speaking");
                        tvCreditsSub9.setText("1");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem3");
                                intent1.putExtra("Sem3GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem4":
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("MA8402- Probability \nand Queueing \nTheory");
                        tvCreditsSub1.setText("4");
                        tvSub2.setText("CS8491- Computer \nArchitecture");
                        tvCreditsSub2.setText("3");
                        tvSub3.setText("CS8492- Database \nManagement Systems");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("CS8451- Design and \nAnalysis of \nAlgorithms");
                        tvCreditsSub4.setText("3");
                        tvSub5.setText("CS8493- Operating \nSystems");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("CS8494- Software \nEngineering");
                        tvCreditsSub6.setText("3");
                        tvSub7.setText("CS8481- Database \nManagement Systems \nLaboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("CS8461- Operating \nSystems Laboratory");
                        tvCreditsSub8.setText("2");
                        tvSub9.setText("HS8461- Advanced \nReading and \nWriting");
                        tvCreditsSub9.setText("1");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem4");
                                intent1.putExtra("Sem4GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        }); break;
                    case "Sem5":
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("MA8551- Algebra and \nNumber Theory");
                        tvCreditsSub1.setText("4");
                        tvSub2.setText("CS8591- Computer \nNetworks");
                        tvCreditsSub2.setText("3");
                        tvSub3.setText("EC8691- Microprocessors \nand Microcontrollers");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("CS8501- Theory of \nComputation");
                        tvCreditsSub4.setText("3");
                        tvSub5.setText("CS8592- Object \nOriented Analysis \nand Design");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("Open Elective I");
                        tvCreditsSub6.setText("3");
                        tvSub7.setText("EC8681- Microprocessors \nand Microcontrollers \nLaboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("CS8582- Object Oriented \nAnalysis and Design \nLaboratory");
                        tvCreditsSub8.setText("2");
                        tvSub9.setText("CS8581- Networks \nLaboratory");
                        tvCreditsSub9.setText("2");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem5");
                                intent1.putExtra("Sem5GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem6":
                        tvSub1.setText("CS8651- Internet \nProgramming");
                        tvCreditsSub1.setText("3");
                        tvSub2.setText("CS8691- Artificial \nIntelligence");
                        tvCreditsSub2.setText("3");
                        tvSub3.setText("CS8601- Mobile \nComputing");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("CS8602- Compiler \nDesign");
                        tvCreditsSub4.setText("4");
                        tvSub5.setText("CS8603- Distributed \nSystems");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("Professional Elective I");
                        tvCreditsSub6.setText("3");
                        tvSub7.setText("CS8661- Internet \nProgramming Laboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("CS8662- Mobile \nApplication Development \nLaboratory");
                        tvCreditsSub8.setText("2");
                        tvSub9.setText("CS8611- Mini Project");
                        tvCreditsSub9.setText("1");
                        tvSub10.setText("HS8581- Professional \nCommunication");
                        tvCreditsSub10.setText("1");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem6");
                                intent1.putExtra("Sem6GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem7":
                        constraintLayout9.setVisibility(View.INVISIBLE);
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("MG8591- Principles \nof Management");
                        tvCreditsSub1.setText("3");
                        tvSub2.setText("CS8792- Cryptography \nand Network \nSecurity");
                        tvCreditsSub2.setText("3");
                        tvSub3.setText("CS8791- Cloud \nComputing");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("Open Elective II");
                        tvCreditsSub4.setText("3");
                        tvSub5.setText("Professional \nElective II");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("Professional \nElective III");
                        tvCreditsSub6.setText("3");
                        tvSub7.setText("CS8711- Cloud Computing \nLaboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("IT8761- Security \nLaboratory");
                        tvCreditsSub8.setText("2");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem7");
                                intent1.putExtra("Sem7GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem8":
                        constraintLayout4.setVisibility(View.INVISIBLE);
                        constraintLayout5.setVisibility(View.INVISIBLE);
                        constraintLayout6.setVisibility(View.INVISIBLE);
                        constraintLayout7.setVisibility(View.INVISIBLE);
                        constraintLayout8.setVisibility(View.INVISIBLE);
                        constraintLayout9.setVisibility(View.INVISIBLE);
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("Professional Elective IV");
                        tvCreditsSub1.setText("3");
                        tvSub2.setText("Professional Elective V");
                        tvCreditsSub2.setText("3");
                        tvSub3.setText("CS8811- Project Work");
                        tvCreditsSub3.setText("10");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem8");
                                intent1.putExtra("Sem8GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;

                }
                break;
            case "ECE":
                switch (sem) {
                    case "Sem1":
                        constraintLayout9.setVisibility(View.INVISIBLE);
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("HS8151- Communicative \nEnglish");
                        tvCreditsSub1.setText("4");
                        tvSub2.setText("MA8151- Engineering \nMathematics - I");
                        tvCreditsSub2.setText("4");
                        tvSub3.setText("PH8151- Engineering \nPhysics");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("CY8151- Engineering \nChemistry");
                        tvCreditsSub4.setText("3");
                        tvSub5.setText("GE8151- Problem Solving \nand Python Programming");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("GE8152- Engineering \nGraphics");
                        tvCreditsSub6.setText("4");
                        tvSub7.setText("GE8161- Problem Solving \nand Python \nProgramming Laboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("BS8161- Physics and \nChemistry Laboratory");
                        tvCreditsSub8.setText("2");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem1");
                                intent1.putExtra("Sem1GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem2":
                        constraintLayout9.setVisibility(View.INVISIBLE);
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("HS8251- Technical \nEnglish");
                        tvCreditsSub1.setText("4");
                        tvSub2.setText("MA8151- Engineering \nMathematics - I");
                        tvCreditsSub2.setText("4");
                        tvSub3.setText("PH8253- Physics for \nElectronics Engineering");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("BE8254- Basic Electrical \nand Instrumentation \nEngineering");
                        tvCreditsSub4.setText("3");
                        tvSub5.setText("EC8251- Circuit \nAnalysis");
                        tvCreditsSub5.setText("4");
                        tvSub6.setText("EC8252- Electronic \nDevices");
                        tvCreditsSub6.setText("3");
                        tvSub7.setText("EC8261- Circuits and \nDevices Laboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("GE8261- Engineering \nPractices Laboratory");
                        tvCreditsSub8.setText("2");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem2");
                                intent1.putExtra("Sem2GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem3":
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("MA8352- Linear Algebra \nand Partial \nDifferential Equations");
                        tvCreditsSub1.setText("4");
                        tvSub2.setText("EC8393- Fundamentals \nof Data Structures \nIn C");
                        tvCreditsSub2.setText("3");
                        tvSub3.setText("EC8351- Electronic \nCircuits- I");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("EC8352- Signals and \nSystems");
                        tvCreditsSub4.setText("4");
                        tvSub5.setText("EC8392- Digital \nElectronics");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("EC8391- Control \nSystems Engineering");
                        tvCreditsSub6.setText("3");
                        tvSub7.setText("EC8381- Fundamentals \nof Data Structures \nin C Laboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("EC8361- Analog and \nDigital Circuits \nLaboratory");
                        tvCreditsSub8.setText("2");
                        tvSub9.setText("HS8381- Interpersonal \nSkills/Listening \n&Speaking");
                        tvCreditsSub9.setText("1");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem3");
                                intent1.putExtra("Sem3GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem4":
                        constraintLayout9.setVisibility(View.INVISIBLE);
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("MA8451- Probability \nand Random \nProcesses");
                        tvCreditsSub1.setText("4");
                        tvSub2.setText("EC8452- Electronic \nCircuits II");
                        tvCreditsSub2.setText("3");
                        tvSub3.setText("EC8491- Communication \nTheory");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("EC8451- Electromagnetic \nFields");
                        tvCreditsSub4.setText("4");
                        tvSub5.setText("EC8453- Linear \nIntegrated Circuits");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("GE8291- Environmental \nScience and \nEngineering");
                        tvCreditsSub6.setText("3");
                        tvSub7.setText("EC8461- Circuits \nDesign and Simulation \nLaboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("EC8462- Linear \nIntegrated Circuits \nLaboratory");
                        tvCreditsSub8.setText("2");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem4");
                                intent1.putExtra("Sem4GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem5":
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("EC8501- Digital \nCommunication");
                        tvCreditsSub1.setText("3");
                        tvSub2.setText("EC8553- Discrete-Time \nSignal Processing");
                        tvCreditsSub2.setText("4");
                        tvSub3.setText("EC8552- Computer \nArchitecture and \nOrganization");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("EC8551- Communication \nNetworks");
                        tvCreditsSub4.setText("3");
                        tvSub5.setText("Professional Elective I");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("Open Elective I");
                        tvCreditsSub6.setText("3");
                        tvSub7.setText("EC8562- Digital S\nignal Processing \nLaboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("EC8561- ACommunication \nSystems Laboratory");
                        tvCreditsSub8.setText("2");
                        tvSub9.setText("EC8563- Communication \nNetworks Laboratory");
                        tvCreditsSub9.setText("2");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem5");
                                intent1.putExtra("Sem5GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem6":
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("EC8691- Microprocessors \nand Microcontrollers");
                        tvCreditsSub1.setText("3");
                        tvSub2.setText("EC8095- VLSI Design");
                        tvCreditsSub2.setText("3");
                        tvSub3.setText("EC8652- Wireless \nCommunication");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("MG8591- Principles \nof Management");
                        tvCreditsSub4.setText("3");
                        tvSub5.setText("EC8651- Transmission \nLines and RF \nSystems");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("Professional Elective -II");
                        tvCreditsSub6.setText("3");
                        tvSub7.setText("EC8681- Microprocessors \nand Microcontrollers \nLaboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("EC8661- VLSI Design\n Laboratory");
                        tvCreditsSub8.setText("2");
                        tvSub9.setText("EC8611- Technical \nSeminar");
                        tvCreditsSub9.setText("1");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem6");
                                intent1.putExtra("Sem6GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem7":
                        constraintLayout9.setVisibility(View.INVISIBLE);
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("EC8701- Antennas \nand Microwave \nEngineering");
                        tvCreditsSub1.setText("3");
                        tvSub2.setText("EC8751- Optical \nCommunication");
                        tvCreditsSub2.setText("3");
                        tvSub3.setText("EC8791- Embedded and \nReal Time \nSystems");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("EC8702- Ad hoc \nand Wireless \nSensor Networks");
                        tvCreditsSub4.setText("3");
                        tvSub5.setText("Professional Elective -III");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("Open Elective - II");
                        tvCreditsSub6.setText("3");
                        tvSub7.setText("EC8711- Embedded \nLaboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("EC8761- Advanced \nCommunication \nLaboratory");
                        tvCreditsSub8.setText("2");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem7");
                                intent1.putExtra("Sem7GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem8":
                        constraintLayout4.setVisibility(View.INVISIBLE);
                        constraintLayout5.setVisibility(View.INVISIBLE);
                        constraintLayout6.setVisibility(View.INVISIBLE);
                        constraintLayout7.setVisibility(View.INVISIBLE);
                        constraintLayout8.setVisibility(View.INVISIBLE);
                        constraintLayout9.setVisibility(View.INVISIBLE);
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("Professional Elective IV");
                        tvCreditsSub1.setText("3");
                        tvSub2.setText("Professional Elective V");
                        tvCreditsSub2.setText("3");
                        tvSub3.setText("EC8811- Project Work");
                        tvCreditsSub3.setText("10");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem8");
                                intent1.putExtra("Sem8GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;

                }
                break;


            case "EEE":
                switch (sem) {
                    case "Sem1":
                        constraintLayout9.setVisibility(View.INVISIBLE);
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("HS8151- Communicative \nEnglish");
                        tvCreditsSub1.setText("4");
                        tvSub2.setText("MA8151- Engineering \nMathematics - I");
                        tvCreditsSub2.setText("4");
                        tvSub3.setText("PH8151- Engineering \nPhysics");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("CY8151- Engineering \nChemistry");
                        tvCreditsSub4.setText("3");
                        tvSub5.setText("GE8151- Problem Solving \nand Python Programming");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("GE8152- Engineering \nGraphics");
                        tvCreditsSub6.setText("4");
                        tvSub7.setText("GE8161- Problem Solving \nand Python \nProgramming Laboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("BS8161- Physics and \nChemistry Laboratory");
                        tvCreditsSub8.setText("2");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem1");
                                intent1.putExtra("Sem1GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem2":
                        constraintLayout9.setVisibility(View.INVISIBLE);
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("HS8251- Technical \nEnglish");
                        tvCreditsSub1.setText("4");
                        tvSub2.setText("MA8251- Engineering \nMathematics - I");
                        tvCreditsSub2.setText("4");
                        tvSub3.setText("PH8253- Physics for \nElectronics Engineering");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("BE8252- Basic Civil\nand Mechanical \nEngineering");
                        tvCreditsSub4.setText("4");
                        tvSub5.setText("EE8251- Circuit \nTheory");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("GE8291- Environmental \nScience and \nEngineering");
                        tvCreditsSub6.setText("3");
                        tvSub7.setText("GE8261- Engineering \nPractices Laboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("EE8261- Electric \nCircuits Laboratory");
                        tvCreditsSub8.setText("2");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem2");
                                intent1.putExtra("Sem2GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem3":
                        constraintLayout9.setVisibility(View.INVISIBLE);
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("MA8353- Transforms \nand Partial \nDifferential Equations");
                        tvCreditsSub1.setText("4");
                        tvSub2.setText("EE8351- Digital \nLogic Circuits");
                        tvCreditsSub2.setText("3");
                        tvSub3.setText("EE8391- Electromagnetic \nTheory");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("EE8301- Electrical \nMachines - I");
                        tvCreditsSub4.setText("3");
                        tvSub5.setText("EC8353- Electron \nDevices and \nCircuits");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("ME8792- Power \nPlant Engineering");
                        tvCreditsSub6.setText("3");
                        tvSub7.setText("EC8311- Electronics \nLaboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("EE8311- Electrical \nMachines Laboratory - I");
                        tvCreditsSub8.setText("2");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem3");
                                intent1.putExtra("Sem3GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem4":
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("MA8491- Numerical \nMethods");
                        tvCreditsSub1.setText("4");
                        tvSub2.setText("EE8401- Electrical \nMachines - II");
                        tvCreditsSub2.setText("3");
                        tvSub3.setText("EE8402- Transmission \nand Distribution");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("EE8403- Measurements \nand Instrumentation");
                        tvCreditsSub4.setText("3");
                        tvSub5.setText("EE8451- Linear \nIntegrated Circuits \nand Applications");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("IC8451- Control \nSystems");
                        tvCreditsSub6.setText("4");
                        tvSub7.setText("EE8411- Electrical \nMachines \nLaboratory - II");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("EE8461- Linear and \nDigital Integrated \nCircuits Laboratory");
                        tvCreditsSub8.setText("2");
                        tvSub9.setText("EE8412- Technical \nSeminar");
                        tvCreditsSub9.setText("1");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem4");
                                intent1.putExtra("Sem4GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem5":
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("EE8501- Power \nSystem Analysis");
                        tvCreditsSub1.setText("3");
                        tvSub2.setText("EE8551- Microprocessors \nand Microcontrollers");
                        tvCreditsSub2.setText("3");
                        tvSub3.setText("EE8552- Power \nElectronics");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("EE8591- Digital \nSignal Processing");
                        tvCreditsSub4.setText("3");
                        tvSub5.setText("CS8392- Object \nOriented Programming");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("Open Elective I*");
                        tvCreditsSub6.setText("3");
                        tvSub7.setText("EE8511- Control \nand Instrumentation \nLaboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("HS8581- Professional \nCommunication");
                        tvCreditsSub8.setText("1");
                        tvSub9.setText("CS8383- Object \nOriented Programming \nLaboratory");
                        tvCreditsSub9.setText("2");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem5");
                                intent1.putExtra("Sem5GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem6":
                        constraintLayout9.setVisibility(View.INVISIBLE);
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("EE8601- Solid \nState Drives");
                        tvCreditsSub1.setText("3");
                        tvSub2.setText("EE8602- Protection \nand Switchgear");
                        tvCreditsSub2.setText("3");
                        tvSub3.setText("EE8691- Embedded \nSystems");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("Professional Elective I");
                        tvCreditsSub4.setText("3");
                        tvSub5.setText("Professional Elective II");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("EE8661- Power Electronics \nand Drives \nLaboratory");
                        tvCreditsSub6.setText("2");
                        tvSub7.setText("EE8681- Microprocessors \nand Microcontrollers \nLaboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("EE8611- Mini Project");
                        tvCreditsSub8.setText("2");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem6");
                                intent1.putExtra("Sem6GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem7":
                        constraintLayout9.setVisibility(View.INVISIBLE);
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("EE8701- High \nVoltage \nEngineering");
                        tvCreditsSub1.setText("3");
                        tvSub2.setText("EE8702- Power \nSystem Operation \nand Control");
                        tvCreditsSub2.setText("3");
                        tvSub3.setText("EE8703- Renewable \nEnergy Systems");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("Open Elective II*");
                        tvCreditsSub4.setText("3");
                        tvSub5.setText("Professional \nElective III");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("Professional \nElective IV");
                        tvCreditsSub6.setText("3");
                        tvSub7.setText("EE8711- Power \nSystem Simulation \nLaboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("EE8712- Renewable \nEnergy Systems \nLaboratory");
                        tvCreditsSub8.setText("2");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem7");
                                intent1.putExtra("Sem7GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem8":
                        constraintLayout4.setVisibility(View.INVISIBLE);
                        constraintLayout5.setVisibility(View.INVISIBLE);
                        constraintLayout6.setVisibility(View.INVISIBLE);
                        constraintLayout7.setVisibility(View.INVISIBLE);
                        constraintLayout8.setVisibility(View.INVISIBLE);
                        constraintLayout9.setVisibility(View.INVISIBLE);
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("Professional Elective V");
                        tvCreditsSub1.setText("3");
                        tvSub2.setText("Professional Elective VI");
                        tvCreditsSub2.setText("3");
                        tvSub3.setText("EE8811- Project Work");
                        tvCreditsSub3.setText("10");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem8");
                                intent1.putExtra("Sem8GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;

                }
                break;

            case "Mech":
                switch (sem) {
                    case "Sem1":
                        constraintLayout9.setVisibility(View.INVISIBLE);
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("HS8151- Communicative \nEnglish");
                        tvCreditsSub1.setText("4");
                        tvSub2.setText("MA8151- Engineering \nMathematics - I");
                        tvCreditsSub2.setText("4");
                        tvSub3.setText("PH8151- Engineering \nPhysics");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("CY8151- Engineering \nChemistry");
                        tvCreditsSub4.setText("3");
                        tvSub5.setText("GE8151- Problem Solving \nand Python Programming");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("GE8152- Engineering \nGraphics");
                        tvCreditsSub6.setText("4");
                        tvSub7.setText("GE8161- Problem Solving \nand Python \nProgramming Laboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("BS8161- Physics and \nChemistry Laboratory");
                        tvCreditsSub8.setText("2");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem1");
                                intent1.putExtra("Sem1GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem2":
                        constraintLayout9.setVisibility(View.INVISIBLE);
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("HS8251- Technical \nEnglish");
                        tvCreditsSub1.setText("4");
                        tvSub2.setText("MA8251- Engineering \nMathematics - I");
                        tvCreditsSub2.setText("4");
                        tvSub3.setText("PH8251- Materials \nScience");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("BE8253- Basic Electrical, \nElectronics and \nInstrumentation Engineering");
                        tvCreditsSub4.setText("3");
                        tvSub5.setText("GE8291- Environmental \nScience and \nEngineering");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("GE8292- Engineering Mechanics");
                        tvCreditsSub6.setText("4");
                        tvSub7.setText("GE8261- Engineering \nPractices Laboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("BE8261- Basic Electrical \nElectronics and Instrumentation \nEngineering Laboratory");
                        tvCreditsSub8.setText("2");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem2");
                                intent1.putExtra("Sem2GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem3":
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("MA8353- Transforms \nand Partial \nDifferential Equations");
                        tvCreditsSub1.setText("4");
                        tvSub2.setText("ME8391- Engineering \nThermodynamics");
                        tvCreditsSub2.setText("4");
                        tvSub3.setText("CE8394- Fluid \nMechanics and \nMachinery");
                        tvCreditsSub3.setText("4");
                        tvSub4.setText("ME8351- Manufacturing \nTechnology - I");
                        tvCreditsSub4.setText("3");
                        tvSub5.setText("EE8353- Electrical \nDrives and Controls");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("ME8361- Manufacturing \nTechnology \nLaboratory - I");
                        tvCreditsSub6.setText("2");
                        tvSub7.setText("ME8381- Computer Aided \nMachine Drawing");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("EE8361- Electrical \nEngineering \nLaboratory");
                        tvCreditsSub8.setText("2");
                        tvSub9.setText("HS8381- Interpersonal \nSkills / Listening \n& Speaking");
                        tvCreditsSub9.setText("1");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem3");
                                intent1.putExtra("Sem3GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem4":
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("MA8452- Statistics \nand Numerical Methods");
                        tvCreditsSub1.setText("4");
                        tvSub2.setText("ME8492- Kinematics \nof Machinery");
                        tvCreditsSub2.setText("3");
                        tvSub3.setText("ME8451- Manufacturing \nTechnology – II");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("ME8491- Engineering \nMetallurgy");
                        tvCreditsSub4.setText("3");
                        tvSub5.setText("CE8395- Strength of \nMaterials for \nMechanical Engineers");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("ME8493- Thermal \nEngineering- I");
                        tvCreditsSub6.setText("3");
                        tvSub7.setText("ME8462- Manufacturing \nTechnology \nLaboratory – II");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("CE8381- Strength of Materials \nand Fluid Mechanics and \nMachinery Laboratory");
                        tvCreditsSub8.setText("2");
                        tvSub9.setText("HS8461- Advanced \nReading and \nWriting");
                        tvCreditsSub9.setText("1");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem4");
                                intent1.putExtra("Sem4GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem5":
                        constraintLayout9.setVisibility(View.INVISIBLE);
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("ME8595- Thermal \nEngineering- II");
                        tvCreditsSub1.setText("3");
                        tvSub2.setText("ME8593- Design of \nMachine Elements");
                        tvCreditsSub2.setText("3");
                        tvSub3.setText("ME8501- Metrology \nand Measurements");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("ME8594- Dynamics \nof Machines");
                        tvCreditsSub4.setText("4");
                        tvSub5.setText("Open Elective I");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("ME8511- Kinematics \nand Dynamics \nLaboratory");
                        tvCreditsSub6.setText("2");
                        tvSub7.setText("ME8512- Thermal \nEngineering \nLaboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("ME8513- Metrology \nand Measurements \nLaboratory");
                        tvCreditsSub8.setText("2");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem5");
                                intent1.putExtra("Sem5GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem6":
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("ME8651- Design of \nTransmission \nSystems");
                        tvCreditsSub1.setText("3");
                        tvSub2.setText("ME8691- Computer \nAided Design \nand Manufacturing");
                        tvCreditsSub2.setText("3");
                        tvSub3.setText("ME8693- Heat and \nMass Transfer");
                        tvCreditsSub3.setText("4");
                        tvSub4.setText("ME8692- Finite \nElement Analysis");
                        tvCreditsSub4.setText("3");
                        tvSub5.setText("ME8694- Hydraulics \nand Pneumatics");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("Professional Elective - I");
                        tvCreditsSub6.setText("3");
                        tvSub7.setText("ME8681- CAD / CAM \nLaboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("ME8682- Design and \nFabrication Project");
                        tvCreditsSub8.setText("2");
                        tvSub9.setText("HS8581- Professional \nCommunication");
                        tvCreditsSub9.setText("1");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem6");
                                intent1.putExtra("Sem6GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem7":
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("ME8792- Power Plant \nEngineering");
                        tvCreditsSub1.setText("3");
                        tvSub2.setText("ME8793- Process \nPlanning and \nCost Estimation");
                        tvCreditsSub2.setText("3");
                        tvSub3.setText("ME8791- Mechatronics");
                        tvCreditsSub3.setText("3");
                        tvSub4.setText("Open Elective - II");
                        tvCreditsSub4.setText("3");
                        tvSub5.setText("Professional Elective – II");
                        tvCreditsSub5.setText("3");
                        tvSub6.setText("Professional Elective – III");
                        tvCreditsSub6.setText("3");
                        tvSub7.setText("ME8711- Simulation \nand Analysis \nLaboratory");
                        tvCreditsSub7.setText("2");
                        tvSub8.setText("ME8781- Mechatronics \nLaboratory");
                        tvCreditsSub8.setText("2");
                        tvSub9.setText("ME8712- Technical Seminar");
                        tvCreditsSub9.setText("1");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem7");
                                intent1.putExtra("Sem7GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;
                    case "Sem8":
                        constraintLayout4.setVisibility(View.INVISIBLE);
                        constraintLayout5.setVisibility(View.INVISIBLE);
                        constraintLayout6.setVisibility(View.INVISIBLE);
                        constraintLayout7.setVisibility(View.INVISIBLE);
                        constraintLayout8.setVisibility(View.INVISIBLE);
                        constraintLayout9.setVisibility(View.INVISIBLE);
                        constraintLayout10.setVisibility(View.INVISIBLE);
                        tvSub1.setText("Professional Elective V");
                        tvCreditsSub1.setText("3");
                        tvSub2.setText("Professional Elective VI");
                        tvCreditsSub2.setText("3");
                        tvSub3.setText("ME8811- Project Work");
                        tvCreditsSub3.setText("10");
                        spinner1.setOnItemSelectedListener(this);
                        spinner2.setOnItemSelectedListener(this);
                        spinner3.setOnItemSelectedListener(this);
                        spinner4.setOnItemSelectedListener(this);
                        spinner5.setOnItemSelectedListener(this);
                        spinner6.setOnItemSelectedListener(this);
                        spinner7.setOnItemSelectedListener(this);
                        spinner8.setOnItemSelectedListener(this);
                        spinner9.setOnItemSelectedListener(this);
                        spinner10.setOnItemSelectedListener(this);
                        btnCalculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (int i = 0; i < credGrad.length; i++) {
                                    totalCredGrad += credGrad[i];
                                    totalCredit += creditSum[i];
                                    GPA = (float)totalCredGrad / totalCredit;
                                }
                                Log.i("sum", String.valueOf(totalCredGrad));
                                Log.i("sum", String.valueOf(totalCredit));
                                intent1.putExtra("sem", "sem8");
                                intent1.putExtra("Sem8GPA", df.format(GPA));
                                setResult(reqCode, intent1);
                                ThirdActivity.this.finish();

                            }
                        });break;

                }
                break;

        }


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int credit;
        switch (position) {
            case 0:
                grade = 10;
                break;
            case 1:
                grade = 9;
                break;
            case 2:
                grade = 8;
                break;
            case 3:
                grade = 7;
                break;
            case 4:
                grade = 6;
                break;
            case 5:
                grade = 0;
                break;

        }
        switch (parent.getId()) {
            case R.id.spinner1:
                credit = Integer.parseInt(tvCreditsSub1.getText().toString());
                creditSum[0] = credit;
                credGrad[0] = credit * grade;
                Log.i("credit", Arrays.toString(creditSum));
                Log.i("credit", Arrays.toString(credGrad));
                break;
            case R.id.spinner2:
                credit = Integer.parseInt(tvCreditsSub2.getText().toString());
                creditSum[1] = credit;
                credGrad[1] = credit * grade;
                Log.i("credit", Arrays.toString(credGrad));
                Log.i("credit", Arrays.toString(creditSum));
                break;
            case R.id.spinner3:
                credit = Integer.parseInt(tvCreditsSub3.getText().toString());
                creditSum[2] = credit;
                credGrad[2] = credit * grade;
                Log.i("credit", Arrays.toString(creditSum));
                Log.i("credit", Arrays.toString(credGrad));
                break;
            case R.id.spinner4:
                if (constraintLayout4.getVisibility() == View.VISIBLE) {
                    credit = Integer.parseInt(tvCreditsSub4.getText().toString());
                    creditSum[3] = credit;
                    credGrad[3] = credit * grade;
                    Log.i("credit", Arrays.toString(creditSum));
                    Log.i("credit", Arrays.toString(credGrad));
                }
                break;

            case R.id.spinner5:
                if (constraintLayout5.getVisibility() == View.VISIBLE) {
                    credit = Integer.parseInt(tvCreditsSub5.getText().toString());
                    creditSum[4] = credit;
                    credGrad[4] = credit * grade;
                    Log.i("credit", Arrays.toString(creditSum));
                    Log.i("credit", Arrays.toString(credGrad));
                }
                break;
            case R.id.spinner6:
                if (constraintLayout6.getVisibility() == View.VISIBLE) {
                    credit = Integer.parseInt(tvCreditsSub6.getText().toString());
                    creditSum[5] = credit;
                    credGrad[5] = credit * grade;
                    Log.i("credit", Arrays.toString(creditSum));
                    Log.i("credit", Arrays.toString(credGrad));
                }
                break;
            case R.id.spinner7:
                if (constraintLayout7.getVisibility() == View.VISIBLE) {
                    credit = Integer.parseInt(tvCreditsSub7.getText().toString());
                    creditSum[6] = credit;
                    credGrad[6] = credit * grade;
                    Log.i("credit", Arrays.toString(creditSum));
                    Log.i("credit", Arrays.toString(credGrad));
                }
                break;
            case R.id.spinner8:
                if (constraintLayout8.getVisibility() == View.VISIBLE) {
                    credit = Integer.parseInt(tvCreditsSub8.getText().toString());
                    creditSum[7] = credit;
                    credGrad[7] = credit * grade;
                    Log.i("credit", Arrays.toString(creditSum));
                    Log.i("credit", Arrays.toString(credGrad));
                }
                break;
            case R.id.spinner9:
                if (constraintLayout9.getVisibility() == View.VISIBLE) {
                    credit = Integer.parseInt(tvCreditsSub9.getText().toString());
                    creditSum[8] = credit;
                    credGrad[8] = credit * grade;
                    Log.i("credit", Arrays.toString(creditSum));
                    Log.i("credit", Arrays.toString(credGrad));
                }
                break;
            case R.id.spinner10:
                if (constraintLayout10.getVisibility() == View.VISIBLE) {
                    credit = Integer.parseInt(tvCreditsSub10.getText().toString());
                    creditSum[9] = credit;
                    credGrad[9] = credit * grade;
                    Log.i("credit", Arrays.toString(creditSum));
                    Log.i("credit", Arrays.toString(credGrad));
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        intent1.putExtra("sem","null");
        intent1.putExtra("Sem1GPA","null");
        setResult(reqCode, intent1);
        ThirdActivity.this.finish();
        super.onBackPressed();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.from_left, R.anim.from_right);
    }

}