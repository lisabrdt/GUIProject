package de.gwtgteam.gowiththegrow.ui.dashboard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
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
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import de.gwtgteam.gowiththegrow.CustomLVAdapter;
import de.gwtgteam.gowiththegrow.DetailActivity;
import de.gwtgteam.gowiththegrow.MainActivity;
import de.gwtgteam.gowiththegrow.R;
import de.gwtgteam.gowiththegrow.RecyclerItemTouchHelper;
import de.gwtgteam.gowiththegrow.Todos;
import de.gwtgteam.gowiththegrow.ui.wiki.AZFragment;



public class DashboardFragment extends Fragment implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener{

    private DashboardViewModel dashboardViewModel;

    private CustomLVAdapter mAdapter;
    private RecyclerView mRecyclerView;

    Context mContext;

    private ArrayList<Todos> listItems;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mContext = this.getContext();

        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.dashboard_list);

        listItems = new ArrayList<>();
        listItems.add(new Todos(R.drawable.plant_photo_1, "Zwergpfeffer", R.drawable.drop_small, "400ml"));
        listItems.add(new Todos(R.drawable.plant_photo_2, "Eucalyptus", R.drawable.umtopfen, ""));
        listItems.add(new Todos(R.drawable.plant_photo_3, "Friedenslilie", R.drawable.fertilizer, "50g"));
        listItems.add(new Todos(R.drawable.plant_photo_4, "Monstera", R.drawable.drop_small, "200ml"));

        mAdapter = new CustomLVAdapter(this.getActivity(), listItems);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);

        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(mRecyclerView);

        // attaching the touch helper to recycler view
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(mRecyclerView);

        return rootView;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof CustomLVAdapter.ViewHolder) {
            // get the removed item name to display it in snack bar
            String name = listItems.get(viewHolder.getAdapterPosition()).getName();

            // backup of removed item for undo purpose
            final Todos deletedItem = listItems.get(viewHolder.getAdapterPosition());
            final int deletedIndex = viewHolder.getAdapterPosition();

            // remove the item from recycler view
            mAdapter.removeItem(viewHolder.getAdapterPosition());

            // showing snack bar with Undo option
            Snackbar snackbar = Snackbar
                    .make(mRecyclerView , name + " entfernt.", Snackbar.LENGTH_LONG);
            snackbar.setAction("rückgängig", new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // undo is selected, restore the deleted item
                    mAdapter.restoreItem(deletedItem, deletedIndex);
                }
            });
            snackbar.setActionTextColor(Color.parseColor("#588157"));
            snackbar.show();
        }
    }
}