package de.gwtgteam.gowiththegrow.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.gwtgteam.gowiththegrow.R;

public class ChangeLocActivity extends AppCompatActivity {
    String title = "Ort ändern";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_loc);


        setTitle(title);

        findViewById(R.id.buttonChangeLoc).setOnClickListener(v -> {
            TextView tv = findViewById(R.id.settings_changedLoc);
            SettingsActivity.loc = tv.getText().toString();
            onSave(v);
        });
    }

    public void onSave(View v) {
        Intent intent = new Intent();
        intent.setClass(this.getBaseContext(), SettingsActivity.class);
        startActivity(intent);
    }
}