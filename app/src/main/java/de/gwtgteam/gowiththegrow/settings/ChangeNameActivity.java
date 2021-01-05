package de.gwtgteam.gowiththegrow.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.gwtgteam.gowiththegrow.R;

public class ChangeNameActivity extends AppCompatActivity {
    String title = "Name ändern";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_name);
        setTitle(title);

        findViewById(R.id.buttonChangeName).setOnClickListener(v -> {
            TextView tv = findViewById(R.id.settings_changedName);
            SettingsActivity.name = tv.getText().toString();
            SettingsActivity.changedSettings = true;
            onSave(v);
        });
    }

    public void onSave(View v) {
        Intent intent = new Intent();
        intent.setClass(this.getBaseContext(), SettingsActivity.class);
        startActivity(intent);
    }
}