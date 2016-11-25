package com.nodomain.petajuegos.heroessimulator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Tutorial extends Activity {
    String aux;
    Button continuar;
    ImageButton enemigo, habilidad, potivida;
    TextView texto, vida, vidaEnemigo;
    ImageView personaje;
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tutorial);
        texto = (TextView) findViewById(R.id.texto);
        vida = (TextView) findViewById(R.id.vida);
        vidaEnemigo = (TextView) findViewById(R.id.vidaEnemigo);
        enemigo = (ImageButton) findViewById(R.id.Enemigo);
        enemigo.setVisibility(View.INVISIBLE);
        enemigo.setImageResource(R.drawable.guerrero);
        potivida = (ImageButton) findViewById(R.id.potivida);
        potivida.setVisibility(View.INVISIBLE);
        potivida.setBackgroundResource(R.drawable.potivida);
        habilidad = (ImageButton) findViewById(R.id.habilidad);
        habilidad.setVisibility(View.INVISIBLE);
        habilidad.setImageResource(R.drawable.habilidad1c);
        continuar = (Button) findViewById(R.id.continuar);
        final AlphaAnimation in = new AlphaAnimation(0.0F, 1.0F);
        in.setDuration(5000L);
        texto.setText("¡Bienvenido a FightSimulator! La finalidad de este juego es hacerte lo mas fuerte posible a través de mundos, con diferentes enemigos, armas, habilidades ... Ahora te enseñaremos lo necesario acerca del juego.");
        texto.startAnimation(in);
        continuar.startAnimation(in);
        continuar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                texto.setText("");
                personaje = (ImageView) findViewById(R.id.imagenPersonaje);
                personaje.setImageResource(R.drawable.cazador);
                personaje.startAnimation(in);
                vida.setText("HP: 100/100\nEXP: 0/100\nNivel: 1");
                vida.startAnimation(in);
                texto.setText("Este es tu personaje. No puedes tapear en él. Debajo puedes contemplar la vida que tiene, lo siguiente es la experiencia que tienes y la máxima antes de poder subir de nivel, y por último el nivel que tiene el personaje.");
                texto.startAnimation(in);
                continuar.startAnimation(in);
                continuar.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        enemigo.setVisibility(View.VISIBLE);
                        texto.setText("Este es tu enemigo. En él, encontramos la vida que tiene, aprieta en el para hacerle daño!!");
                        texto.startAnimation(in);
                        continuar.setClickable(false);
                        enemigo.startAnimation(in);
                        aux = "HP: 100/100";
                        vidaEnemigo.setText(aux);
                        vidaEnemigo.startAnimation(in);
                        enemigo.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                vidaEnemigo.setText("HP: 80/100\nDaño: 20");
                                enemigo.setClickable(false);
                                texto.setText("Este es tu enemigo. En él, encontramos la vida que tiene.\nAcabas de aprender como atacar a tu enemigo. Enhorabuena.");
                                continuar.setClickable(true);
                                continuar.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View view) {
                                        vida.setText("HP: 80/100\nEXP: 0/100\nNivel: 1\nDaño: 20");
                                        texto.setText("¡El enemigo te acaba de atacar! Utiliza una poción para curarte (Click en 'Continuar')");
                                        texto.startAnimation(in);
                                        continuar.startAnimation(in);
                                        continuar.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View view) {
                                                texto.setText("");
                                                texto = (TextView) findViewById(R.id.texto2);
                                                potivida.setVisibility(View.VISIBLE);
                                                continuar.setClickable(false);
                                                potivida.setOnClickListener(new View.OnClickListener() {
                                                    public void onClick(View view) {
                                                        potivida.setClickable(false);
                                                        vida.setText("HP: 100/100\nEXP: 0/100\nNivel: 1\nTe has curado: 20\nFuente: Poción de vida");
                                                        texto.setText("Bien hecho, has repuesto tus fuerzas y estas listo para la última lección.");
                                                        texto.setAnimation(in);
                                                        continuar.setAnimation(in);
                                                        continuar.setClickable(true);
                                                        continuar.setOnClickListener(new View.OnClickListener() {
                                                            public void onClick(View view) {
                                                                texto.setText("Acaba con la vida de tu enemigo, clickando en la habilidad que has desbloqueado.");
                                                                habilidad.setVisibility(View.VISIBLE);
                                                                continuar.setClickable(false);
                                                                texto.setAnimation(in);
                                                                continuar.setAnimation(in);
                                                                habilidad.setOnClickListener(new View.OnClickListener() {
                                                                    public void onClick(View view) {
                                                                        habilidad.setClickable(false);
                                                                        vidaEnemigo.setText("Muerto.\nEXP: 33");
                                                                        vida.setText("HP: 100/100\nEXP: 33/100\nNivel: 1");
                                                                        Toast.makeText(Tutorial.this, "¡Has ganado: 2 pociones de vida!", Toast.LENGTH_SHORT).show();
                                                                        texto.setText("¡Bien hecho! Has matado a tu primer enemigo y has conseguido algo de experiencia y un par de pociones. Sigue asi y subirás de nivel, desbloqueando mejores habilidades y volviendote más fuerte, pues según avances, los enemigos serán más poderosos y vendrán bestias especiales.");
                                                                        texto.startAnimation(in);
                                                                        continuar.setOnClickListener(new View.OnClickListener() {
                                                                            public void onClick(View view) {
                                                                                texto.setText("Existen un tipo especial de pociones para usar las habilidades, llamado maná, con la misma funcionalidad que la poción de vida. Cada mundo es distinto, escoge sabiamente contra quien pelear y si te atascas, cambia de mundo. ¡Suerte en tu aventura!");
                                                                                texto.startAnimation(in);
                                                                                continuar.startAnimation(in);
                                                                                continuar.setClickable(true);
                                                                                continuar.setOnClickListener(new View.OnClickListener() {
                                                                                    public void onClick(View view) {
                                                                                        Intent i = new Intent(Tutorial.this, SeleccionMundo.class);
                                                                                        startActivity(i);
                                                                                        finish();
                                                                                    }
                                                                                });
                                                                            }
                                                                        });
                                                                    }
                                                                });
                                                            }
                                                        });
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
    }
}
