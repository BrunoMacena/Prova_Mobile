package br.usjt.ftce.desmob.campeonato;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Bruno Macena da Silva 201512094
 */

public class CampeonatoAdapter extends BaseAdapter {
    Campeonato[] campeonatos;
    Activity context;

    public CampeonatoAdapter(Activity context, Campeonato[] campeonatos){
        this.context = context;
        this.campeonatos = campeonatos;
    }

    @Override
    public int getCount() {
        return campeonatos.length;
    }

    @Override
    public Object getItem(int i) {
        if(i >= 0 && i < campeonatos.length){
            return campeonatos[i];
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View viewReciclada, ViewGroup viewGroup) {
        View view = viewReciclada;
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_campeonato, viewGroup, false);
            ImageView fotoTime = (ImageView) view.findViewById(R.id.foto_time);
            TextView nomeTime = (TextView) view.findViewById(R.id.nome_time);
            TextView detalheTime = (TextView) view.findViewById(R.id.detalhe_time);
            //faz cache dos widgets na tagview para usar quando houver reciclagem
            view.setTag(new ViewHolder(fotoTime, nomeTime, detalheTime));
        }
        //usar os widgets cachedados na tag da view reciclada
        ViewHolder holder = (ViewHolder)view.getTag();
        //carrega os novos valores
        Drawable foto = Imagem.getDrawable(context);
        holder.getFotoTimes().setImageDrawable(foto);
        holder.getNomeCliente().setText(campeonatos[i].getVitorias());
        holder.getDetalheCliente().setText(campeonatos[i].getEmpates() + "  -  "+ campeonatos[i].getDerrotas());


        return view;
    }
}
