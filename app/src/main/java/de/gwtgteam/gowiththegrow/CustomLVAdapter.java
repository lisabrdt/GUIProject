package de.gwtgteam.gowiththegrow;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomLVAdapter extends BaseAdapter {

    //ArrayList<Movies> mItemList;

    ArrayList<Todos> itemList;

    public Activity context;
    public LayoutInflater inflater;

    public CustomLVAdapter(Activity context, ArrayList<Todos> itemList) {
        super();

        this.context = context;
        this.itemList = itemList;

        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Todos getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public static class ViewHolder {
        ImageView plantImage;
        TextView plantName;
        ImageView icon;
        TextView iconText;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Todos mv = itemList.get(position);

        ViewHolder holder;

        if(convertView==null) {

            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.dashboard_element, parent, false);

            holder.plantImage = convertView.findViewById(R.id.dashboardElementImage);
            holder.plantName = convertView.findViewById(R.id.dashboardElementName);
            holder.icon = convertView.findViewById(R.id.dashboardElementIcon);
            holder.iconText = convertView.findViewById(R.id.dashboardElementIconText);

            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        String rating_txt = "Rating: " + mv.getRating() + "/10";

        holder.poster.setImageResource(mv.getPoster());
        holder.title.setText(mv.getTitle());
        holder.rating.setText(rating_txt);
        holder.released.setText(mv.getReleased());

        return convertView;
    }
}