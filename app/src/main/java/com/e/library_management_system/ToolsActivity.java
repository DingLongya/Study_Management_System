package com.e.library_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ToolsActivity extends AppCompatActivity {

    private Button jisuanqi, jishiqi, licheng, erweima;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acount);
        jisuanqi = findViewById(R.id.jisuanqi);
        jishiqi = findViewById(R.id.jishiqi);
        licheng = findViewById(R.id.licheng);
        erweima = findViewById(R.id.erweima);
        jisuanqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ToolsActivity.this, CalcActivity.class);
                startActivity(intent);
            }
        });
        jishiqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ToolsActivity.this, StopActivity.class);
                startActivity(intent);
            }
        });
        licheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ToolsActivity.this, KmActivity.class);
                startActivity(intent);
            }
        });
        erweima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ToolsActivity.this, QrcodeActivity.class);
                startActivity(intent);
            }
        });
    }

}
