package com.nodomain.petajuegos.heroessimulator;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by AUTOESCUELA FENIX on 26/12/2016.
 */

public class juego extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego);
        inicializarComponentes();
    }
}
