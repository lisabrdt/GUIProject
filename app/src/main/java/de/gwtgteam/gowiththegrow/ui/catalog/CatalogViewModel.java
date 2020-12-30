package de.gwtgteam.gowiththegrow.ui.catalog;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CatalogViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CatalogViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the Catalog");
    }

    public LiveData<String> getText() {
        return mText;
    }
}