package com.e.library_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PointActivity extends AppCompatActivity {
    private Button btn;
    private MyView myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);
        btn = (Button) findViewById(R.id.btn);
        myView = (MyView) findViewById(R.id.draw);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myView.clear();
            }
        });
    }

}
