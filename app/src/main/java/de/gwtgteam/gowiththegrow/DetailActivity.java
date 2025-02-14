package de.gwtgteam.gowiththegrow;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import de.gwtgteam.gowiththegrow.settings.SavedChangesAlert;
import de.gwtgteam.gowiththegrow.ui.wiki.AZFragment;

public class DetailActivity extends AppCompatActivity {
    String title = "Ananas";
    int img = R.drawable.plant_photo_7;
    String family = "Bromeliengewächse";
    String latinName = "Ananas comosus 'Variegatus'";
    String light = "Mag es hell und braucht einige Stunden tägliche Sonnenbestrahlung";
    String temp = "Braucht einen warmen Standort. Dieser sollte das gesamte Jahr über nicht unter 18 Grad Celsius fallen";
    String water = "regelmäßig gießen und ein Austrocknen des Substrats verhindern. Aber aufgepasst: Staunässe verträgt die Ananas nicht.";
    String humidity = "liebt eine hohe Luftfeuchtigkeit. Deshalb solltest du versuchen diese immer über 50% zu halten";
    String dung = "bedarf nur weniger zusätzlicher Nährstoffe. Verwöhne deine Ananas von April bis August alle 14 Tage mit einer Dosis Flüssigdünger.";
    String pest = "Grundsätzlich ist die Zierananas nicht sehr anfällig für Schädlinge und Krankheiten. Häufig sind Pflegefehler das Problem. Diese lassen jedoch leicht mit der richtigen Pflege beheben.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setTitle(title);
        ImageView imageView = findViewById(R.id.detail_img);
        imageView.setImageResource(img);

        TextView textView = findViewById(R.id.detail_latin_name);
        textView.setText(latinName);

        textView = findViewById(R.id.detail_family);
        textView.setText(family);

        textView = findViewById(R.id.detail_info_temp);
        textView.setText(temp);

        textView = findViewById(R.id.detail_info_light);
        textView.setText(light);

        textView = findViewById(R.id.detail_info_water);
        textView.setText(water);

        textView = findViewById(R.id.detail_info_humidity);
        textView.setText(humidity);

        textView = findViewById(R.id.detail_info_dung);
        textView.setText(dung);

        textView = findViewById(R.id.detail_info_pest);
        textView.setText(pest);

        findViewById(R.id.details_addPlant).setOnClickListener(this::onAddPlant);
    }

    public void onAddPlant(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Möchtest du eine Ananas zu deinem Katalog hinzufügen?")
                .setCancelable(false)
                .setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        AlertDialog.Builder b = new AlertDialog.Builder(builder.getContext());
                        b.setMessage("Ananas erfolgreich hinzugefügt!")
                                .setCancelable(false)
                                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent intent = new Intent();
                                        Bundle bundle = new Bundle();
                                        bundle.putInt("key", R.id.navigation_catalog);
                                        intent.putExtras(bundle);
                                        intent.setClass(b.getContext(), MainActivity.class);
                                        startActivity(intent);
                                    }
                                }).setNegativeButton("", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                        AlertDialog alert = b.create();
                        alert.show();
                    }
                })
                .setNegativeButton("Nein", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}