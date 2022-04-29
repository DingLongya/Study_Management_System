package com.e.library_management_system;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class TextAdapter extends BaseAdapter {

    private List<ListData> lists;
    private Context comtext;
    private RelativeLayout layout;

    public TextAdapter(List<ListData> lists, Context comtext) {
        this.lists = lists;
        this.comtext = comtext;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(comtext);
        if(lists.get(i).getFlag() == ListData.ReCEIVE) {
            layout = (RelativeLayout) inflater.inflate(R.layout.leftitem, null);
        }else if(lists.get(i).getFlag() == ListData.SEND) {
            layout = (RelativeLayout) inflater.inflate(R.layout.rightitem, null);
        }
        TextView textView = (TextView) layout.findViewById(R.id.tv);
        textView.setText(lists.get(i).getContent().toString());
        return layout;
    }
}
