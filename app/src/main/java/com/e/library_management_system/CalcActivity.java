package com.e.library_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//import android.app.Activity;

public class CalcActivity extends AppCompatActivity {

    private TextView calculator_monitor;
    private TextView getCalculator_monitor_result;
    private Button but_0, but_1, but_2, but_3, but_4, but_5, but_6, but_7, but_8, but_9,
            but_add, but_reduce, but_ride, but_except,
            but_point, but_pi, but_ce, but_x, but_equal, but_left, but_right;
    boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        calculator_monitor = (TextView)findViewById(R.id.editText);
        getCalculator_monitor_result = (TextView)findViewById(R.id.editText_result);
        but_0 = (Button)findViewById(R.id.button_0);
        but_1 = (Button)findViewById(R.id.button_1);
        but_2 = (Button)findViewById(R.id.button_2);
        but_3 = (Button)findViewById(R.id.button_3);
        but_4 = (Button)findViewById(R.id.button_4);
        but_5 = (Button)findViewById(R.id.button_5);
        but_6 = (Button)findViewById(R.id.button_6);
        but_7 = (Button)findViewById(R.id.button_7);
        but_8 = (Button)findViewById(R.id.button_8);
        but_9 = (Button)findViewById(R.id.button_9);
        but_add = (Button)findViewById(R.id.button_add);
        but_reduce = (Button)findViewById(R.id.button_reduce);
        but_ride = (Button)findViewById(R.id.button_ride);
        but_except = (Button)findViewById(R.id.button_except);
        but_point = (Button)findViewById(R.id.button_point);
        but_pi = (Button)findViewById(R.id.button_pi);
        but_ce = (Button)findViewById(R.id.button_ce);
        but_x = (Button)findViewById(R.id.button_x);
        but_equal = (Button)findViewById(R.id.button_equal);
        but_left = (Button)findViewById(R.id.button_left);
        but_right = (Button)findViewById(R.id.button_right);

