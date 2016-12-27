package com.nodomain.petajuegos.heroessimulator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by AUTOESCUELA FENIX on 26/12/2016.
 */

public class juego extends Activity {
    ImageView ivPersonaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego);
        inicializarComponentes();
    }
    private void inicializarComponentes() {
        //Elementos visibles
        ivPersonaje = (ImageView)findViewById(R.id.ivPersonaje);

        //Rellenar elementos
        String selec = util.
        }
    }
}
