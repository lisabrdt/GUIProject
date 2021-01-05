package de.gwtgteam.gowiththegrow.ui.dashboard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.MotionEventCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.gwtgteam.gowiththegrow.CustomLVAdapter;
import de.gwtgteam.gowiththegrow.DetailActivity;
import de.gwtgteam.gowiththegrow.MainActivity;
import de.gwtgteam.gowiththegrow.R;
import de.gwtgteam.gowiththegrow.Todos;
import de.gwtgteam.gowiththegrow.ui.wiki.AZFragment;



public class DashboardFragment extends Fragment implements AdapterView.OnClickListener{

    private DashboardViewModel dashboardViewModel;

    private CustomLVAdapter mAdapter;
    private RecyclerView mRecyclerView;

    Context mContext;

    View ChildView ;
    int RecyclerViewItemPosition ;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mContext = this.getContext();

        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.dashboard_list);

        //mRecyclerView

        final ArrayList<Todos> listItems = new ArrayList<>();
        listItems.add(new Todos(R.drawable.plant_photo_1, "ljsfhdgklsj", R.drawable.drop_small, "400ml"));
        listItems.add(new Todos(R.drawable.plant_photo_2, "dafgh", R.drawable.umtopfen, ""));
        listItems.add(new Todos(R.drawable.plant_photo_3, "htyjr", R.drawable.fertilizer, "50g"));
        listItems.add(new Todos(R.drawable.plant_photo_4, "uiuku", R.drawable.drop_small, "200ml"));

        mAdapter = new CustomLVAdapter(this.getActivity(), listItems);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            GestureDetector gestureDetector = new GestureDetector(mContext, new GestureDetector.SimpleOnGestureListener() {

                @Override public boolean onSingleTapUp(MotionEvent motionEvent) {

                    return true;
                }

            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {
               /*
                final int action = motionEvent.getAction();//MotionEventCompat.getActionMasked(motionEvent);

                if(action == MotionEvent.ACTION_UP){
                    Intent intent = new Intent();
                    intent.setClass(mContext, DetailActivity.class);
                    startActivity(intent);
                    return false;
                }
                return true; */
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {

            }



            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        return rootView;
    }

    @Override
    public void onClick(View v) {
        // Then you start a new Activity via Intent

    }
}