package com.nodomain.petajuegos.heroessimulator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    double hpActual, hpMaximo, nivel, manaMaximo, manaActual, expActual, expMaximo, hpActualEnemigo, hpMaximoEnemigo, manaMaximoEnemigo, manaActualEnemigo, ad, armorEnemigo, adEnemigo, armor;
    boolean atacar = false;
    String personaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego);
        inicializarComponentes();
        logicaBotones();
        Handler handler = new Handler();
        while (atacar) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ataqueEnemigo();
                }
            }, 2000);
        }

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
        personaje =  util.readFile(0);
        expActual = Double.parseDouble(util.readFile(1));
        nivel = Double.parseDouble(util.readFile(2));
        expMaximo = nivel * 40;
        switch (personaje) {
            case "Guerrero":
                guerrero = new Guerrero(nivel);
                hpMaximo = guerrero.getHp();
                hpActual = hpMaximo;
                ad = guerrero.getAd();
                armor = guerrero.getArmor();
                ivPersonaje.setImageResource(R.drawable.warrior);
                tvPersonaje.setText("HP: " + hpActual + "/" + hpMaximo + "\nExp: " + expActual + "/" + expMaximo + "\nNivel:" + nivel);
                break;
            case "Cazador":
                cazador = new Cazador(nivel);
                hpMaximo = cazador.getHp();
                hpActual = hpMaximo;
                manaMaximo = cazador.getMana();
                manaActual = manaMaximo;
                ad = cazador.getAd();
                armor = cazador.getArmor();
                ivPersonaje.setImageResource(R.drawable.cazador);
                tvPersonaje.setText("HP: " + hpActual + "/" + hpMaximo + "\nMana" + manaActual + "/" + manaMaximo + "\nExp: " + expActual + "/" + expMaximo + "\nNivel:" + nivel);
                break;
            case "Mago":
                mago = new Mago(nivel);
                hpMaximo = mago.getHp();
                hpActual = hpMaximo;
                manaMaximo = mago.getMana();
                armor = mago.getArmor();
                manaActual = manaMaximo;
                ad = mago.getAd();
                ivPersonaje.setImageResource(R.drawable.mago);
                tvPersonaje.setText("HP: " + hpActual + "/" + hpMaximo + "\nMana" + manaActual + "/" + manaMaximo + "\nExp: " + expActual + "/" + expMaximo + "\nNivel:" + nivel);
                break;
        }
        ibEnemigo.setImageResource(R.drawable.ogro);
        hpMaximoEnemigo = ogro.getHp();
        hpActualEnemigo = hpMaximoEnemigo;
        manaMaximoEnemigo = ogro.getMana();
        manaActualEnemigo = manaMaximoEnemigo;
        armorEnemigo = ogro.getArmor();
        adEnemigo = ogro.getAd();
        tvEnemigo.setText("HP: " + hpActualEnemigo + "/" + hpMaximoEnemigo + "\nMana" + manaActualEnemigo + "/" + manaMaximoEnemigo);

        //Ajustacion dinamica
        util.rellenarImageView(ivPersonaje, 1, 30, 40, false, 10, 5, 0);
        util.rellenarImageButton(ibEnemigo, 2, 30, 40, true, 20, 5, 0);
    }

    private void logicaBotones() {
        ibEnemigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hpActualEnemigo > 0) {
                    hpActualEnemigo = ad - (ad * (calculoArmor(armorEnemigo)) / 100);
                    if (hpActualEnemigo < 0) {
                        hpActualEnemigo = 0;
                        atacar = false;
                    }
                } else
                    nuevoEnemigo();
                refreshData();
            }
        });
    }

    public void nuevoEnemigo() {
        hpActualEnemigo = hpMaximoEnemigo;
        atacar = true;
    }

    public double calculoArmor(double armor) {
        double redDaño = 0;
        if (armor < 100)
            redDaño = armor * 0.35;
        if (armor > 100 && armor < 200)
            redDaño = 0.35 + armor * 0.30;
        if (armor > 200 && armor < 300)
            redDaño = 0.65 + armor * 0.20;
        if (armor > 300 && armor < 400)
            redDaño = 0.85 + armor * 0.10;
        if (armor > 400 && armor < 500)
            redDaño = 0.95 + armor * 0.04;
        return redDaño;
    }

    public void refreshData() {
        tvEnemigo.setText("HP: " + hpActualEnemigo + "/" + hpMaximoEnemigo + "\nMana" + manaActualEnemigo + "/" + manaMaximoEnemigo);
        if (personaje.equals("Guerrero"))
            tvPersonaje.setText("HP: " + hpActual + "/" + hpMaximo + "\nExp: " + expActual + "/" + expMaximo + "\nNivel:" + nivel);
        else
            tvPersonaje.setText("HP: " + hpActual + "/" + hpMaximo + "\nMana" + manaActual + "/" + manaMaximo + "\nExp: " + expActual + "/" + expMaximo + "\nNivel:" + nivel);
    }

    public void ataqueEnemigo() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (hpActual > 0) {
                    hpActual = adEnemigo - (adEnemigo * (calculoArmor(armor)) / 100);
                    if (hpActual < 0)
                        hpActual = 0;
                } else {
                    Toast.makeText(juego.this, "Has muerto", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(juego.this, MenuPrincipal.class);
                    startActivity(i);
                }
                refreshData();
            }
        }).start();
    }
}
