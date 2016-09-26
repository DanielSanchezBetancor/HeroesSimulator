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
import android.widget.Toast;

import com.nodomain.petajuegos.heroessimulator.Util.Util;

public class contacta extends Activity {
    ImageView tablon;
    ImageButton salir;
    Util util;
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
        tablon = (ImageView)findViewById(R.id.xmlimgtablon);
        int alto = ((util.getAlto()*20)/100);
        Toast.makeText(this, " " + alto, Toast.LENGTH_SHORT).show();
        ViewGroup.MarginLayoutParams mlp = new ViewGroup.MarginLayoutParams(tablon.getLayoutParams());
        mlp.setMargins(0, alto, 0, 0);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(mlp);
        tablon.setLayoutParams(lp);
        salir = (ImageButton)findViewById(R.id.xmlibSalir);
        util.rellenarBoton(salir, 0, 7, false);
    }
}
