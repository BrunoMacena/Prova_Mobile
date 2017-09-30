package br.usjt.ftce.desmob.campeonato;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by asbonato on 24/03/17.
 */

public class ViewHolder {
    private ImageView fotoTimes;
    private TextView nomeTime, detalheTime;

    public ViewHolder(ImageView fotoTimes, TextView nomeCliente, TextView detalheCliente) {
        this.fotoTimes = fotoTimes;
        this.nomeTime = nomeCliente;
        this.detalheTime = detalheCliente;
    }

    public ImageView getFotoTimes() {
        return fotoTimes;
    }

    public void setFotoTimes(ImageView fotoTimes) {
        this.fotoTimes = fotoTimes;
    }

    public TextView getNomeCliente() {
        return nomeTime;
    }

    public void setNomeCliente(TextView nomeCliente) {
        this.nomeTime = nomeCliente;
    }

    public TextView getDetalheCliente() {
        return detalheTime;
    }

    public void setDetalheCliente(TextView detalheCliente) {
        this.detalheTime = detalheCliente;
    }
}
