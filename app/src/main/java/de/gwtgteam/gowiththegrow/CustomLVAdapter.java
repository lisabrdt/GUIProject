package de.gwtgteam.gowiththegrow;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

import de.gwtgteam.gowiththegrow.settings.SettingsActivity;

public class CustomLVAdapter extends RecyclerView.Adapter<CustomLVAdapter.ViewHolder> {

    //ArrayList<Movies> mItemList;

    private ArrayList<Todos> localDataSet;

    public Activity context;
    public LayoutInflater inflater;

    private AdapterView.OnItemClickListener listener;


    public CustomLVAdapter(Activity context, ArrayList<Todos> itemList) {
        this.context = context;
        this.localDataSet = itemList;
        this.inflater = LayoutInflater.from(context);
    }

    public void restoreItem(Todos deletedItem, int deletedIndex) {
        localDataSet.add(deletedIndex, deletedItem);
        notifyItemInserted(deletedIndex);
    }

    public void removeItem(int adapterPosition) {
        localDataSet.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
    }

    public void setOnItemListener(AdapterView.OnItemClickListener listener) {
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView plantImage;
        TextView plantName;
        ImageView icon;
        TextView iconText;
        RelativeLayout background, foreground;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            plantImage = itemView.findViewById(R.id.dashboardElementImage);
            plantName = itemView.findViewById(R.id.dashboardElementName);
            icon = itemView.findViewById(R.id.dashboardElementIcon);
            iconText = itemView.findViewById(R.id.dashboardElementIconText);
            background = itemView.findViewById(R.id.view_background);
            foreground = itemView.findViewById(R.id.DashboardElement);
        }

        public ImageView getPlantImage(){
            return plantImage;
        }
        public TextView getPlantName(){
            return plantName;
        }
        public ImageView getPlantIcon(){
            return icon;
        }
        public TextView getPlantIconText(){
            return iconText;
        }
        public RelativeLayout getBackground() { return background; }
        public RelativeLayout getForeground() {return foreground; }

        public void bind(Context c) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(c, DetailActivity.class);
                    c.startActivity(intent);
                }
            });
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dashboard_element, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Todos mv = localDataSet.get(position);

        holder.getPlantImage().setImageResource(mv.getImage());
        holder.getPlantName().setText(mv.getName());
        holder.getPlantIcon().setImageResource(mv.getIcon());
        holder.getPlantIconText().setText(mv.getIconText());

        holder.bind(context);

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}