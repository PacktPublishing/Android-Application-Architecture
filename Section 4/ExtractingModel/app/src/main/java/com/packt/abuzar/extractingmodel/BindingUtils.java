package com.packt.abuzar.extractingmodel;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BindingUtils {

    @BindingAdapter("projectItem")
    public static void populateProjectList(ListView listView, List<ProjectModel> list) {
        if (list == null) {
            return;
        }
        MainAdapter adapter = (MainAdapter) listView.getAdapter();
        adapter.addItems(list);
    }

}
