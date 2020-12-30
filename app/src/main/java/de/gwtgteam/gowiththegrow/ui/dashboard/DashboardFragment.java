package de.gwtgteam.gowiththegrow.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import de.gwtgteam.gowiththegrow.DetailActivity;
import de.gwtgteam.gowiththegrow.R;
import de.gwtgteam.gowiththegrow.ui.wiki.AZFragment;

public class DashboardFragment extends Fragment implements AdapterView.OnClickListener{

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        ConstraintLayout layout = root.findViewById(R.id.DashboardElement);
        layout.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        // Then you start a new Activity via Intent
        Intent intent = new Intent();
        intent.setClass(this.getContext(), DetailActivity.class);
        startActivity(intent);
    }
}