        but_0.setOnClickListener(new MyOnClickListener());
        but_1.setOnClickListener(new MyOnClickListener());
        but_2.setOnClickListener(new MyOnClickListener());
        but_3.setOnClickListener(new MyOnClickListener());
        but_4.setOnClickListener(new MyOnClickListener());
        but_5.setOnClickListener(new MyOnClickListener());
        but_6.setOnClickListener(new MyOnClickListener());
        but_7.setOnClickListener(new MyOnClickListener());
        but_8.setOnClickListener(new MyOnClickListener());
        but_9.setOnClickListener(new MyOnClickListener());
        but_add.setOnClickListener(new MyOnClickListener());
        but_reduce.setOnClickListener(new MyOnClickListener());
        but_ride.setOnClickListener(new MyOnClickListener());
        but_except.setOnClickListener(new MyOnClickListener());
        but_point.setOnClickListener(new MyOnClickListener());
        but_pi.setOnClickListener(new MyOnClickListener());
        but_x.setOnClickListener(new MyOnClickListener());
        but_ce.setOnClickListener(new MyOnClickListener());
        but_equal.setOnClickListener(new MyOnClickListener());
        but_left.setOnClickListener(new MyOnClickListener());
        but_right.setOnClickListener(new MyOnClickListener());
    }

    class MyOnClickListener implements View.OnClickListener{
        public void onClick(View v){
            switch(v.getId()){
                case R.id.button_ce:
                    calculator_monitor.setText(null);
                    break;
                case R.id.button_0:
                    if(!flag){
                        calculator_monitor.setText(null);
                    }
                    flag = true;
                    String str0 = calculator_monitor.getText().toString();
                    str0 += "0";
                    calculator_monitor.setText(str0);
                    break;
                case R.id.button_1:
                    if(!flag){
                        calculator_monitor.setText(null);
                    }
                    flag = true;
                    String str1 = calculator_monitor.getText().toString();
                    str1 += "1";
                    calculator_monitor.setText(str1);
                    break;
                case R.id.button_2:
                    if(!flag){
                        calculator_monitor.setText(null);
                    }
                    flag = true;
                    String str2 = calculator_monitor.getText().toString();
                    str2 += "2";
                    calculator_monitor.setText(str2);
                    break;
                case R.id.button_3:
                    if(!flag){
                        calculator_monitor.setText(null);
                    }
                    flag = true;
                    String str3 = calculator_monitor.getText().toString();
                    str3 += "3";
                    calculator_monitor.setText(str3);
                    break;
                case R.id.button_4:
                    if(!flag){
                        calculator_monitor.setText(null);
                    }
                    flag = true;
                    String str4 = calculator_monitor.getText().toString();
                    str4 += "4";
                    calculator_monitor.setText(str4);
                    break;
                case R.id.button_5:
                    if(!flag){
                        calculator_monitor.setText(null);
                    }
                    flag = true;
                    String str5 = calculator_monitor.getText().toString();
                    str5 += "5";
                    calculator_monitor.setText(str5);
                    break;
                case R.id.button_6:
                    if(!flag){
                        calculator_monitor.setText(null);
                    }
                    flag = true;
                    String str6 = calculator_monitor.getText().toString();
                    str6 += "6";
                    calculator_monitor.setText(str6);
                    break;
                case R.id.button_7:
                    if(!flag){
                        calculator_monitor.setText(null);
                    }
                    flag = true;
                    String str7 = calculator_monitor.getText().toString();
                    str7 += "7";
                    calculator_monitor.setText(str7);
                    break;
                case R.id.button_8:
                    if(!flag){
                        calculator_monitor.setText(null);
                    }
                    flag = true;
                    String str8 = calculator_monitor.getText().toString();
                    str8 += "8";
                    calculator_monitor.setText(str8);
                    break;
                case R.id.button_9:
                    if(!flag){
                        calculator_monitor.setText(null);
                    }
                    flag = true;
                    String str9 = calculator_monitor.getText().toString();
                    str9 += "9";
                    calculator_monitor.setText(str9);
                    break;
                case R.id.button_x:
                    String str_x = calculator_monitor.getText().toString();
                    str_x = str_x.substring(0, str_x.length() - 1);
                    calculator_monitor.setText(str_x);
                    break;
                case R.id.button_pi:
                    if(!flag){
                        calculator_monitor.setText(null);
                    }
                    flag = true;
                    String str_pi = calculator_monitor.getText().toString();
                    str_pi += "3.1415";
                    calculator_monitor.setText(str_pi);
                    break;
                case R.id.button_point:
                    if(!flag){
                        calculator_monitor.setText(null);
                    }
                    flag = true;
                    String str_point = calculator_monitor.getText().toString();
                    str_point += ".";
                    calculator_monitor.setText(str_point);
                    break;
                case R.id.button_left:
                    if(!flag){
                        calculator_monitor.setText(null);
                    }
                    flag = true;
                    String str_left = calculator_monitor.getText().toString();
                    str_left += "(";
                    calculator_monitor.setText(str_left);
                    break;
                case R.id.button_right:
                    if(!flag){
                        calculator_monitor.setText(null);
                    }
                    flag = true;
                    String str_right = calculator_monitor.getText().toString();
                    str_right += ")";
                    calculator_monitor.setText(str_right);
                    break;
                case R.id.button_add:
                    if(!flag){
                        calculator_monitor.setText(null);
                    }
                    flag = true;
                    String str_add = calculator_monitor.getText().toString();
                    str_add += "+";
                    calculator_monitor.setText(str_add);
                    break;
                case R.id.button_reduce:
                    if(!flag){
                        calculator_monitor.setText(null);
                    }
                    flag = true;
                    String str_reduce = calculator_monitor.getText().toString();
                    str_reduce += "-";
                    calculator_monitor.setText(str_reduce);
                    break;
                case R.id.button_ride:
                    if(!flag){
                        calculator_monitor.setText(null);
                    }
                    flag = true;
                    String str_ride = calculator_monitor.getText().toString();
                    str_ride += "*";
                    calculator_monitor.setText(str_ride);
                    break;
                case R.id.button_except:
                    if(!flag){
                        calculator_monitor.setText(null);
                    }
                    flag = true;
                    String str_except = calculator_monitor.getText().toString();
                    str_except += "/";
                    calculator_monitor.setText(str_except);
                    break;
                case R.id.button_equal:
                    if(!flag){
                        calculator_monitor.setText(null);
                        calculator_monitor.setText("?????????????????????");
                        break;
                    }
                    flag = true;
                    String str = calculator_monitor.getText().toString();
                    BigDecimal result = cal(str);
                    calculator_monitor.setText(str);
                    getCalculator_monitor_result.setText(result.toString());
                    //getCalculator_monitor_result.setText("??????????????? 0");
                    break;
            }
        }

        public BigDecimal cal(String str) {
            // ????????????????????????????????????????????????????????????????????????
            // ???????????????????????????
            List<String> list = new ArrayList<>();
            char[] arr = str.toCharArray();
            // ????????????????????????
            StringBuffer tmpStr = new StringBuffer();
            for (char c : arr) {
                // ??????????????????????????????????????????????????????
                if (c >= '0' && c <= '9') {
                    tmpStr.append(c);
                } else if (c == '.') {
                    if (tmpStr.indexOf(".") > 0) {
                        throw new RuntimeException("????????????");
                    }
                    tmpStr.append(c);
                }
                // ?????????????????????????????????????????????????????????????????????????????????list???
                else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') {
                    if (tmpStr.length() > 0) {
                        list.add(tmpStr.toString());
                        tmpStr.setLength(0);
                    }
                    list.add(c + "");
                }
                // ????????????????????????
                else if (c == ' ') {
                    continue;
                } else {
                    throw new RuntimeException("????????????");
                }
            }
            if (tmpStr.length() > 0) {
                list.add(tmpStr.toString());
            }
            // ????????????????????????
            List<String> strList = new ArrayList<>();
            // ?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
            Stack<String> stack = new Stack<>();
            // ???????????????????????????????????????
            String tmp;
            // 1. ??????????????????????????????????????????
            for (String s : list) {
                // ??????????????????????????????
                if (s.equals("(")) {
                    stack.push(s);
                }
                // ?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
                else if (s.equals(")")) {
                    while (!(tmp = stack.pop()).equals("(")) {
                        strList.add(tmp);
                    }
                }
                // ?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
                else if (s.equals("*") || s.equals("/")) {
                    while (!stack.isEmpty()) {
                        // ??????????????????
                        tmp = stack.peek();
                        if (tmp.equals("*") || tmp.equals("/")) {
                            stack.pop();
                            strList.add(tmp);
                        } else {
                            break;
                        }
                    }
                    stack.push(s);
                } else if (s.equals("+") || s.equals("-")) {
                    while (!stack.isEmpty()) {
                        // ??????????????????
                        tmp = stack.peek();
                        if (!tmp.equals("(")) {
                            stack.pop();
                            strList.add(tmp);
                        } else {
                            break;
                        }
                    }
                    stack.push(s);
                }
                // ???????????????????????????????????????????????????
                else {
                    strList.add(s);
                }
            }
            // ?????????????????????????????????????????????
            while (!stack.isEmpty()) {
                strList.add(stack.pop());
            }
            // 2.???????????????????????????
            Stack<BigDecimal> newStack = new Stack<>();
            for (String s : strList) {
                // ??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
                // ???????????????????????????????????????????????????????????????
                if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                    BigDecimal b1 = newStack.pop();
                    BigDecimal b2 = newStack.pop();
                    switch (s) {
                        case "+":
                            newStack.push(b2.add(b1));
                            break;
                        case "-":
                            newStack.push(b2.subtract(b1));
                            break;
                        case "*":
                            newStack.push(b2.multiply(b1));
                            break;
                        case "/":
                            newStack.push(b2.divide(b1, 9, BigDecimal.ROUND_HALF_UP));
                            break;
                    }
                }
                // ????????????????????????
                else {
                    newStack.push(new BigDecimal(s));
                }
            }
            // ??????????????????????????????????????????????????????
            return newStack.peek();
        }
    }
}
