package com.nodomain.petajuegos.heroessimulator;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nodomain.petajuegos.heroessimulator.Clases.Cazador;
import com.nodomain.petajuegos.heroessimulator.Clases.Guerrero;
import com.nodomain.petajuegos.heroessimulator.Clases.Mago;
import com.nodomain.petajuegos.heroessimulator.Clases.guerrero;
import com.nodomain.petajuegos.heroessimulator.Util.Util;

public class seleccionpersonaje extends Activity {
    TextView tvEstadisticas;
    ImageView ivCaracter, ivEstadisticas;
    ImageButton ibCazador, ibGuerrero, ibMago, ibAtras, ibContinuar;
    final Context context = this;
    int aux = 0;
    String personaje, stats, ruta = "pjusuario.txt", weaponPath = "weapons.txt";
    Guerrero guerrero = new Guerrero();
    Cazador cazador = new Cazador();
    Mago mago = new Mago();
    Util util = new Util(this);
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.seleccionpersonaje);
        inicializarInstancias();
    }

    public void inicializarInstancias() {
        ivCaracter = (ImageView) findViewById(R.id.imagenCaracter);
        ivEstadisticas = (ImageView) findViewById(R.id.estadisticas);
        tvEstadisticas = (TextView) findViewById(R.id.statsText);
        ibGuerrero = (ImageButton) findViewById(R.id.imagenGuerrero);
        ibMago = (ImageButton) findViewById(R.id.imagenMago);
        ibCazador = (ImageButton) findViewById(R.id.imagenCazador);
        ibContinuar = (ImageButton) findViewById(R.id.botonContinuar);
        ibAtras = (ImageButton) findViewById(R.id.botonAtras);
        util.rellenarImageView(ivCaracter, 50, 100, true, true);
        util.alinearTablon(ivEstadisticas, tvEstadisticas, (util.getAlto()*30)/100, (util.getAncho()/2));
        util.rellenarImageButton(ibGuerrero, 5, 100, true);
        util.rellenarImageButton(ibCazador, 5, 100, true);
        util.rellenarImageButton(ibMago, 5, 100, true);
        util.rellenarImageButton(ibContinuar, 95, 100, true);
        util.rellenarImageButton(ibAtras, 95, 100, true);
        createButtons();
    }
    public void showCharInfo(int personaje, double hp, double mana, double ad, double ap, double armor, double mr, double as, double crit) {
        ivEstadisticas.setVisibility(View.VISIBLE);
        ivCaracter.setImageResource(personaje);
        stats = ("HP: ") + (hp)
                + "\nManá: " + (mana)
                + ("\nDaño: ") + (ad)
                + "\nDaño mágico: " + (ap)
                + ("\nArmadura: ") + (armor)
                + ("\nResistencia mágica: ") + (mr)
                + ("\nVelocidad de ataque: ") + (as)
                + ("\nProb. crítico: ") + (crit);

        tvEstadisticas.setText(stats);
    }
    public void createButtons() {
        ibGuerrero.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View view) {
                showCharInfo(R.drawable.warrior, guerrero.getHp(), 0, guerrero.getAd(), 0, guerrero.getArmor(), guerrero.getMr(), guerrero.getAs(), guerrero.getCrit());
                personaje = "Guerrero";
                aux = 1;
            }
        });
        ibCazador.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View view) {
                showCharInfo(R.drawable.cazador, cazador.getHp(), cazador.getMana(), cazador.getAd(), 0, cazador.getArmor(), cazador.getMr(), cazador.getAs(), cazador.getCrit());
                personaje = "Cazador";
                aux = 2;
            }
        });
        ibMago.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View view) {
                showCharInfo(R.drawable.mago, mago.getHp(), mago.getMana(), mago.getAd(), mago.getAp(), mago.getArmor(), mago.getMr(), mago.getAs(), mago.getCrit());
                personaje = "Mago";
                aux = 3;
            }
        });
        ibContinuar.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View view) {
                if (aux == 0) {
                    Toast.makeText(seleccionpersonaje.this, "Debes escoger un campeón primero", Toast.LENGTH_SHORT).show();
                } else {
                    util.cambiarRuta(ruta);
                    AlertDialog.Builder ad = util.buildAD(context, "Tutorial", "¿Quieres ir al tutorial?");
                    ad.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface di, int d) {
                            Intent pos = new Intent(seleccionpersonaje.this, Tutorial.class);
                            startActivity(pos);
                            finish();
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface di, int d) {
                            Intent neg = new Intent(seleccionpersonaje.this, seleccionmundo.class);
                            startActivity(neg);
                            finish();
                        }
                    });
                    util.cambiarRuta(weaponPath);
                    String pj = "";
                    String weapons = "";
                    switch (aux) {
                        case 1:
                            pj = ("Guerrero|") + (Guerrero.getHp()) + ("|0|") + (Guerrero.getAd()) + ("|0|") + (Guerrero.getArmor()) + ("|") + (Guerrero.getMr()) + ("|") + (Guerrero.getAs()) + ("|") + (Guerrero.getCrit()) + ("|1|0|");
                            weapons = "Espada pequeña|10|0|3|0|2|2|0|0|3|";
                            break;
                        case 2:
                            pj = ("Cazador|") + (Cazador.getHp()) + ("|") + (Cazador.getMana()) + ("|") + (Cazador.getAd()) + ("|0|") + (Cazador.getArmor()) + ("|") + (Cazador.getMr()) + ("|") + (Cazador.getAs()) + ("|") + (Cazador.getCrit()) + ("|1|0|");
                            break;
                        case 3:
                            pj = ("Mago|") + (Mago.getHp()) + ("|") + (Mago.getMana()) + ("|") + (Mago.getAd()) + ("|") + (Mago.getAp()) + ("|") + (Cazador.getArmor()) + ("|") + (Cazador.getMr()) + ("|") + (Cazador.getAs()) + ("|") + (Cazador.getCrit()) + ("|1|0|");
                            break;
                    }
                    util.createFile(pj);
                    if (!weaponService.checkFile())
                        weaponService.createFile(weapons);
                    ad.create();
                    ad.show();
                }
            }
        });
        atras.setOnClickListener(new View.OnClickListener() {
                                     public void onClick(View view) {
                                         Intent i = new Intent(SeleccionChar.this, MainActivity.class);
                                         startActivity(i);
                                         finish();
                                     }
                                 }

        );
    }
}
