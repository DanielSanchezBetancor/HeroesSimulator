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
        int altoBotonAnterior = util.rellenarImageView(titulo, 1, 80, 20, true, 10, 5, 0);
        util.rellenarImageButton(mundouno, 1, 40, 20, false, 5, 5, altoBotonAnterior);
        altoBotonAnterior = util.rellenarImageButton(mundodos, 2, 40, 20, false, 10, 5, altoBotonAnterior);
        util.rellenarImageButton(mundotres, 1, 40, 20, false, 5, 5, altoBotonAnterior);
        util.rellenarImageButton(mundocuatro, 2, 40, 20, false, 10, 5, altoBotonAnterior);
        util.rellenarImageButton(atras, 1, 50, 20, false, 10, 5, altoBotonAnterior);
        util.rellenarImageButton(continuar, 2, 40, 20, false, 5, 5, altoBotonAnterior);
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
        mundouno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mundoEscogido == 0) {
                    Toast.makeText(seleccionmundo.this, "Selecciona un mundo primero", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(seleccionmundo.this, juego.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}
