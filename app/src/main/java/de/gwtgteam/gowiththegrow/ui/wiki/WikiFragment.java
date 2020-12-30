package de.gwtgteam.gowiththegrow.ui.wiki;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

import de.gwtgteam.gowiththegrow.R;

public class WikiFragment extends Fragment {

    private WikiViewModel wikiViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        wikiViewModel =
                new ViewModelProvider(this).get(WikiViewModel.class);
        View root = inflater.inflate(R.layout.fragment_wiki, container, false);
        ListView listView = (ListView) root.findViewById(R.id.list_wiki);

        ArrayList<String> list = new ArrayList<>();
        list.add("Test1");
        list.add("Test1");
        list.add("Test1");
        list.add("Test1");
        list.add("Test1");
        list.add("Test1");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this.getContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        wikiViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;
    }
}