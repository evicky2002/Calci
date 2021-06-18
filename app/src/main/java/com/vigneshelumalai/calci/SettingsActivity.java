package com.vigneshelumalai.calci;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.audiofx.BassBoost;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class SettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Intent intent = new Intent();
    Button btnSave;
    Spinner spinnerDept;
    private static String MY_PREFS = "switch_prefs";
    private static String THEME_STATUS = "dark_mode";
    SwitchCompat darkSwitch;
    Boolean isNightModeChecked;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    NavigationView nav_view;
    TextView tvDept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        btnSave = (Button)findViewById(R.id.btnSave);
        spinnerDept = (Spinner)findViewById(R.id.spinnerDept);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dept_array, R.layout.simple_spinner_item_2);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinnerDept.setAdapter(adapter);



        darkSwitch = (SwitchCompat) findViewById(R.id.darkSwitch);
        sharedPreferences = getSharedPreferences(MY_PREFS,MODE_PRIVATE);
        editor = getSharedPreferences(MY_PREFS,MODE_PRIVATE).edit();
        isNightModeChecked = sharedPreferences.getBoolean(THEME_STATUS,false);
        darkSwitch.setChecked(isNightModeChecked);
        spinnerDept.setSelection(sharedPreferences.getInt("spinnerSelection",0));
        spinnerDept.setOnItemSelectedListener(this);
        if(isNightModeChecked){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }


        darkSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor.putBoolean(THEME_STATUS,true);
                    editor.apply();
                    darkSwitch.setChecked(true);
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor.putBoolean(THEME_STATUS,false);
                    editor.apply();
                    darkSwitch.setChecked(false);
                }
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("dept",spinnerDept.getSelectedItemPosition());
                setResult(1,intent);
                finish();
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int item = spinnerDept.getSelectedItemPosition();
        editor = sharedPreferences.edit();
        editor.putInt("spinnerSelection", item);
        editor.apply();
    }

    @Override
    public void onBackPressed() {
        setResult(1,intent);
        finish();
    }

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.from_left,R.anim.from_right);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}