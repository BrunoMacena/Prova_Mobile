package br.usjt.ftce.desmob.campeonato;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Bruno Macena da Silva 201512094
 */

public class ListarCampeonatoActivity extends Activity {
    ListView listView;
    Campeonato[] lista;
    public static final String CAMPEONATO = "br.usjt.ftce.desmob.clientev1.campeonato";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_campeonato);
        listView = (ListView) findViewById(R.id.lista_de_clientes);
        Intent intent = getIntent();
        ArrayList<Campeonato> campeonatos = (ArrayList<Campeonato>)intent.getSerializableExtra(MainActivity.LISTA);

        System.out.println("Campeonatos: "+ campeonatos);
        lista = campeonatos.toArray(new Campeonato[0]);

        BaseAdapter adapter = new CampeonatoAdapter(this, lista);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(ListarCampeonatoActivity.this, DetalheClienteActivity.class);
                intent1.putExtra(CAMPEONATO, lista[i]);
                startActivity(intent1);
            }
        });

    }

}
