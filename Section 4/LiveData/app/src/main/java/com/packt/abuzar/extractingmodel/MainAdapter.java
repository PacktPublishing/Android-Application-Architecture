package com.packt.abuzar.extractingmodel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.packt.abuzar.extractingmodel.databinding.ItemLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends BaseAdapter {

    private final LayoutInflater layoutInflater;
    private final List<ProjectModel> projectModelList = new ArrayList<>();

    MainAdapter(Context context) {

        this.layoutInflater = LayoutInflater.from(context);
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ItemLayoutBinding binding = ItemLayoutBinding.inflate(layoutInflater, parent, false);
        binding.title.setText(projectModelList.get(position).title);
        return binding.getRoot();
    }
}
