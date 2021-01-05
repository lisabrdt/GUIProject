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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.gwtgteam.gowiththegrow.CustomLVAdapter;
import de.gwtgteam.gowiththegrow.CustomLVAdapterWiki;
import de.gwtgteam.gowiththegrow.R;

public class WikiFragment extends Fragment implements AdapterView.OnItemClickListener {

    private WikiViewModel wikiViewModel;

    private CustomLVAdapterWiki mAdapter;
    private ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        wikiViewModel =
                new ViewModelProvider(this).get(WikiViewModel.class);
        View root = inflater.inflate(R.layout.fragment_wiki, container, false);
        ListView listView = (ListView) root.findViewById(R.id.list_wiki);

        String[] list = new String[]{
                "Pflanzen von A-Z",
                "Alles übers Gießen",
                "Alles übers Licht",
                "Alles übers Umtopfen",
                "Alles übers Düngen",
                "Alles über Schädlinge"
        };

        mAdapter = new CustomLVAdapterWiki(this.getActivity(), list);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(this);

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