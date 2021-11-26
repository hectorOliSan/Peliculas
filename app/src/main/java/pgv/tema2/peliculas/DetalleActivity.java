package pgv.tema2.peliculas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalleActivity extends AppCompatActivity {
    private Button btnCreditos;
    private ImageView iv;
    private TextView tvTitulo, tvSinopsis;
    private String titulo, imagen, sinopsis, id;

    public static final String MOVIE_BASE_URL="https://image.tmdb.org/t/p/w185";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnCreditos = (Button) findViewById(R.id.btnCreditos);
        iv = (ImageView) findViewById(R.id.ivPortada);
        tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        tvSinopsis = (TextView) findViewById(R.id.tvSinopsis);


        // Leer el parametro de la pelicula.
        Intent intent = getIntent();
        this.id = intent.getStringExtra("id");
        this.titulo =  intent.getStringExtra("titulo");
        this.imagen =  intent.getStringExtra("imagen");
        this.sinopsis =  intent.getStringExtra("sinopsis");
        this.id = intent.getStringExtra("id");

        //Log.d("test", "Creditos: Leyendo id:" + id);
        //Log.d("test", "Creditos: Leyendo titulo:" + titulo);

        setTitle(titulo);

        Picasso.get().load(MOVIE_BASE_URL + imagen).into(iv);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);

        tvTitulo.setText(titulo);
        tvSinopsis.setText(sinopsis);

        btnCreditos.setOnClickListener( e -> {
            Intent i = new Intent(getApplicationContext(), CreditosActivity.class);
            i.putExtra("id", id);
            i.putExtra("titulo", titulo);
            startActivity(i);
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}