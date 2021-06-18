package com.vigneshelumalai.calci;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.jetbrains.annotations.NotNull;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener{
    Button btnCSE;
    Button btnECE;
    Button btnEEE;
    Button btnMech;

    TextView tvProfileName;
    TextView tvDept;
    TextView tvEmail;
    TextView tvSignOut;
    TextView tvSideBarBtn;

    ImageView ivProfilePhoto;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    FirebaseAuth mAuth;

    NavigationView nav_view;
    DrawerLayout drawerLayout;

    String Dept = "Department : ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        linkingViews();

        btnCSE.setOnClickListener(this);
        btnECE.setOnClickListener(this);
        btnEEE.setOnClickListener(this);
        btnMech.setOnClickListener(this);
        tvSideBarBtn.setOnClickListener(this);
        nav_view.setNavigationItemSelectedListener(this);

        //Updating the Department from sharedPreferences
        sharedPreferences = getSharedPreferences("dept",MODE_PRIVATE);
        editor = getSharedPreferences("dept",MODE_PRIVATE).edit();

        //Sets the text of Department from Shared preferences (sets only the value of Dept if nothing is
        // selected)
        tvDept.setText(sharedPreferences.getString("department",Dept));



        //Auth - Getting data from google account using FirebaseAuth
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        String name = currentUser.getDisplayName();
        String email = currentUser.getEmail();

        tvProfileName.setText(name);
        tvEmail.setText(email);

        Glide.with(this).load(currentUser.getPhotoUrl()).centerCrop()
                .placeholder(R.drawable.ellipse).into(ivProfilePhoto);

        //For masking the Profile photo into a circle
        Glide.with(FirstActivity.this)
                .load(currentUser.getPhotoUrl()) // add your image url
                .transform(new CircleTransform(FirstActivity.this)) // applying the image transformer
                .into(ivProfilePhoto);

        //SignOut Button
        tvSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent signInActivityIntent = new Intent(FirstActivity.this,Signinactivity.class);
                startActivity(signInActivityIntent);
                finish();
            }
        });
    }

    public void linkingViews(){
        btnCSE = (Button) findViewById(R.id.btnCSE);
        nav_view = (NavigationView) findViewById(R.id.nav_view);
        View headerView = nav_view.getHeaderView(0);
        tvDept = (TextView) headerView.findViewById(R.id.tvDept);
        btnECE = (Button) findViewById(R.id.btnECE);
        btnEEE = (Button) findViewById(R.id.btnEEE);
        btnMech = (Button) findViewById(R.id.btnMech);
        tvSideBarBtn = (TextView) findViewById(R.id.tvSideBarBtn);
        tvSignOut = (TextView) findViewById(R.id.tvSignOut);
        ivProfilePhoto = (ImageView) headerView.findViewById(R.id.ivProfilePhoto);
        tvProfileName = (TextView) headerView.findViewById(R.id.tvProfileName);
        tvEmail = (TextView) headerView.findViewById(R.id.tvEmail);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

    }
    //Navigating to next activities
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
        switch (view.getId()){
            case R.id.btnCSE:
                intent.putExtra("dept","CSE");
                startActivity(intent);
                overridePendingTransition(R.anim.from_left,R.anim.from_right);

                break;
            case R.id.btnECE:
                intent.putExtra("dept","ECE");
                startActivity(intent);
                overridePendingTransition(R.anim.from_left,R.anim.from_right);

                break;
            case R.id.btnEEE:
                intent.putExtra("dept","EEE");
                startActivity(intent);
                overridePendingTransition(R.anim.from_left,R.anim.from_right);

                break;
            case R.id.btnMech:
                intent.putExtra("dept","Mech");
                startActivity(intent);
                overridePendingTransition(R.anim.from_left,R.anim.from_right);
                break;
            case R.id.tvSideBarBtn:
                //Brings the SideBar
                drawerLayout.openDrawer(Gravity.LEFT);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            //Gets the dept selected from the settings Activity
            int pos = data.getIntExtra("dept",0);
            String value=null;
            switch (pos){
                case 0: value = "CSE";
                break;
                case 1: value = "ECE";
                break;
                case 2: value = "EEE";
                break;
                case 3: value = "Mech";
                break;
            }

            //Adding Department to Shared preferences
            String result = "Department : "+value;
            tvDept.setText(result);
            editor.putString("department",result);
            editor.apply();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.tvAcademics:
                Intent academicsActivtiyIntent = new Intent(FirstActivity.this,AcademicsActivity.class);
                startActivity(academicsActivtiyIntent);
                overridePendingTransition(R.anim.from_left,R.anim.from_right);
                break;
            case R.id.tvSettings:
                Intent settingsActivtiyIntent = new Intent(FirstActivity.this,SettingsActivity.class);
                //Starts activity for result
                startActivityForResult(settingsActivtiyIntent,1);
                overridePendingTransition(R.anim.from_left,R.anim.from_right);
                break;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}