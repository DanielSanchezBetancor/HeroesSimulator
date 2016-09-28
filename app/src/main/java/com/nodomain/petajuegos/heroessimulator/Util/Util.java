package com.nodomain.petajuegos.heroessimulator.Util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.FileOutputStream;
public class Util {
    private Context context;
    private String ruta = "Jugador";
    private DisplayMetrics dm;
    public Util(Context context) {
        this.context = context;
        this.dm = context.getResources().getDisplayMetrics();
    }
    public int getAlto () {
        return dm.heightPixels;
    }
    public int getAncho () {
        return dm.widthPixels;
    }
    public boolean getRuta() {
        boolean existe = false;
        try {
            FileOutputStream fichero = context.openFileOutput(ruta, Context.MODE_PRIVATE);
            existe = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return existe;
    }

    public void rellenarBoton(ImageButton boton, int posicion, int nFilas, boolean setY) {
        android.view.ViewGroup.LayoutParams params = boton.getLayoutParams();
        int tamañoFila = ((getAlto()/nFilas));
        params.height = (tamañoFila) - ((tamañoFila*10)/100);
        params.width = getAncho()/2;
        boton.setLayoutParams(params);
        if (setY)
            boton.setY(tamañoFila*posicion);
    }
    public void alinearTablon(ImageView iv, TextView tv, int margenAlto, int margenIzquierdo) {
        ViewGroup.MarginLayoutParams mlp = new ViewGroup.MarginLayoutParams(0,0);
        if (iv != null)
            mlp = new ViewGroup.MarginLayoutParams(iv.getLayoutParams());
        if (tv != null)
             mlp = new ViewGroup.MarginLayoutParams(tv.getLayoutParams());
        mlp.setMargins(margenIzquierdo, margenAlto, 0, 0);
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(mlp);
        if (iv != null)
            iv.setLayoutParams(rlp);
        if (tv != null)
            tv.setLayoutParams(rlp);
    }
}
