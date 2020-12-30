package de.gwtgteam.gowiththegrow;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

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
    }
}