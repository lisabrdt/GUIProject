package de.gwtgteam.gowiththegrow;

import android.widget.ImageView;

public class Todos {

    private int image;
    private String name;
    private int icon;
    private String iconText;

    public Todos(int img, String nam, int ico, String icoTex){
        this.image = img;
        this.name = nam;
        this.icon = ico;
        this.iconText = icoTex;
    }

    public int getImage(){
        return this.image;
    }

    public String getName(){
        return this.name;
    }

    public int getIcon(){
        return this.icon;
    }

    public String getIconText(){
        return this.iconText;
    }
}
