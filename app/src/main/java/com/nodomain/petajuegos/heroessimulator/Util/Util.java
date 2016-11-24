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
import java.io.RandomAccessFile;

public class Util extends Activity {
    private Context context;
    private String ruta = "Personaje.txt";
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
            FileOutputStream fichero = new FileOutputStream(ruta);
            existe = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return existe;
    }

    public void rellenarImageButton(ImageButton boton,/*Segundo intento*/ int nBoton, int tamañoAncho, int tamañoAlto, boolean ordenHorizontal, int distanciaAncho, int distanciaAlto/* int posicion, int nFilas, boolean setY*/) {
        android.view.ViewGroup.LayoutParams params = boton.getLayoutParams();
        //Segundo intento
        int ancho = (getAncho()*tamañoAncho)/100;
        int alto = (getAlto()*tamañoAlto)/100;
        float margenIzquierdo;
        float margenArriba;
        if (ordenHorizontal) {
            margenIzquierdo = (ancho*(nBoton-1)) + (((nBoton * distanciaAncho) * getAncho()) / 100);
            margenArriba = (getAlto()*distanciaAlto)/100;
        } else {
            margenIzquierdo = (getAncho() * distanciaAncho) / 100;
            margenArriba = (alto*(nBoton-1))  + (((nBoton * distanciaAlto) * getAlto()) / 100);
        }
        params.height = alto;
        params.width = ancho;
        params.set
        boton.setTop((int)margenArriba);
        boton.setLeft((int)margenIzquierdo);
        boton.setLayoutParams(params);
        Log.e("Datos del boton " + nBoton, "Alto-Ancho: " + getAlto() + "-" + getAncho() + "\nAlto: " + alto + "\nAncho: " + ancho + "\nMargen izquierdo/arriba: " + margenIzquierdo + " - " + margenArriba);
        /*
        int tamañoFila = ((getAlto()/nFilas));
        params.height = (tamañoFila) - ((tamañoFila*10)/100);
        params.width = getAncho()/2;
        boton.setLayoutParams(params);
        if (setY)
            boton.setY(tamañoFila*posicion);
            */
    }
    public void rellenarImageView(ImageView boton, /*Segundo intento*/ int nBotones/*int posicion, double nFilas, boolean setY, boolean margenDerecho*/) {
        android.view.ViewGroup.LayoutParams params = boton.getLayoutParams();
        //segundo intento
        double anchoBoton = getAncho()/nBotones;
        /*
        double tamañoFila = ((getAlto()/nFilas));
        double ancho = (tamañoFila) - ((tamañoFila*10)/100);
        params.height = (int)ancho;
        params.width = getAncho()/2;
        boton.setLayoutParams(params);
        if (setY)
            boton.setY((float)tamañoFila*posicion);
        if (margenDerecho)
            boton.setX((float)(getAncho() - ancho));
            */
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
    public void createFile(String text, double[] stats) {
        try {
            RandomAccessFile raf = new RandomAccessFile(path, "rw");
            raf.writeChars(text);
            for (int i = 0;i<stats.length;i++)
                raf.writeDouble(stats[i]);
            raf.close();
        } catch (Exception e) {
            Log.e("Services", "CreateFile -> Creating file", e);
        }

    }
}
