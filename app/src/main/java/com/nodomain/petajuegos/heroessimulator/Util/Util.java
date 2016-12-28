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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

    public int getAlto() {
        return dm.heightPixels;
    }

    public int getAncho() {
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

    public int rellenarImageButton(ImageButton boton,/*Segundo intento*/ int nBoton, int tamañoAncho, int tamañoAlto, boolean ordenHorizontal, int distanciaAncho, int distanciaAlto, int altoBotonAnterior/* int posicion, int nFilas, boolean setY*/) {
        ViewGroup.MarginLayoutParams mlp;
        mlp = new ViewGroup.MarginLayoutParams(boton.getLayoutParams());
        //Segundo intento
        int ancho = (getAncho() * tamañoAncho) / 100;
        int alto = (getAlto() * tamañoAlto) / 100;
        float margenIzquierdo;
        float margenArriba;
        if (ordenHorizontal) {
            margenIzquierdo = (ancho * (nBoton - 1)) + (((nBoton * distanciaAncho) * getAncho()) / 100);
            margenArriba = (getAlto() * distanciaAlto) / 100;
        } else {
            margenIzquierdo = (getAncho() * distanciaAncho) / 100;
            if (nBoton == 1)
                margenArriba = (getAlto() * distanciaAlto) / 100;
            else
                margenArriba = ((getAlto() * distanciaAlto) / 100) + altoBotonAnterior;
        }
        mlp.height = alto;
        mlp.width = ancho;
        mlp.setMargins((int) margenIzquierdo, (int) margenArriba, 0, 0);
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(mlp);
        boton.setLayoutParams(rlp);
        Log.e("Datos del boton " + nBoton, "Alto-Ancho: " + getAlto() + "-" + getAncho() + "\nAlto: " + alto + "\nAncho: " + ancho + "\nMargen izquierdo/arriba: " + margenIzquierdo + " - " + margenArriba);
        /*
        int tamañoFila = ((getAlto()/nFilas));
        params.height = (tamañoFila) - ((tamañoFila*10)/100);
        params.width = getAncho()/2;
        boton.setLayoutParams(params);
        if (setY)
            boton.setY(tamañoFila*posicion);
            */
        return (int) margenArriba + alto;
    }

    public int rellenarImageView(ImageView boton, /*Segundo intento*/ int nBoton, int tamañoAncho, int tamañoAlto, boolean ordenHorizontal, int distanciaAncho, int distanciaAlto, int altoBotonAnterior/*int posicion, double nFilas, boolean setY, boolean margenDerecho*/) {
        android.view.ViewGroup.LayoutParams params = boton.getLayoutParams();
        //segundo intento
        ViewGroup.MarginLayoutParams mlp;
        mlp = new ViewGroup.MarginLayoutParams(boton.getLayoutParams());
        //Segundo intento
        int ancho = (getAncho() * tamañoAncho) / 100;
        int alto = (getAlto() * tamañoAlto) / 100;
        float margenIzquierdo;
        float margenArriba;
        if (ordenHorizontal) {
            margenIzquierdo = (ancho * (nBoton - 1)) + (((nBoton * distanciaAncho) * getAncho()) / 100);
            margenArriba = ((getAlto() * distanciaAlto)) / 100 + altoBotonAnterior;
        } else {
            margenIzquierdo = (getAncho() * distanciaAncho) / 100;
            if (nBoton == 1)
                margenArriba = (getAlto() * distanciaAlto) / 100;
            else
                margenArriba = ((getAlto() * distanciaAlto) / 100) + altoBotonAnterior;
        }
        mlp.height = alto;
        mlp.width = ancho;
        mlp.setMargins((int) margenIzquierdo, (int) margenArriba, 0, 0);
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(mlp);
        boton.setLayoutParams(rlp);
        Log.e("Datos del boton " + nBoton, "Alto-Ancho: " + getAlto() + "-" + getAncho() + "\nAlto: " + alto + "\nAncho: " + ancho + "\nMargen izquierdo/arriba: " + margenIzquierdo + " - " + margenArriba);
        return (int) margenArriba + alto;
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
        ViewGroup.MarginLayoutParams mlp = new ViewGroup.MarginLayoutParams(0, 0);
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

    public void createJugadorFile(String personaje, double exp, double lvl) {
        try {
            RandomAccessFile raf = new RandomAccessFile(path, "rw");
            raf.setLength(16);
            raf.writeChars(personaje);
            raf.writeDouble(exp);
            raf.writeDouble(lvl);
            raf.close();
        } catch (Exception e) {
            Log.e("Services", "CreateFile -> Creating file", e);
        }
    }

    public Object readFile(int fin) {
        Object o = new Object();
        try {
            RandomAccessFile raf = new RandomAccessFile(path, "r");
            switch (fin) {
                case 0:
                    String linea = raf.readLine();
                    o = linea.substring(0, 15).trim();
                    break;
                case 1:
                    raf.seek(16);
                    o = raf.readDouble();
                    break;
                case 2:
                    raf.seek(16);
                    raf.readDouble();
                    o = raf.readDouble();
            }
        } catch (IOException e) {
            Log.e("Util", "readFile -> No encontro el fichero (IO)", e);
        }
        return o;
    }

    public void crearFicheroMundo(double sbMuertos, double bossMuertos) {
        try {
            RandomAccessFile raf = new RandomAccessFile(path, "rw");
            raf.writeDouble(sbMuertos);
            raf.writeDouble(bossMuertos);
            raf.close();
        } catch (IOException e) {
            Log.e("Util", "crearFicheroMundo -> No encontro el fichero (IO)", e);
        }
    }

    public Double readFileMundo(int fin) {
        double dato = -1;
        try {
            RandomAccessFile raf = new RandomAccessFile(path, "r");
            switch (fin) {
                //Devuelve la cantidad de super bosses muertos
                case 0:
                    dato = raf.readDouble();
                    break;
                //Devuelve la cantidad de bosses muertos
                case 1:
                    raf.readDouble();
                    dato = raf.readDouble();
                    break;
            }
        } catch (IOException e) {
            Log.e("Util", "readFile -> No encontro el fichero (IO)", e);
        }
        return dato;
    }
}
