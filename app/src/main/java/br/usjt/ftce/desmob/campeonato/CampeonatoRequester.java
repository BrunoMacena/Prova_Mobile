package br.usjt.ftce.desmob.campeonato;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Bruno Macena da Silva 201512094
 */

public class CampeonatoRequester {
    OkHttpClient campeonato = new OkHttpClient();

    public ArrayList<Campeonato> get (String url, String chave) throws IOException{
        ArrayList<Campeonato> lista = new ArrayList<>();

        if(chave != null && chave.length() > 0){
            url += "?chave="+chave;
        }
        System.out.println("URL: "+url);
        Request request = new Request.Builder().url(url).build();
        Response response = campeonato.newCall(request).execute();

        String jsonString = response.body().string();
        System.out.println("JSON: "+jsonString);

        try {
            JSONArray root = new JSONArray(jsonString);
            JSONObject item = null;
            for(int i = 0; i < root.length(); i++){
                item = (JSONObject)root.get(i);
                int id = item.getInt("id");
                String jogos = item.getString("jogos");
                String vitorias = item.getString("vitorias");
                String empates = item.getString("empates");
                String derrotas = item.getString("derrotas");
                String gols_marcados = item.getString("gols_marcados");
                String gols_sofridos = item.getString("gols_sofridos");
                String saldo_gols = item.getString("Saldo_gols");
                Campeonato campeonato = new Campeonato(jogos, vitorias, empates, derrotas, gols_marcados, gols_sofridos, saldo_gols);
                lista.add(campeonato);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Bitmap getImage(String url) throws  IOException{
        Request request = new Request.Builder().url(url).build();
        Response response = campeonato.newCall(request).execute();

        InputStream is = response.body().byteStream();

        Bitmap img = BitmapFactory.decodeStream(is);

        is.close();

        return img;
    }

    public boolean isConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return connectivityManager.getActiveNetworkInfo() != null &&
                connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
