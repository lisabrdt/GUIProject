package de.gwtgteam.gowiththegrow;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class PlantStatusActivity extends AppCompatActivity {

    String title = "Zustandsanalyse";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_status);

        setTitle(title);

        findViewById(R.id.button_new_scan).setOnClickListener(this::newScan);
        findViewById(R.id.button_close_plant_status).setOnClickListener(this::close);
    }

    public void newScan(View v) {
        Intent intent = new Intent();
        Bundle b = new Bundle();
        b.putInt("key", R.id.navigation_scan);
        intent.putExtras(b);
        intent.setClass(this.getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void close(View v) {
        Intent intent = new Intent();
        intent.setClass(this.getBaseContext(), MainActivity.class);
        startActivity(intent);
    }
}