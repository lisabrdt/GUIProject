package de.gwtgteam.gowiththegrow.ui.catalog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import de.gwtgteam.gowiththegrow.DetailActivity;
import de.gwtgteam.gowiththegrow.MainActivity;
import de.gwtgteam.gowiththegrow.R;
import de.gwtgteam.gowiththegrow.settings.ChangeNameActivity;
import de.gwtgteam.gowiththegrow.ui.wiki.AZFragment;

public class CatalogFragment extends Fragment implements AdapterView.OnClickListener{

    private CatalogViewModel catalogViewModel;
    String[] options = {"manuell", "scannen"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        catalogViewModel =
                new ViewModelProvider(this).get(CatalogViewModel.class);
        View root = inflater.inflate(R.layout.fragment_catalog, container, false);
        //final TextView textView = root.findViewById(R.id.text_catalog);
        ImageView gruenlilie = root.findViewById(R.id.gruenlilie);
        gruenlilie.setOnClickListener(this);
        ImageView friedenslilie = root.findViewById(R.id.friedenslilie);
        friedenslilie.setOnClickListener(this);
        ImageView ananas = root.findViewById(R.id.ananas);
        ananas.setOnClickListener(this);
        ImageView eucalyptus = root.findViewById(R.id.eucalyptus);
        eucalyptus.setOnClickListener(this);
        ImageView monstera = root.findViewById(R.id.monstera);
        monstera.setOnClickListener(this);
        ImageView zwergpfeffer = root.findViewById(R.id.zwergpfeffer);
        zwergpfeffer.setOnClickListener(this);
        ImageView gluecksfeder = root.findViewById(R.id.gluecksfeder);
        gluecksfeder.setOnClickListener(this);
        ImageView monsteraTwo = root.findViewById(R.id.monsteraTwo);
        monsteraTwo.setOnClickListener(this);

        catalogViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });

        root.findViewById(R.id.add_plants).setOnClickListener(this::onAddPlant);

        return root;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(this.getContext(), DetailActivity.class);
        startActivity(intent);
    }

    public void onAddPlant(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setMessage("Pflanze hinzufügen")
                .setCancelable(false)
                .setPositiveButton("Scannen", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent();
                        Bundle b = new Bundle();
                        b.putInt("key", 1);
                        intent.putExtras(b);
                        intent.setClass(builder.getContext(), MainActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Manuell", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent();
                        intent.setClass(builder.getContext(), AZFragment.class);
                        startActivity(intent);
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}