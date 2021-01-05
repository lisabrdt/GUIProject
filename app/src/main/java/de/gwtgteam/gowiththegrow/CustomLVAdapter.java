package de.gwtgteam.gowiththegrow;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomLVAdapter extends RecyclerView.Adapter<CustomLVAdapter.ViewHolder> {

    //ArrayList<Movies> mItemList;

    private Todos[] localDataSet;

    public Activity context;
    public LayoutInflater inflater;

    public CustomLVAdapter(Activity context, ArrayList<Todos> itemList) {
        this.context = context;
        this.localDataSet = itemList.toArray(new Todos[itemList.size()]);
        this.inflater = LayoutInflater.from(context);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView plantImage;
        TextView plantName;
        ImageView icon;
        TextView iconText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            plantImage = itemView.findViewById(R.id.dashboardElementImage);
            plantName = itemView.findViewById(R.id.dashboardElementName);
            icon = itemView.findViewById(R.id.dashboardElementIcon);
            iconText = itemView.findViewById(R.id.dashboardElementIconText);
        }

        public ImageView getPlantImage(){
            return plantImage;
        }
        public TextView getPlantName(){
            return plantName;
        }
        public ImageView getPlantIcon(){
            return plantImage;
        }
        public TextView getPlantIconText(){
            return iconText;
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
        Todos mv = localDataSet[position];

        holder.getPlantImage().setImageResource(mv.getImage());
        holder.getPlantName().setText(mv.getName());
        holder.getPlantIcon().setImageResource(mv.getIcon());
        holder.getPlantIconText().setText(mv.getIconText());

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}