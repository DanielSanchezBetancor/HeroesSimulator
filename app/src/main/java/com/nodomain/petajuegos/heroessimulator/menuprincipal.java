package com.nodomain.petajuegos.heroessimulator;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.nodomain.petajuegos.heroessimulator.Util.Util;

public class MenuPrincipal extends Activity {
    private ImageView fondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);
        fondo.setImageResource(R.drawable.fondopantallamenuprincipal);
        new CountDownTimer(10000, 1000) {
            public void onTick(long l) {
                fondo.setAlpha(0 + (l/1000));
                Log.e("MenuPrincipal", "Contador: " + (0 + (l/1000)));
            }
            public void onFinish() {
                fondo.setAlpha(1);
                Intent i = new Intent(MenuPrincipal.this, Menu.class);
                startActivity(i);
            }
        }.start();
    }
}
