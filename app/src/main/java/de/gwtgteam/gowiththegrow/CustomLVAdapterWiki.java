package de.gwtgteam.gowiththegrow;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomLVAdapterWiki extends BaseAdapter {

    //ArrayList<Movies> mItemList;

    private String[] localDataSet;

    public Activity context;
    public LayoutInflater inflater;

    private TextView text;

    public CustomLVAdapterWiki(Activity context, String[] itemList) {
        this.context = context;
        this.localDataSet = itemList;
    }

    @Override
    public int getCount() {
        return localDataSet.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.wiki_element, parent, false);
        text = convertView.findViewById(R.id.wikiText);

        text.setText(localDataSet[position]);
        return convertView;
    }
}