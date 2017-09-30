package br.usjt.ftce.desmob.campeonato;

import java.io.Serializable;

/**
 * Bruno Macena da Silva 201512094
 */

public class Campeonato implements Serializable, Comparable<Campeonato> {
    private String jogos;
    private String vitorias;
    private String empates;
    private String derrotas;
    private String gols_marcados;
    private String gols_sofridos;
    private String saldo_gols;

    public Campeonato(int jogos, String vitorias, String empates, String derrotas) {
        this.jogos = jogos;
        this.vitorias = vitorias;
        this.empates = empates;
        this.derrotas = derrotas;
    }

    public String getGols_sofridos() {
        return gols_sofridos;
    }

    public void setGols_sofridos(String gols_sofridos) {
        this.gols_sofridos = gols_sofridos;
    }

    public String getSaldo_gols() {
        return saldo_gols;
    }

    public void setSaldo_gols(String saldo_gols) {
        this.saldo_gols = saldo_gols;
    }

    public String getGols_marcados() {
        return gols_marcados;
    }

    public void setGols_marcados(String gols_marcados) {
        this.gols_marcados = gols_marcados;
    }

    public int getJogos() {
        return jogos;
    }

    public void setJogos(int jogos) {
        this.jogos = jogos;
    }

    public String getVitorias() {
        return vitorias;
    }

    public void setVitorias(String vitorias) {
        this.vitorias = vitorias;
    }

    public String getEmpates() {
        return empates;
    }

    public void setEmpates(String empates) {
        this.empates = empates;
    }

    public String getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(String derrotas) {
        this.derrotas = derrotas;
    }

    public String getImagem(){
        String foto = this.derrotas.replace('@', '_');
        return foto.replace('.', '_');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Campeonato campeonato = (Campeonato) o;

        if (jogos != campeonato.jogos) return false;
        if (!vitorias.equals(campeonato.vitorias)) return false;
        if (!empates.equals(campeonato.empates)) return false;
        return derrotas.equals(campeonato.derrotas);

    }

    @Override
    public int hashCode() {
        int result = jogos;
        result = 31 * result + vitorias.hashCode();
        result = 31 * result + empates.hashCode();
        result = 31 * result + derrotas.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Campeonato{" +
                "jogos=" + jogos +
                ", vitorias='" + vitorias + '\'' +
                ", empates='" + empates + '\'' +
                ", derrotas='" + derrotas + '\'' +
                '}';
    }

    @Override
    public int compareTo(Campeonato campeonato) {
        return this.vitorias.compareTo(campeonato.getVitorias());
    }
}
