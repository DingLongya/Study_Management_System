package com.e.library_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity implements HttpGetDataListener {

    private HttpDate httpDate;
    private List<ListData> lists;
    private ListView listView;
    private EditText editText;
    private Button button;
    private String content_str;
    private TextAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        initView();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                content_str = editText.getText().toString();
                editText.setText("");
                ListData listData = new ListData(content_str, ListData.SEND);
                lists.add(listData);
                adapter.notifyDataSetChanged();
                http();
            }
        });
    }

    public void http() {
        httpDate = (HttpDate) new HttpDate(
                "http://www.tuling123.com/openapi/api?key=94a85202322644118c73f1b2e7178c4d&info="
                        + content_str, this).execute();
    }
    @Override
    public void getDataUrl(String data) {
          parseText(data);
    }

    private void initView() {
        lists = new ArrayList<ListData>();
        listView = findViewById(R.id.lv);
        editText = findViewById(R.id.sendText);
        button = findViewById(R.id.sendBtn);
        adapter = new TextAdapter(lists, this);
        listView.setAdapter(adapter);
    }

    public void parseText(String str) {
        try {
            JSONObject jb = new JSONObject(str);
            ListData listData = new ListData(jb.getString("text"), ListData.ReCEIVE);
            lists.add(listData);
            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
