package de.gwtgteam.gowiththegrow.ui.dashboard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.gwtgteam.gowiththegrow.CustomLVAdapter;
import de.gwtgteam.gowiththegrow.DetailActivity;
import de.gwtgteam.gowiththegrow.R;
import de.gwtgteam.gowiththegrow.Todos;
import de.gwtgteam.gowiththegrow.ui.wiki.AZFragment;



public class DashboardFragment extends Fragment implements AdapterView.OnClickListener{

    private DashboardViewModel dashboardViewModel;

    private CustomLVAdapter mAdapter;
    private RecyclerView mRecyclerView;

    Context mContext;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        /*
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        mContext = this.getContext();

        RecyclerView lv = (RecyclerView) root.findViewById(R.id.dashboard_list);

        lv.setLayoutManager(new GridLayoutManager(getActivity(), 1));

        final ArrayList<Todos> listItems = new ArrayList<>();

        //Add data to arraylist

        listItems.add(new Todos(R.drawable.plant_photo_1, "ljsfhdgklsj", R.drawable.drop_small, "400ml"));
        listItems.add(new Todos(R.drawable.plant_photo_2, "dafgh", R.drawable.umtopfen, ""));
        listItems.add(new Todos(R.drawable.plant_photo_3, "htyjr", R.drawable.fertilizer, "50g"));
        listItems.add(new Todos(R.drawable.plant_photo_4, "uiuku", R.drawable.drop_small, "200ml"));

        final CustomLVAdapter adapter = new CustomLVAdapter((Activity) this.getContext(), listItems);

        lv.setAdapter(adapter); */






        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        // BEGIN_INCLUDE(initializeRecyclerView)
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.dashboard_list);

        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.


        final ArrayList<Todos> listItems = new ArrayList<>();

        //Add data to arraylist

        listItems.add(new Todos(R.drawable.plant_photo_1, "ljsfhdgklsj", R.drawable.drop_small, "400ml"));
        listItems.add(new Todos(R.drawable.plant_photo_2, "dafgh", R.drawable.umtopfen, ""));
        listItems.add(new Todos(R.drawable.plant_photo_3, "htyjr", R.drawable.fertilizer, "50g"));
        listItems.add(new Todos(R.drawable.plant_photo_4, "uiuku", R.drawable.drop_small, "200ml"));
        mAdapter = new CustomLVAdapter(this.getActivity(), listItems);
        // Set CustomAdapter as the adapter for RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        // END_INCLUDE(initializeRecyclerView)


        /*
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Todos mv= listItems.get(position);
                //Toast.makeText(mContext, mv.getName() + " clicked!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.setClass(mContext, DetailActivity.class);
                startActivity(intent);
            }
        }); */

        return rootView;
    }

    @Override
    public void onClick(View v) {
        // Then you start a new Activity via Intent

    }
}