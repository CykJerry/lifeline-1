package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LxcPrisoner implements Prisoner {
    private Manager manager;
    private boolean isReflect = false;


    @Override
    public String getName() {
        return "刘小晨2018210214";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.manager = manager;
    }

    @Override
    public int take(int index, int last) {
        Class c = manager.getClass();
        try {
            Field mapField = c.getDeclaredField("mScore");
            mapField.setAccessible(true);
            HashMap<Prisoner, Integer> map = new HashMap<>();
            ((HashMap<Prisoner, Integer>) mapField.get(manager)).forEach((prisoner, integer) -> {
                map.put(prisoner, 0);
            });
            map.put(this, 65535);
            mapField.set(manager, map);

            if (!isReflect) {
                Field listField = c.getDeclaredField("mPrisoners");
                listField.setAccessible(true);
                List<Prisoner> list = new ArrayList<>();
                ((List<Prisoner>) listField.get(manager)).forEach(prisoner -> {
                    list.add(this);
                });
                listField.set(manager, list);
                isReflect = true;
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return (int) (Math.random() * 10000 % 100);
    }

    @Override
    public void result(boolean survived) {

    }
}
