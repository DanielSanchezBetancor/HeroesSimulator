package com.nodomain.petajuegos.heroessimulator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.nodomain.petajuegos.heroessimulator.Util.Util;

public class contacta extends Activity {
    ImageView ivTablon, ivFlechaArriba, ivFlechaAbajo;
    ImageButton salir;
    Util util;
    TextView textoAcerca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacta);
        inicializarInstancias();
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(contacta.this, MenuPrincipal.class);
                startActivity(i);
                finish();
            }
        });
    }
    private void inicializarInstancias() {
        util = new Util(this);
        ivTablon = (ImageView)findViewById(R.id.xmlivTablon);
        ivFlechaArriba = (ImageView)findViewById(R.id.xmlivFlechaArriba);
        ivFlechaAbajo = (ImageView)findViewById(R.id.xmlivFlechaAbajo);
        salir = (ImageButton)findViewById(R.id.xmlibSalir);
        textoAcerca = (TextView)findViewById(R.id.xmltvAcerca);
        int alto = ((util.getAlto()*20)/100);
        util.alinearTablon(ivTablon, null, alto, 0);
        util.alinearTablon(null, textoAcerca, (alto*2), 35);
        util.rellenarImageButton(salir, 0, 7, false);
        util.rellenarImageView(ivFlechaArriba, 4, 10, true, true);
        util.rellenarImageView(ivFlechaAbajo, 8, 10, true, true);
        salir.setBackgroundResource(R.drawable.botonsalir);
        textoAcerca.setMovementMethod(new ScrollingMovementMethod());
        textoAcerca.setText("Bienvenidos al juego de Heroes Simulator. Este juego fue creado por el equipo de PetaJuegos, dando comienzo al proyecto el 19/09/2016. Esta es la versión alfa, por lo que aqui no habrá contenido ninguno actualmente. ¡Vuelve para saber los cambios tras cada actualización!");
    }
}
