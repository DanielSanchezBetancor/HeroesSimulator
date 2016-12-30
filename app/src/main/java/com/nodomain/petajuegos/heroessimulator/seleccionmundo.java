package com.nodomain.petajuegos.heroessimulator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nodomain.petajuegos.heroessimulator.Util.Util;


public class seleccionmundo extends Activity {
    ImageView titulo;
    ImageButton mundouno, mundodos, mundotres, mundocuatro, atras, continuar;
    TextView textouno, textodos, textotres, textocuatro;
    Util util;
    int mundoEscogido = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seleccionmundo);
        inicializarComponentes();
        logicaBotones();
    }
    private void inicializarComponentes() {
        //Elementos visibles
        titulo = (ImageView)findViewById(R.id.ivTitulo);
        mundouno = (ImageButton)findViewById(R.id.ibMundoUno);
        mundodos = (ImageButton)findViewById(R.id.ibMundoDos);
        mundotres = (ImageButton)findViewById(R.id.ibMundoTres);
        mundocuatro = (ImageButton)findViewById(R.id.ibMundoCuatro);
        atras = (ImageButton)findViewById(R.id.ibAtras);
        continuar = (ImageButton)findViewById(R.id.ibContinuar);
        textouno = (TextView)findViewById(R.id.tvMundoUno);
        textodos = (TextView)findViewById(R.id.tvMundoDos);
        textotres = (TextView)findViewById(R.id.tvMundoTres);
        textocuatro = (TextView)findViewById(R.id.tvMundoCuatro);

        //Rellenar elementos
        titulo.setImageResource(R.drawable.escoge);
        mundouno.setImageResource(R.drawable.fondomundouno);
        mundodos.setImageResource(R.drawable.fondomundodos);
        mundotres.setImageResource(R.drawable.fondomundotres);
        mundocuatro.setImageResource(R.drawable.fondomundocuatro);
        atras.setImageResource(R.drawable.botonmenuprincipal);
        continuar.setImageResource(R.drawable.botonjugar);
        textouno.setText("Mundo 1");
        textodos.setText("Mundo 2");
        textotres.setText("Mundo 3");
        textocuatro.setText("Mundo 4");

        //Exportar
        util = new Util(this);

        //Ajustacion dinamica
        util.rellenarImageView(titulo, 1, 80, 20, false, 10, 5, 0);
        util.rellenarImageButton(mundouno, 1, 30, 20, false, 10, 30, 0);
        util.rellenarImageButton(mundodos, 2, 30, 20, true, 20, 30, 0);
        util.rellenarImageButton(mundotres, 1, 30, 20, false, 10, 60, 0);
        util.rellenarImageButton(mundocuatro, 2, 30, 20, true, 20, 60, 0);
        util.rellenarImageButton(atras, 1, 30, 10, false, 10, 90, 0);
        util.rellenarImageButton(continuar, 2, 30, 10, true, 20, 90, 0);
    }
    private void logicaBotones() {
        mundouno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mundoEscogido = 1;
            }
        });
        mundodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mundoEscogido = 2;
            }
        });
        mundotres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mundoEscogido = 3;
            }
        });
        mundocuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mundoEscogido = 4;
            }
        });
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(seleccionmundo.this, MenuPrincipal.class);
                startActivity(i);
                finish();
            }
        });
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mundoEscogido == 0) {
                    Toast.makeText(seleccionmundo.this, "Selecciona un mundo primero", Toast.LENGTH_SHORT).show();
                } else {
                    util.cambiarRuta("Mundo" + mundoEscogido);
                    if (!util.getRuta()) {
                        util.crearFicheroMundo(0, 0);
                    }
                    Intent i = new Intent(seleccionmundo.this, juego.class);
                    startActivity(i);
                    i.putExtra("Mundo", mundoEscogido);
                    finish();
                }
            }
        });
    }
}
