package com.nodomain.petajuegos.heroessimulator;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nodomain.petajuegos.heroessimulator.Clases.Cazador;
import com.nodomain.petajuegos.heroessimulator.Clases.Guerrero;
import com.nodomain.petajuegos.heroessimulator.Clases.Mago;
import com.nodomain.petajuegos.heroessimulator.Clases.Guerrero;
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
    Util util;
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.seleccionpersonaje);
        inicializarInstancias();
    }

    public void inicializarInstancias() {
        util = new Util(this);
        ivCaracter = (ImageView) findViewById(R.id.imagenCaracter);
        ivEstadisticas = (ImageView) findViewById(R.id.estadisticas);
        tvEstadisticas = (TextView) findViewById(R.id.statsText);
        ibGuerrero = (ImageButton) findViewById(R.id.imagenGuerrero);
        ibMago = (ImageButton) findViewById(R.id.imagenMago);
        ibCazador = (ImageButton) findViewById(R.id.imagenCazador);
        ibContinuar = (ImageButton) findViewById(R.id.botonContinuar);
        ibAtras = (ImageButton) findViewById(R.id.botonAtras);
        util.rellenarImageView(ivCaracter, 50);
        util.alinearTablon(ivEstadisticas, tvEstadisticas, (util.getAlto()*30)/100, (util.getAncho()/2));
        util.rellenarImageButton(ibGuerrero, 1, 20, 20, true, 5, 5);
        util.rellenarImageButton(ibCazador, 2, 20, 20, true, 5, 5);
        util.rellenarImageButton(ibMago, 3, 20, 20, true, 5, 5);
        util.rellenarImageButton(ibContinuar, 1, 20, 40, true, 5, 90);
        util.rellenarImageButton(ibAtras, 2, 20, 40, true, 5, 90);
        ibGuerrero.setBackgroundResource(R.drawable.habilidad1g);
        ibCazador.setBackgroundResource(R.drawable.habilidad1c);
        ibMago.setBackgroundResource(R.drawable.habilidad1m);
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
                   /* String weapons = "";*/
                    double [] stats = new double[9];
                    switch (aux) {
                        case 1:
                            pj = "Guerrero";
                            stats [0] = Guerrero.getHp();
                            stats [1] = 0;
                            stats [2] = Guerrero.getAd();
                            stats [3] = 0;
                            stats [4] = Guerrero.getArmor();
                            stats [5] = Guerrero.getMr();
                            stats [6] = Guerrero.getAs();
                            stats [7] = Guerrero.getCrit();
                            stats [8] = 0;
                            stats [9] = 1;
                            /*weapons = "Espada pequeña|10|0|3|0|2|2|0|0|3|";*/
                            break;
                        case 2:
                            pj = "Cazador";
                            stats [0] = Cazador.getHp();
                            stats [1] = Cazador.getMana();
                            stats [2] = Cazador.getAd();
                            stats [3] = 0;
                            stats [4] = Cazador.getArmor();
                            stats [5] = Cazador.getMr();
                            stats [6] = Cazador.getAs();
                            stats [7] = Cazador.getCrit();
                            stats [8] = 0;
                            stats [9] = 1;
                            break;
                        case 3:
                            pj = "Mago";
                            stats [0] = Mago.getHp();
                            stats [1] = Mago.getMana();
                            stats [2] = Mago.getAd();
                            stats [3] = Mago.getAp();
                            stats [4] = Mago.getArmor();
                            stats [5] = Mago.getMr();
                            stats [6] = Mago.getAs();
                            stats [7] = Mago.getCrit();
                            stats [8] = 0;
                            stats [9] = 1;
                            break;
                    }
                    util.createFile(pj, stats);
                  //  util.createFile(weapons);
                    ad.create();
                    ad.show();
                }
            }
        });
        ibAtras.setOnClickListener(new View.OnClickListener() {
                                     public void onClick(View view) {
                                         Intent i = new Intent(seleccionpersonaje.this, MenuPrincipal.class);
                                         startActivity(i);
                                         finish();
                                     }
                                 }

        );
    }
}
