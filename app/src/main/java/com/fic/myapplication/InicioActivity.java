package com.fic.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class InicioActivity extends AppCompatActivity {

    private ImageView carruselImagen;
    private int[] imagenes = {
            R.drawable.roma,
            R.drawable.torrepisa,
            R.drawable.grecia,
            R.drawable.brasil,
            R.drawable.tokyo,
            R.drawable.paris
    };
    private int indiceActual = 0;
    private Handler handler = new Handler();
    private Runnable cambiarImagenRunnable;

    private AutoCompleteTextView origenInput, destinoInput;
    private ImageButton botonBuscar, homeButton, misViajesButton, reservarButton, subastaButton, perfilButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        carruselImagen = findViewById(R.id.carruselImagen);
        origenInput = findViewById(R.id.origenInput);
        destinoInput = findViewById(R.id.destinoInput);
        botonBuscar = findViewById(R.id.botonBuscar);
        homeButton = findViewById(R.id.homeButton);
        misViajesButton = findViewById(R.id.misViajesButton);
        reservarButton = findViewById(R.id.reservarButton);
        subastaButton = findViewById(R.id.subastaButton);
        perfilButton = findViewById(R.id.perfilButton);

        iniciarCarrusel();

        configurarNavegacion();
    }

    private void iniciarCarrusel() {
        cambiarImagenRunnable = new Runnable() {
            @Override
            public void run() {
                carruselImagen.setImageResource(imagenes[indiceActual]);
                indiceActual = (indiceActual + 1) % imagenes.length;
                handler.postDelayed(this, 5000); // Cambiar cada 5 segundos
            }
        };
        handler.post(cambiarImagenRunnable);
    }

    private void configurarNavegacion() {
        homeButton.setOnClickListener(v -> {
            // Ya estamos en InicioActivity
        });

        misViajesButton.setOnClickListener(v -> {
            startActivity(new Intent(InicioActivity.this, MisViajesActivity.class));
        });

        reservarButton.setOnClickListener(v -> {
            startActivity(new Intent(InicioActivity.this, ReservarActivity.class));
        });

        subastaButton.setOnClickListener(v -> {
            startActivity(new Intent(InicioActivity.this, SubastaActivity.class));
        });

        perfilButton.setOnClickListener(v -> {
            startActivity(new Intent(InicioActivity.this, PerfilActivity.class));
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(cambiarImagenRunnable); // Para evitar memory leaks
    }
}
