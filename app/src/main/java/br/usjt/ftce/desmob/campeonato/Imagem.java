package br.usjt.ftce.desmob.campeonato;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import java.lang.reflect.Field;

/**
 * Bruno Macena da Silva 201512094
 */

public class Imagem {
    public static Drawable getDrawable(Activity context, String drawableName){
        Class<?> c = R.drawable.class;
        try{
            Field idField = c.getDeclaredField(drawableName);
            int id = idField.getInt(idField);
            return context.getResources().getDrawable(id, null);
        } catch(NoSuchFieldException e){
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Drawable getDrawable(Activity context){
        String drawableName = "padrao";
        return getDrawable(context,drawableName);
    }


}
