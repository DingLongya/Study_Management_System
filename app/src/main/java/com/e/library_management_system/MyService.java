package com.e.library_management_system;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;

import androidx.annotation.RequiresApi;

import java.util.Random;

public class MyService extends Service {
    private double distanceMeters;
    private LocationManager locationManager;
    private LocationListener locationListener;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onCreate() {
        super.onCreate();
        //获取系统定位服务
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //选择定位传感器
        String provider = locationManager.getBestProvider(new Criteria(), true);
        //实现位置监听器
        locationListener = new LocationListener() {
            private Location lastLocation;

            @Override
            public void onLocationChanged(Location location) {
                if (lastLocation == null) {
                    lastLocation = location;
                }
                distanceMeters += location.distanceTo(lastLocation);
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(provider, 1000, 1, locationListener);
            return;
        }
    }
    public void onDestroy() {
        super.onDestroy();
        if(locationManager != null && locationListener != null) {
            locationManager.removeUpdates(locationListener);
        }
        locationManager = null;
        locationListener = null;
    }
    public class MyBinder extends Binder {
        MyService getMy() {
            return MyService.this;
        }
    }
    private Binder binder = new MyBinder();
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
    public double getDistance() {
        return distanceMeters/1000;
    }
}
