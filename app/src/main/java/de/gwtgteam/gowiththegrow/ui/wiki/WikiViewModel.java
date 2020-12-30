package de.gwtgteam.gowiththegrow.ui.wiki;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WikiViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public WikiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the wiki");

    }

    public LiveData<String> getText() {
        return mText;
    }
}