package de.gwtgteam.gowiththegrow.ui.wiki;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

public class WikiFragment extends Fragment implements AdapterView.OnItemClickListener {

    private WikiViewModel wikiViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        wikiViewModel =
                new ViewModelProvider(this).get(WikiViewModel.class);
        View root = inflater.inflate(R.layout.fragment_wiki, container, false);
        ListView listView = (ListView) root.findViewById(R.id.list_wiki);

        ArrayList<String> list = new ArrayList<>();
        list.add("Pflanzen von A-Z");
        list.add("Alles übers Gießen");
        list.add("Alles übers Licht");
        list.add("Alles übers Umtopfen");
        list.add("Alles übers Düngen");
        list.add("Alles über Schädlinge");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this.getContext(), R.drawable.wiki_list_element, list);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);

        wikiViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Then you start a new Activity via Intent
        Intent intent = new Intent();
        intent.setClass(this.getContext(), AZFragment.class);
        intent.putExtra("position", position);
        // Or / And
        intent.putExtra("id", id);
        startActivity(intent);
    }
}