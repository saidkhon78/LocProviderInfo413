package com.androidapp.locproviderinfo413;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView mTxtInfo;
    LocationManager locManager;
    List<String> locProvidersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtInfo = findViewById(R.id.txtInfo);

        locManager = (LocationManager)getSystemService(LOCATION_SERVICE);
        locProvidersList = locManager.getAllProviders();
        mTxtInfo.setText("");

        for (String locProvider : locProvidersList){
            mTxtInfo.append("Loc. Provider: " + locProvider + "\n");
            mTxtInfo.append("Enabled: " + locManager.isProviderEnabled(locProvider) + "\n\n");
        }
    }
}