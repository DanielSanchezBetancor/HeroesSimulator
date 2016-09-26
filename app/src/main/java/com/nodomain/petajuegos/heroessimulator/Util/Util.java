package com.nodomain.petajuegos.heroessimulator.Util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

import java.io.FileOutputStream;

/**
 * Created by AUTOESCUELA FENIX on 22/09/2016.
 */

public class Util extends Activity{
    private Context context;
    private String ruta = "Jugador";
    public Util(Context context) {
        this.context = context;
    }
    public int getAlto () {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }
    public int getAncho () {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }
    public boolean getRuta() {
        boolean existe = false;
        try {
            FileOutputStream fichero = openFileOutput(ruta, Context.MODE_PRIVATE);
            existe = true;
        } catch (Exception e) {
        }
        return existe;
    }
}
