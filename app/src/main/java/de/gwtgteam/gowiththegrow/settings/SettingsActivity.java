package de.gwtgteam.gowiththegrow.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.gwtgteam.gowiththegrow.MainActivity;
import de.gwtgteam.gowiththegrow.R;
import de.gwtgteam.gowiththegrow.ui.dashboard.DashboardFragment;

public class SettingsActivity extends AppCompatActivity {
    static String name = "Lisa";
    static String loc = "Hamburg";
    static String lang = "Deutsch";
    static boolean changedSettings = false;
    static String changeString = "";

    String[] temp = {"Celsius (°C)", "Fahreneinheit (°F)"};
    String[] water = {"Milliter (ml)", "Ounce (oz)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        String title = "Einstellungen";
        setTitle(title);

        TextView textViewName = findViewById(R.id.settings_name_value);
        textViewName.setText(name);

        TextView textViewLang = findViewById(R.id.settings_lang_value);
        textViewLang.setText(lang);

        TextView textViewLoc = findViewById(R.id.settings_loc_value);
        textViewLoc.setText(loc);

        //Dropdown Temperatur
        Spinner spin = findViewById(R.id.settings_temp_menu);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, temp);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        //Dropdown Wassereinheit
        spin = findViewById(R.id.settings_water_menu);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, water);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        findViewById(R.id.nameWrapper).setOnClickListener(this::onClickName);
        findViewById(R.id.langWrapper).setOnClickListener(this::onClickLang);
        findViewById(R.id.locWrapper).setOnClickListener(this::onClickLoc);

        findViewById(R.id.settings_back).setOnClickListener(this::goBack);

        if(changedSettings){
            alert();
            changedSettings = false;
        }
    }


    public void onClickName(View v) {
        Intent intent = new Intent();
        intent.setClass(this.getBaseContext(), ChangeNameActivity.class);
        startActivity(intent);
    }

    public void onClickLang(View v) {
        Intent intent = new Intent();
        intent.setClass(this.getBaseContext(), ChangeLangActivity.class);
        startActivity(intent);
    }

    public void onClickLoc(View v) {
        Intent intent = new Intent();
        intent.setClass(this.getBaseContext(), ChangeLocActivity.class);
        startActivity(intent);
    }

    public void goBack(View v) {
        Intent intent = new Intent();
        intent.setClass(this.getBaseContext(), MainActivity.class);
        startActivity(intent);
    }

    public void alert() {
        SavedChangesAlert alert = new SavedChangesAlert();
        alert.show(getSupportFragmentManager(), "saved changes dialog");
    }
}