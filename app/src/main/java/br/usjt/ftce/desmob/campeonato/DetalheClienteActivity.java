package br.usjt.ftce.desmob.campeonato;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class DetalheClienteActivity extends Activity {
    TextView textViewNome, textViewFone, textViewEmail;
    ImageView imagemCliente;
    CampeonatoRequester campeonatoRequester;
    Campeonato campeonato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_campeonato);
        textViewNome = (TextView) findViewById(R.id.txt_cliente_nome);
        textViewFone = (TextView) findViewById(R.id.txt_cliente_fone);
        textViewEmail = (TextView) findViewById(R.id.txt_cliente_email);
        imagemCliente = (ImageView) findViewById(R.id.cliente_image_view);
        Intent intent = getIntent();
        campeonato = (Campeonato)intent.getSerializableExtra(ListarCampeonatoActivity.CAMPEONATO);
        textViewNome.setText(campeonato.getVitorias());
        textViewEmail.setText(campeonato.getDerrotas());
        textViewFone.setText(campeonato.getEmpates());

        campeonatoRequester = new CampeonatoRequester();
        new DownloadImage().execute(MainActivity.SERVIDOR+
                MainActivity.APLICACAO+"/img/"+ campeonato.getImagem()+".jpg");

    }

    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                return campeonatoRequester.getImage(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        public void onPostExecute(Bitmap result){
            imagemCliente.setImageBitmap(result);
        }
    }
}

