package br.usjt.ftc.desmob.campeonato;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Bruno Macena da Silva 201512094
 */

public class Time {

    public static ArrayList<String> listarNomes(Time[] time){
        ArrayList<String> nomes = new ArrayList<>();
        for (Time time : time) {
            nomes.add(time.getNome());
        }
        return nomes;
    }
    public static Time[] listarTimes(String times) {
        Time[] time;
        ArrayList<nomes> times = new ArrayList<>();

        for (Time time : todosTimes()) {
            if (Time.getCampeonato().equals(times) || times.equals("Todos")) {
                times.add(time);
            }
        }
        lista = times.toArray(new Time[0]);

        Arrays.sort(lista);

        return lista;
    }

    private static ArrayList<Nome> todosPaises() {
        ArrayList<Nome> nomes = new ArrayList<>();
        Pais times;
        ArrayList<String> jogos;
        ArrayList<String> vitorias;
        ArrayList<String> empates;
        ArrayList<String> derrotas;
        ArrayList<String> gols_marcados;
        ArrayList<String> gols_sofridos;
        ArrayList<String> saldo_gols;
        times = new Times();
        times.setJogos("12");
        times.setVitorias("4");
        times.setEmpates("2");
        times.setDerrotas("6");
        times.setGols_marcados("8");
        times.setGols_Sofridos("9");
        times.setSaldo_gols(18)
        idiomas = new ArrayList<>();
        idiomas.add("Pashto");
        idiomas.add("Uzbek");
        idiomas.add("Turkmen");
        times.setIdiomas(idiomas);
        moedas = new ArrayList<>();
        moedas.add("Afghan afghani");
        times.setMoedas(moedas);
        dominios = new ArrayList<>();
        dominios.add(".af");
        times.setDominios(dominios);
        fusos = new ArrayList<>();
        fusos.add("UTC+04:30");
        times.setFusos(fusos);
        fronteiras = new ArrayList<>();
        fronteiras.add("IRN");
        fronteiras.add("PAK");
        fronteiras.add("TKM");
        fronteiras.add("UZB");
        fronteiras.add("TJK");
        fronteiras.add("CHN");
        times.setFronteiras(fronteiras);
        times.setLatitude(33.000000);
        times.setLongitude(65.000000);
        paises.add(times);


    }
}
