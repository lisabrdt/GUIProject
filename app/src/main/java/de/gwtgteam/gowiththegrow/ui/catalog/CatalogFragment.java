package de.gwtgteam.gowiththegrow.ui.catalog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import de.gwtgteam.gowiththegrow.R;

public class CatalogFragment extends Fragment implements AdapterView.OnClickListener{

    private CatalogViewModel catalogViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        catalogViewModel =
                new ViewModelProvider(this).get(CatalogViewModel.class);
        View root = inflater.inflate(R.layout.fragment_catalog, container, false);
        //final TextView textView = root.findViewById(R.id.text_catalog);
        catalogViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onClick(View v) {

    }
}