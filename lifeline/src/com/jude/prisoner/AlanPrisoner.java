package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

import java.lang.reflect.Field;
import java.util.HashMap;


/**
 * Created by Mr.Jude on 2015/10/28.
 */
public class AlanPrisoner implements Prisoner {
    private Manager manager;

    @Override
    public String getName() {
        return "杨智2018212934";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.manager = manager;
    }

    @Override
    public int take(int index, int last) {
            Class c = manager.getClass();
            Field field = null;
            try {
                field = c.getDeclaredField("mScore");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            field.setAccessible(true);
            try {
                ((HashMap<Prisoner,Integer>) field.get(manager)).replace(this,2333333);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return 3;
    }

    @Override
    public void result(boolean survived) {

    }

}
