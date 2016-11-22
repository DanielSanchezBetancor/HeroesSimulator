package com.nodomain.petajuegos.heroessimulator.Util;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Util extends Activity {
    private Context context;
    private String ruta = "Jugador";
    private DisplayMetrics dm;
    static boolean exists = false;
    String path = "";
    public Util(Context context) {
        this.context = context;
        this.dm = context.getResources().getDisplayMetrics();
    }
    public void cambiarRuta(String ruta) {
        this.ruta = ruta;
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

    public void rellenarImageButton(ImageButton boton, int posicion, int nFilas, boolean setY) {
        android.view.ViewGroup.LayoutParams params = boton.getLayoutParams();
        int tamañoFila = ((getAlto()/nFilas));
        params.height = (tamañoFila) - ((tamañoFila*10)/100);
        params.width = getAncho()/2;
        boton.setLayoutParams(params);
        if (setY)
            boton.setY(tamañoFila*posicion);
    }
    public void rellenarImageView(ImageView boton, int posicion, double nFilas, boolean setY, boolean margenDerecho) {
        android.view.ViewGroup.LayoutParams params = boton.getLayoutParams();
        double tamañoFila = ((getAlto()/nFilas));
        double ancho = (tamañoFila) - ((tamañoFila*10)/100);
        params.height = (int)ancho;
        params.width = getAncho()/2;
        boton.setLayoutParams(params);
        if (setY)
            boton.setY((float)tamañoFila*posicion);
        if (margenDerecho)
            boton.setX((float)(getAncho() - ancho));
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
    public AlertDialog.Builder buildAD(Context context, String title, String message) {
        AlertDialog.Builder ad = new AlertDialog.Builder(context);
        ad.setTitle(title);
        ad.setMessage(message).setCancelable(false);
        return ad;
    }
    public void createFile(String text) {
        try {
            OutputStreamWriter outputstreamwriter = new OutputStreamWriter(openFileOutput(path, Context.MODE_PRIVATE));
            outputstreamwriter.write(text);
            outputstreamwriter.close();
        } catch (Exception e) {
            Log.e("Services", "CreateFile -> Creating file", e);
        }

    }
}
