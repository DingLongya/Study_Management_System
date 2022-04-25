package com.e.library_management_system;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SignInActivity extends AppCompatActivity {
    private DateBaseHelper dbhelper = new DateBaseHelper(this, "study_list.db", null, 1);
    private EditText acount_ed, password_ed;
    private int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        //实现新用户注册
        findViewById(R.id.signup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        acount_ed = findViewById(R.id.acount);
        password_ed = findViewById(R.id.password);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //实现登录
        findViewById(R.id.signinButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //验证登录
                flag = 0;
                if(acount_ed.getText().length() != 0 && password_ed.getText().length() != 0) {
                    SQLiteDatabase db = dbhelper.getReadableDatabase();
                    Cursor cursor = db.rawQuery("select * from study_list", null);
                    while(cursor.moveToNext()) {
                        String acount_list = cursor.getString(cursor.getColumnIndex("acount"));
                        String password_list = cursor.getString(cursor.getColumnIndex("password"));
                        if(acount_ed.getText().toString().equals(acount_list) == true && password_ed.getText().toString().equals(password_list) == true){
                            flag = 1;
                            break;
                        }else{
                            flag = 2;
                        }
                    }
                    if(flag == 1) {
                        //正常登录
                        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                        startActivity(intent);
                    }else if(flag == 2) {
                        builder.setTitle("提示");
                        builder.setMessage("请注册帐号");
                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        builder.show();
                    }
                }else{
                    builder.setTitle("提示");
                    builder.setMessage("请输入帐号");
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    builder.show();
                }
            }
        });
    }
}
