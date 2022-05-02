package com.e.library_management_system;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class KmActivity extends AppCompatActivity {
    private ServiceConnection serviceConnection;
    private MyService myService;
    private boolean bound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_km);
        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                //绑定服务
                MyService.MyBinder binder = (MyService.MyBinder) iBinder;
                myService = binder.getMy();
                bound = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                //解绑服务
                bound = false;
            }
        };
        displayDistance();
    }

    private void displayDistance() {
        TextView distanceView = findViewById(R.id.distance);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                double distance = 0.0;
                if(bound && myService != null) {
                    distance = myService.getDistance();
                }
                String distancestr = String.format(Locale.getDefault(), "%1$,.2f KM", distance);
                Log.d("TDD", distancestr);
                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(bound) {
            unbindService(serviceConnection);
            bound = false;
        }
    }

    private static final int PERMISSION_REQUEST_CODE = 698;
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onStart() {
        super.onStart();
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSION_REQUEST_CODE);
        }else{
            Intent intent = new Intent(this, MyService.class);
            bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:{
                if(grantResults.length>0 &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(this, MyService.class);
                    bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
                }else{
                    Toast.makeText(this, "Location permission required", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
