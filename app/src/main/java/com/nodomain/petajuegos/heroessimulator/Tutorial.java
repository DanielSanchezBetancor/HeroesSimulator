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
import com.nodomain.petajuegos.heroessimulator.Util.Util;
public class Tutorial extends Activity {
    String aux;
    ImageButton enemigo, habilidad, potivida, continuar;
    TextView texto, infopj, infoEnemigo;
    ImageView personaje, zonaTexto;
    Util util;
    int altoBotonAnterior;
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tutorial);
        util = new Util(this);
        texto = (TextView) findViewById(R.id.texto);
        continuar = (ImageButton) findViewById(R.id.botonContinuar);
        zonaTexto = (ImageView)findViewById(R.id.zonaTexto);
        util.rellenarImageView(zonaTexto, 1, 100, 20, false, 0, 75, 0);
        util.rellenarImageButton(continuar, 1, 30, 10, false, 70, 90, 0);
        final AlphaAnimation in = new AlphaAnimation(0.0F, 1.0F);
        in.setDuration(5000L);
        texto.setText("¡Bienvenido a FightSimulator! La finalidad de este juego es hacerte lo mas fuerte posible a través de mundos, con diferentes enemigos, armas, habilidades ... Ahora te enseñaremos lo necesario acerca del juego.");
        texto.startAnimation(in);
        continuar.startAnimation(in);
        continuar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                texto.setText("");
                personaje = (ImageView) findViewById(R.id.ivPersonaje);
                altoBotonAnterior = util.rellenarImageView(personaje, 1, 30, 35, false, 10, 5, 0);
                personaje.setImageResource(R.drawable.warrior);
                personaje.startAnimation(in);
                infopj = (TextView) findViewById(R.id.tvInfoPJ);
                infopj.setText("HP: 100/100\nEXP: 0/100\nNivel: 1");
                infopj.startAnimation(in);
                texto.setText("Este es tu personaje. No puedes tapear en él. Debajo puedes contemplar la vida que tiene, lo siguiente es la experiencia que tienes y la máxima antes de poder subir de nivel, y por último el nivel que tiene el personaje.");
                texto.startAnimation(in);
                continuar.startAnimation(in);
                continuar.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        enemigo = (ImageButton) findViewById(R.id.ibEnemigo);
                        util.rellenarImageButton(enemigo, 2, 30, 35, true, 20, 5, altoBotonAnterior);
//                        enemigo.setBackgroundResource(R.drawable.);
                        texto.setText("Este es tu enemigo. En él, encontramos la vida que tiene. \n¡¡Tapea en él para hacerle daño!!");
                        texto.startAnimation(in);
                        continuar.setClickable(false);
                        enemigo.startAnimation(in);
                        aux = "HP: 100/100";
                        infoEnemigo = (TextView) findViewById(R.id.tvInfoEnemigo);
                        infoEnemigo.setText(aux);
                        infoEnemigo.startAnimation(in);
                        enemigo.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                infoEnemigo.clearComposingText();
                                infoEnemigo.setText("HP: 80/100\nDaño: 20");
                                enemigo.setClickable(false);
                                texto.setText("Este es tu enemigo. En él, encontramos la vida que tiene.\nAcabas de aprender como atacar a tu enemigo. Enhorabuena.");
                                continuar.setClickable(true);
                                continuar.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View view) {
                                        infopj.clearComposingText();
                                        infopj.setText("HP: 80/100\nEXP: 0/100\nNivel: 1\nDaño: 20");
                                        texto.setText("¡El enemigo te acaba de atacar! Utiliza una poción para curarte (Click en 'Continuar')");
                                        texto.startAnimation(in);
                                        continuar.startAnimation(in);
                                        continuar.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View view) {
                                                texto.setText("");
                                                potivida = (ImageButton) findViewById(R.id.ibPocionVida);
                                                potivida.setBackgroundResource(R.drawable.potivida);
                                                util.rellenarImageButton(potivida, 1, 20, 20, true, 5, 80, 0);
                                                continuar.setClickable(false);
                                                potivida.setOnClickListener(new View.OnClickListener() {
                                                    public void onClick(View view) {
                                                        potivida.setClickable(false);
                                                        zonaTexto = (ImageView)findViewById(R.id.zonaTexto);
                                                        util.rellenarImageView(zonaTexto, 2, 70, 20, true, 5, 80, 0);
                                                        infopj.setText("HP: 100/100\nEXP: 0/100\nNivel: 1\nTe has curado: 20\nFuente: Poción de vida");
                                                        texto.setText("Bien hecho, has repuesto tus fuerzas y estas listo para la última lección.");
                                                        texto.setAnimation(in);
                                                        continuar.setAnimation(in);
                                                        continuar.setClickable(true);
                                                        continuar.setOnClickListener(new View.OnClickListener() {
                                                            public void onClick(View view) {
                                                                texto.setText("Acaba con la vida de tu enemigo, clickando en la habilidad que has desbloqueado.");
                                                                continuar.setClickable(false);
                                                                texto.setAnimation(in);
                                                                continuar.setAnimation(in);
                                                                habilidad = (ImageButton) findViewById(R.id.ibHabilidad);
                                                                util.rellenarImageButton(habilidad, 1, 15, 15, false, 10, 45, 0);
                                                                habilidad.setBackgroundResource(R.drawable.habilidad1g);
                                                                habilidad.setOnClickListener(new View.OnClickListener() {
                                                                    public void onClick(View view) {
                                                                        habilidad.setClickable(false);
                                                                        infoEnemigo.setText("Muerto.\nEXP: 33");
                                                                        infopj.setText("HP: 100/100\nEXP: 33/100\nNivel: 1");
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
                                                                                        Intent i = new Intent(Tutorial.this, seleccionmundo.class);
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
