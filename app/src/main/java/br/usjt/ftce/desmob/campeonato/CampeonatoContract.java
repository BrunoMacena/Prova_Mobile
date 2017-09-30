package br.usjt.ftce.desmob.campeonato;

import android.provider.BaseColumns;

/**
 * Bruno Macena da Silva 201512094
 */
public class CampeonatoContract {
    public CampeonatoContract(){}

    public static abstract class CampeonatoEntry implements BaseColumns{
        public static final String TABLE_NAME = "campeonato";
        public static final String COLUMN_NAME_CAMPEONATO_JOGOS = "jogos";
    }


}
