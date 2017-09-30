package br.usjt.ftce.desmob.campeonato;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Bruno Macena da Silva 201512094
 */

public class MainActivity extends Activity {
    EditText textNome;
    ArrayList<Campeonato> lista;
    CampeonatoRequester requester;
    Intent intent;
    String chave;
    Context contexto;

    public static final String SERVIDOR = "http://192.168.43.248:8080";
    public static final String APLICACAO = "/poetas";
    public static final String RECURSO = "/campeonato";
    public static final String LISTA = "br.usjt.ftce.desmob.clientev1.lista";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contexto = this;
        textNome = (EditText) findViewById(R.id.buscar_clientes);
    }

    public void buscarCampeonato(View view) {
        intent = new Intent(this, ListarCampeonatoActivity.class);
        chave = textNome.getText().toString();
        requester = new CampeonatoRequester();
        if (requester.isConnected(this)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        lista = requester.get(SERVIDOR + APLICACAO + RECURSO, chave);
                        CampeonatoDb banco = new CampeonatoDb(contexto);
                        banco.insereCampeonato(lista);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Lista: " + lista);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            intent.putExtra(LISTA, lista);
                            startActivity(intent);
                        }
                    });

                }
            }).start();

        } else {
            Toast toast = Toast.makeText(this,
                    "Rede indisponível. Carregando campeonatos armazenados localmente.",
                    Toast.LENGTH_LONG);
            toast.show();
            new CarregaCampeonatoDoBanco().execute(CampeonatoDb.CLIENTE);

        }



    }
    private class CarregaClientesDoBanco extends AsyncTask<String, Void, ArrayList<Campeonato>> {

        @Override
        protected ArrayList<Campeonato> doInBackground(String... strings) {

            CampeonatoDb banco = new CampeonatoDb(contexto);

            ArrayList<Campeonato> campeonatos = banco.selecionaCampeonato();
            return campeonatos;
        }

        public void onPostExecute(ArrayList<Campeonato> result) {
            intent.putExtra(LISTA, result);
            startActivity(intent);
        }
    }
}
