package de.gwtgteam.gowiththegrow.ui.wiki;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

import de.gwtgteam.gowiththegrow.R;

public class AZFragment extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_plants);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        TextView myTextView = (TextView) findViewById(R.id.my_textview);
        myTextView.setText("Hi");

    }

}
