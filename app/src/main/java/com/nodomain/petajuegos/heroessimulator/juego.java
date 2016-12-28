package com.nodomain.petajuegos.heroessimulator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.nodomain.petajuegos.heroessimulator.Clases.Cazador;
import com.nodomain.petajuegos.heroessimulator.Clases.Guerrero;
import com.nodomain.petajuegos.heroessimulator.Clases.Mago;
import com.nodomain.petajuegos.heroessimulator.Clases.Ogro;
import com.nodomain.petajuegos.heroessimulator.Util.Util;

import org.w3c.dom.Text;

/**
 * Created by AUTOESCUELA FENIX on 26/12/2016.
 */

public class juego extends Activity {
    ImageView ivPersonaje;
    TextView tvPersonaje, tvEnemigo;
    ImageButton ibEnemigo;
    Util util;
    Guerrero guerrero;
    Cazador cazador;
    Mago mago;
    Ogro ogro;
    double hpActual, hpMaximo, nivel, manaMaximo, manaActual, expActual, expMaximo, hpActualEnemigo, hpMaximoEnemigo, manaMaximoEnemigo, manaActualEnemigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego);
        inicializarComponentes();
        logicaBotones();
    }

    private void inicializarComponentes() {
        //Elementos visibles
        ivPersonaje = (ImageView) findViewById(R.id.ivPersonaje);
        tvPersonaje = (TextView) findViewById(R.id.tvPersonaje);
        ibEnemigo = (ImageButton) findViewById(R.id.ibEnemigo);
        tvEnemigo = (TextView) findViewById(R.id.tvEnemigo);

        //Exportaciones
        util = new Util(this);
        ogro = new Ogro(util.readFileMundo(0), util.readFileMundo(1));

        //Rellenar elementos
        String personaje = (String) util.readFile(0);
        expActual = (double) util.readFile(1);
        nivel = (double) util.readFile(2);
        expMaximo = nivel * 40;
        switch (personaje) {
            case "Guerrero":
                guerrero = new Guerrero(nivel);
                hpMaximo = guerrero.getHp();
                hpActual = hpMaximo;
                ivPersonaje.setImageResource(R.drawable.warrior);
                tvPersonaje.setText("HP: " + hpActual + "/" + hpMaximo + "\nExp: " + expActual + "/" + expMaximo + "\nNivel:" + nivel);
                break;
            case "Cazador":
                cazador = new Cazador(nivel);
                hpMaximo = cazador.getHp();
                hpActual = hpMaximo;
                manaMaximo = cazador.getMana();
                manaActual = manaMaximo;
                ivPersonaje.setImageResource(R.drawable.cazador);
                tvPersonaje.setText("HP: " + hpActual + "/" + hpMaximo + "\nMana" + manaActual + "/" + manaMaximo + "\nExp: " + expActual + "/" + expMaximo + "\nNivel:" + nivel);
                break;
            case "Mago":
                mago = new Mago(nivel);
                hpMaximo = mago.getHp();
                hpActual = hpMaximo;
                manaMaximo = mago.getMana();
                manaActual = manaMaximo;
                ivPersonaje.setImageResource(R.drawable.mago);
                tvPersonaje.setText("HP: " + hpActual + "/" + hpMaximo + "\nMana" + manaActual + "/" + manaMaximo + "\nExp: " + expActual + "/" + expMaximo + "\nNivel:" + nivel);
                break;
        }
        ibEnemigo.setImageResource(R.drawable.ogro);
        hpMaximoEnemigo = ogro.getHp();
        hpActualEnemigo = hpMaximoEnemigo;
        manaMaximoEnemigo = ogro.getMana();
        manaActualEnemigo = manaMaximoEnemigo;
        tvPersonaje.setText("HP: " + hpActualEnemigo + "/" + hpMaximoEnemigo + "\nMana" + manaActualEnemigo + "/" + manaMaximoEnemigo);

        //Ajustacion dinamica
        util.rellenarImageView(ivPersonaje, 1, 30, 40, false, 10, 5, 0);
        util.rellenarImageButton(ibEnemigo, 2, 30, 40, true, 20, 5, 0);
    }

    private void logicaBotones() {
        ibEnemigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hpActualEnemigo > 0) {
                    hpActualEnemigo--;
                    if (hpActualEnemigo < 0)
                        hpActualEnemigo = 0;
                } else
                    nuevoEnemigo();
            }
        });
    }

    public void nuevoEnemigo() {
        hpActualEnemigo = hpMaximoEnemigo;
    }
}
