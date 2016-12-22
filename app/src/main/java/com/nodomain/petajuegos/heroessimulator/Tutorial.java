package com.nodomain.petajuegos.heroessimulator;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
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
    final AlphaAnimation in = new AlphaAnimation(0.0F, 1.0F);
    final AlphaAnimation out = new AlphaAnimation(1.0F, 0.0F);
    int altoBotonAnterior;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tutorial);
        inicializarComponentes();
        primeraEscena();

    }

    private void inicializarComponentes() {
        //Elementos visibles
        texto = (TextView) findViewById(R.id.texto);
        continuar = (ImageButton) findViewById(R.id.botonContinuar);
        zonaTexto = (ImageView) findViewById(R.id.zonaTexto);
        personaje = (ImageView) findViewById(R.id.ivPersonaje);
        infopj = (TextView) findViewById(R.id.tvInfoPJ);
        enemigo = (ImageButton) findViewById(R.id.ibEnemigo);
        infoEnemigo = (TextView) findViewById(R.id.tvInfoEnemigo);
        potivida = (ImageButton) findViewById(R.id.ibPocionVida);
        habilidad = (ImageButton) findViewById(R.id.ibHabilidad);

        //Rellenando los elementos
        continuar.setImageResource(R.drawable.botonjugar);
        personaje.setImageResource(R.drawable.warrior);
        enemigo.setBackgroundResource(R.drawable.cazador);
        potivida.setBackgroundResource(R.drawable.potivida);
        habilidad.setBackgroundResource(R.drawable.habilidad1g);

        //Exportar
        util = new Util(this);

        //Variables de la clase
        in.setDuration(5000L);
        out.setDuration(5000L);
        personaje.setVisibility(View.INVISIBLE);
        enemigo.setVisibility(View.INVISIBLE);
        potivida.setVisibility(View.INVISIBLE);
        habilidad.setVisibility(View.INVISIBLE);
    }

    /*Primera escena
    Se muestra un texto y un boton de continuar (Inicio del juego)
     */
    private void primeraEscena() {
        util.rellenarImageView(zonaTexto, 1, 100, 20, false, 0, 70, 0);
        util.rellenarImageButton(continuar, 1, 30, 10, false, 70, 90, 0);
        texto.setText("¡Bienvenido a FightSimulator! La finalidad de este juego es hacerte lo mas fuerte posible a través de mundos, con diferentes enemigos, armas, habilidades ... Ahora te enseñaremos lo necesario acerca del juego.");
        texto.startAnimation(in);
        continuar.startAnimation(in);
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.startAnimation(out);
                continuar.startAnimation(out);
                segundaEscena();
            }
        });

    }

    /*Segunda escena
    Se muestra al usuario su personaje, con su vida y su experiencia. Se cambia el texto.
     */
    private void segundaEscena() {
        personaje.setVisibility(View.VISIBLE);
        texto.clearComposingText();
        altoBotonAnterior = util.rellenarImageView(personaje, 1, 20, 30, false, 10, 10, 0);
        infopj.setText("HP: 100/100\nEXP: 0/100\nNivel: 1");
        texto.setText("Este es tu personaje. No puedes tapear en él. Debajo puedes contemplar la vida que tiene, lo siguiente es la experiencia que tienes y la máxima antes de poder subir de nivel, y por último el nivel que tiene el personaje.");
        texto.startAnimation(in);
        infopj.startAnimation(in);
        continuar.startAnimation(in);
        personaje.startAnimation(in);
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.startAnimation(out);
                continuar.startAnimation(out);
                personaje.startAnimation(out);
                terceraEscena();
            }
        });
    }

    /*Tercera escena
    Mostramos al usuario al enemigo, cambio de textos, no puede clickar en continuar, nuevo texto del enemigo
    Una vez tapeado, el enemigo se vuelve intapeable y continuar se activa
     */
    private void terceraEscena() {
        enemigo.setVisibility(View.VISIBLE);
        continuar.setClickable(false);
        texto.startAnimation(in);
        infopj.startAnimation(in);
        continuar.startAnimation(in);
        personaje.startAnimation(in);
        enemigo.startAnimation(in);
        infoEnemigo.startAnimation(in);
        util.rellenarImageButton(enemigo, 2, 20, 30, true, 20, 10, altoBotonAnterior);
        texto.setText("Este es tu enemigo. En él, encontramos la vida que tiene. \n¡¡Tapea en él para hacerle daño!!");
        infoEnemigo.setText("HP: 100/100");
        infoEnemigo.startAnimation(in);
        enemigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoEnemigo.clearComposingText();
                infoEnemigo.setText("HP: 80/100\nDaño: 20");
                enemigo.setClickable(false);
                continuar.setClickable(true);
                texto.setText("¡Bien hecho! Has inflingido daño al enemigo y le has quitado parte de la vida, aunque sigue siendo demasiado.");
                continuar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        texto.startAnimation(out);
                        infopj.startAnimation(out);
                        continuar.startAnimation(out);
                        personaje.startAnimation(out);
                        enemigo.startAnimation(out);
                        infoEnemigo.startAnimation(out);
                        cuartaEscena();
                    }
                });
            }
        });
    }

    /*Cuarta escena
    El enemigo te hace daño, cambio de textos
     */
    private void cuartaEscena() {
        infopj.setText("HP: 80/100\nEXP: 0/100\nNivel: 1\nDaño: 20");
        texto.setText("¡El enemigo te acaba de atacar! Utiliza una poción para curarte (Tapea en 'Continuar')");
        texto.startAnimation(in);
        continuar.startAnimation(in);
        continuar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                potivida.setVisibility(View.VISIBLE);
                util.rellenarImageButton(potivida, 1, 20, 20, true, 5, 80, 0);
                continuar.setClickable(false);
                potivida.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        potivida.setClickable(false);
                        util.rellenarImageView(zonaTexto, 2, 70, 20, true, 5, 80, 0);
                        zonaTexto.refreshDrawableState();
                        infopj.setText("HP: 100/100\nEXP: 0/100\nNivel: 1\nTe has curado: 20\nFuente: Poción de vida");
                        texto.setText("Bien hecho, has repuesto tus fuerzas y estas listo para la última lección.");

                        continuar.setClickable(true);
                        continuar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                texto.setAnimation(out);
                                continuar.setAnimation(out);
                                quintaEscena();
                            }
                        });
                    }
                });
            }
        });
    }

    /*Quinta escena
        Mostramos la habilidad al usuario, cambio textos, enemigo y continuar intapeables
        Usa la pocion y se desactiva, se activa continuar, mostramos la recompensa y fin
     */
    private void quintaEscena() {
        continuar.setClickable(false);
        util.rellenarImageButton(habilidad, 1, 15, 15, false, 10, 45, 0);
        habilidad.setVisibility(View.VISIBLE);
        texto.setAnimation(in);
        continuar.setAnimation(in);
        texto.setText("Acaba con la vida de tu enemigo, clickando en la habilidad que has desbloqueado.");
        habilidad.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                habilidad.setClickable(false);
                infoEnemigo.setText("Muerto.\nEXP: 33");
                infopj.setText("HP: 100/100\nEXP: 33/100\nNivel: 1");
                Toast.makeText(Tutorial.this, "¡Has ganado: 2 pociones de vida!", Toast.LENGTH_SHORT).show();
                texto.setText("¡Bien hecho! Has matado a tu primer enemigo y has conseguido algo de experiencia y un par de pociones. Sigue asi y subirás de nivel, desbloqueando mejores habilidades y volviendote más fuerte, pues según avances, los enemigos serán más poderosos y vendrán bestias especiales.");
                texto.startAnimation(out);
                continuar.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        texto.startAnimation(in);
                        texto.setText("Existen un tipo especial de pociones para usar las habilidades, llamado maná, con la misma funcionalidad que la poción de vida. Cada mundo es distinto, escoge sabiamente contra quien pelear y si te atascas, cambia de mundo. ¡Suerte en tu aventura!");
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
}
