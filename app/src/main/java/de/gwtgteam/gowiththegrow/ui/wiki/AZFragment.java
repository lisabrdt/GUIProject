package de.gwtgteam.gowiththegrow.ui.wiki;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import de.gwtgteam.gowiththegrow.R;

public class AZFragment extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plants);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        TextView myTextView = (TextView) findViewById(R.id.my_textview);
        myTextView.setText("Hi");

    }

}
