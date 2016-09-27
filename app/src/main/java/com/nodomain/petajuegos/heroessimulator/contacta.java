package com.nodomain.petajuegos.heroessimulator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nodomain.petajuegos.heroessimulator.Util.Util;

public class contacta extends Activity {
    ImageView tablon;
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
                Intent i = new Intent(contacta.this, menuprincipal.class);
                startActivity(i);
                finish();
            }
        });
    }
    private void inicializarInstancias() {
        util = new Util(this);
        tablon = (ImageView)findViewById(R.id.xmlivTablon);
        salir = (ImageButton)findViewById(R.id.xmlibSalir);
        textoAcerca = (TextView)findViewById(R.id.xmltvTextoAcerca);
        int alto = ((util.getAlto()*20)/100);
        util.alinearTablon(tablon, alto);
        util.rellenarBoton(salir, 0, 7, false);
        salir.setBackgroundResource(R.drawable.botonsalir);
        textoAcerca.setText("     Acerca\n  Bienvenidos al juego de Heroes Simulator. Este juego fue creado por el equipo de PetaJuegos, dando comienzo al proyecto el 19/09/2016. Esta es la versión alfa, por lo que aqui no habrá contenido ninguno actualmente. ¡Vuelve para saber los cambios tras cada actualización!");
    }
}
