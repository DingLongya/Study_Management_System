package com.e.library_management_system;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {
    private EditText acount_cin, password_cin, password_cin_ok, qq;
    private DateBaseHelper dbhelper = new DateBaseHelper(this, "study_list.db", null, 1);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //实现返回到登录界面
        findViewById(R.id.back_sign_in).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });

        //实现点击查看 服务隐私
        TextView textView = (TextView) findViewById(R.id.warning);
        String name = "已阅读并同意服务协议";
        SpannableString spannableString = new SpannableString(name);
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Intent intent = new Intent(RegisterActivity.this, ServiceActivity.class);
                startActivity(intent);
            }
        }, 6, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        //读取内容
        acount_cin = findViewById(R.id.acount_cin);
        password_cin = findViewById(R.id.password_cin);
        password_cin_ok = findViewById(R.id.password_cin_ok);
        qq = findViewById(R.id.emial);

       //点击注册按钮
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
       findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               CheckBox checkBox = findViewById(R.id.checkbox);
               boolean ischecked = checkBox.isChecked();
               if(ischecked == true) {
                   //执行注册
                   if(acount_cin.getText().length() != 0 && password_cin.getText().length() != 0 && password_cin_ok.getText().length() != 0 && qq.getText().length() != 0) {
                       if(password_cin.getText().toString().equals(password_cin_ok.getText().toString()) == true) {
                           //存储到数据库
                           SQLiteDatabase db = dbhelper.getWritableDatabase();
                           ContentValues values = new ContentValues();
                           values.put("acount", acount_cin.getText().toString());
                           values.put("password", password_cin.getText().toString());
                           values.put("qq", qq.getText().toString());
                           db.insert("study_list",null, values);
                           values.clear();
                           db.close();
                           Log.d("TDD", "insert succeed");
                           builder.setTitle("提示");
                           builder.setMessage("注册成功");
                           builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                               @Override
                               public void onClick(DialogInterface dialogInterface, int i) {
                                   finish();
                               }
                           });
                           builder.show();
                       }else{
                           //提示两次输入的密码不一致
                           builder.setTitle("提示");
                           builder.setMessage("您输入的密码不一致");
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
                       builder.setMessage("请正确输入信息");
                       builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               dialogInterface.dismiss();
                           }
                       });
                       builder.show();
                   }
               }else{
                   //提示没选中服务协议
                   builder.setTitle("提示");
                   builder.setMessage("您还未同意服务协议");
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
