package de.gwtgteam.gowiththegrow.ui.wiki;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentActivity;

import de.gwtgteam.gowiththegrow.DetailActivity;
import de.gwtgteam.gowiththegrow.R;

public class AZFragment extends AppCompatActivity implements AdapterView.OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plants);

        String title = "Pflanzen von A-Z";
        setTitle(title);

        TextView ananas = findViewById(R.id.ananas);
        ananas.setOnClickListener(this);
        TextView agave = findViewById(R.id.agave);
        agave.setOnClickListener(this);
        TextView aloevera = findViewById(R.id.aloevera);
        aloevera.setOnClickListener(this);
        TextView banane = findViewById(R.id.banane);
        banane.setOnClickListener(this);
        TextView basilikum = findViewById(R.id.basilikum);
        basilikum.setOnClickListener(this);
        TextView begonia = findViewById(R.id.begonia);
        begonia.setOnClickListener(this);
        TextView benjamini = findViewById(R.id.benjamini);
        benjamini.setOnClickListener(this);
        TextView calendula = findViewById(R.id.calendula);
        calendula.setOnClickListener(this);
        TextView chrysanthemen = findViewById(R.id.chrysanthemen);
        chrysanthemen.setOnClickListener(this);
        TextView dattelpalme = findViewById(R.id.dattelpalme);
        dattelpalme.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // Then you start a new Activity via Intent
        Intent intent = new Intent();
        intent.setClass(this.getBaseContext(), DetailActivity.class);
        startActivity(intent);
    }
}
