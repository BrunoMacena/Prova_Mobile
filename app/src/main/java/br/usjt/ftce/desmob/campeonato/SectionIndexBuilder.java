package br.usjt.ftce.desmob.campeonato;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.TreeSet;

/**
 * Bruno Macena da Silva 201512094
 */

public class SectionIndexBuilder {
    public static Object[] BuildSectionHeaders(Campeonato[] campeonatos)
    {
        ArrayList<String> results = new ArrayList<>();
        TreeSet<String> used    = new TreeSet<>();
        if(campeonatos != null) {
            for (Campeonato item : campeonatos) {
                String letter = item.getVitorias().substring(0, 1);

                if (!used.contains(letter))
                    results.add(letter);

                used.add(letter);
            }
        }
        return results.toArray(new Object[0]);
    }

    public static Hashtable<Integer, Integer> BuildSectionForPositionMap(Campeonato[] campeonatos)
    {
        Hashtable results = new Hashtable<Integer, Integer>();
        TreeSet<String> used    = new TreeSet<>();
        int section = -1;

        if(campeonatos != null) {
            for (int i = 0; i < campeonatos.length; i++) {
                String letter = campeonatos[i].getVitorias().substring(0, 1);

                if (!used.contains(letter)) {
                    section++;
                    used.add(letter);
                }

                results.put(i, section);
            }
        }
        return results;
    }
    public static Hashtable<Integer, Integer> BuildPositionForSectionMap(Campeonato[] campeonatos)
    {
        Hashtable results = new Hashtable<Integer, Integer>();
        TreeSet<String> used    = new TreeSet<>();
        int section = -1;

        if(campeonatos != null) {
            for (int i = 0; i < campeonatos.length; i++) {
                String letter = campeonatos[i].getVitorias().substring(0, 1);

                if (!used.contains(letter)) {
                    section++;
                    used.add(letter);
                    results.put(section, i);
                }
            }
        }
        return results;
    }
}
