package com.packt.abuzar.extractingmodel.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.packt.abuzar.extractingmodel.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends BaseAdapter {

    private final LayoutInflater layoutInflater;
    private final List<ProjectModel> projectModelList = new ArrayList<>();
    Context context;

    public MainAdapter(Context context) {

        this.layoutInflater = LayoutInflater.from(context);
        this.context=context;
    }

    @Override
    public int getCount() {
        return projectModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return projectModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addItems(List<ProjectModel> list) {
        projectModelList.addAll(list);
        notifyDataSetChanged();
    }


    @BindView(R.id.title)
    TextView titleView;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v = LayoutInflater.from(context).inflate(R.layout.item_layout, null);
        ButterKnife.bind(this, v);
        titleView.setText(projectModelList.get(position).title);
        return v;
    }
}
