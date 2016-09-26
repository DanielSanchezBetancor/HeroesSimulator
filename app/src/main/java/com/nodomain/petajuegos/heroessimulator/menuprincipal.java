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
        rellenarBoton(ibJugar, 2);
        rellenarBoton(ibInventario, 3);
        rellenarBoton(ibAcerca, 4);
        rellenarBoton(ibSalir, 5);
        ibJugar.setBackgroundResource(R.drawable.botonjugar);
        ibInventario.setBackgroundResource(R.drawable.botoninventario);
        ibAcerca.setBackgroundResource(R.drawable.botonacerca);
        ibSalir.setBackgroundResource(R.drawable.botonsalir);
    }
    private void rellenarBoton(ImageButton boton, int posicion) {
        android.view.ViewGroup.LayoutParams params = boton.getLayoutParams();
        int tamañoFila = ((util.getAlto()/7));
        params.height = (tamañoFila) - ((tamañoFila*10)/100);
        params.width = util.getAncho()/2;
        boton.setLayoutParams(params);
        boton.setY(tamañoFila*posicion);
        Log.e("Tamaño", " " + (tamañoFila*posicion));
    }
}
