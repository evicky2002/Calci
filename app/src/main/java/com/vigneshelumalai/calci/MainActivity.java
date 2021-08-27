package com.vigneshelumalai.calci;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.SignInButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.jetbrains.annotations.NotNull;


//Flash Screen Activiyty
public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    Boolean switchStatus;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sharedPreferences = getSharedPreferences("switch_prefs",MODE_PRIVATE);

        switchStatus = sharedPreferences.getBoolean("dark_mode",false);

        //Checks Whether Dark Mode switch is turned on
        if(switchStatus){
            //if yes turn on dark mode on startup
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            //if not turn on dark mode off startup
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        //Getting the FireBase Auth Instance
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        Handler handler = new Handler();
        //Getting the current user Object
        FirebaseUser user = mAuth.getCurrentUser();
        Log.i("vicky","Hi");

        //Runs the runnable after a given specified time
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(user !=null){
                    //If a user exists, then go the First Activity
                    Intent firstActivityIntent = new Intent(MainActivity.this, FirstActivity.class);
                    startActivity(firstActivityIntent);
                    finish();
                }else{
                    //If a user doesn't exists, then go the SignIn Activity
                    Intent firstActivityIntent = new Intent(MainActivity.this, Signinactivity.class);
                    startActivity(firstActivityIntent);
                    finish();
                }
            }
        }, 500);

    }
}