package com.nodomain.petajuegos.heroessimulator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.nodomain.petajuegos.heroessimulator.Util.Util;

public class menuprincipal extends Activity {
    private ImageButton ibJugar, ibInventario, ibAcerca, ibSalir;
    private Util util;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);
        inicializarInstancias();
        ibJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class clase = seleccionpersonaje.class;
                if (util.getRuta())
                    clase = seleccionmundo.class;
                Intent i = new Intent(menuprincipal.this, clase);
            }
        });
        ibAcerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(menuprincipal.this, contacta.class);
                startActivity(i);
                finish();
            }
        });
        ibSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void inicializarInstancias() {
        util = new Util(this);
        ibJugar =  (ImageButton)findViewById(R.id.xmlibJugar);
        ibInventario = (ImageButton)findViewById(R.id.xmlibInventario);
        ibAcerca = (ImageButton)findViewById(R.id.xmlibAcerca);
        ibSalir = (ImageButton)findViewById(R.id.xmlibSalir);
        util.rellenarBoton(ibJugar, 2, 7, true);
        util.rellenarBoton(ibInventario, 3, 7, true);
        util.rellenarBoton(ibAcerca, 4, 7, true);
        util.rellenarBoton(ibSalir, 5, 7, true);
        ibJugar.setBackgroundResource(R.drawable.botonjugar);
        ibInventario.setBackgroundResource(R.drawable.botoninventario);
        ibAcerca.setBackgroundResource(R.drawable.botonacerca);
        ibSalir.setBackgroundResource(R.drawable.botonsalir);
    }
}
