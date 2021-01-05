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

       // findViewById(R.id.details_addPlant).setOnClickListener(this::onAddPlant);
    }

    public void onAddPlant(View v) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage("Die Pflanze wurde deinem Katalog hinzugefügt")
//                .setPositiveButton("okay", (dialogInterface, i) -> {
//                    Intent intent = new Intent();
//                    intent.setClass(this.getBaseContext(), MainActivity.class);
//                    startActivity(intent);
//                });
//
//        Dialog alert = builder.create();
//        alert.show();
    }
}