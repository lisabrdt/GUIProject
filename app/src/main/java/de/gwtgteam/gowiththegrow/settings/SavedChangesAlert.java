package de.gwtgteam.gowiththegrow.settings;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class SavedChangesAlert extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Deine Daten wurden erfolgreich geändert")
                .setPositiveButton("okay", (dialogInterface, i) -> {
                });
        return builder.create();
    }
}
