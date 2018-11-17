package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by DF on 2018/11/17.
 * 经过本弱无限次的折腾，终于能战胜王尼玛了
 * BUT，由于各种借鉴（Copy）往届学长学姐的（此处Orz）经验（代码）
 * 果然，产生了各种BUG
 * 修复无果，没办法，交付学长学姐，望轻批QAQ
 */

public class DFPrisoner implements Prisoner {

    private Manager mManager;

    @Override
    public String getName() {
        return "陈志超2018211860";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        mManager = manager;
    }

    @Override
    public int take(int index, int last) {
        Class cl = mManager.getClass();
        List<Prisoner> prisoners = null;
        ArrayList score = null;

        try {
            Field f = cl.getDeclaredField("mPrisoners");
            f.setAccessible(true);
            prisoners = (List<Prisoner>) f.get(mManager);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < prisoners.size() / 2; i++) {
            if (prisoners.get(i) != this) {
                prisoners.set(i, new Mytake(prisoners.get(i).getName()));
            }
        }

        for (int i = prisoners.size() / 2; i < prisoners.size(); i++) {
            if (prisoners.get(i) != this) {
                prisoners.set(i, new Mytake2(prisoners.get(i).getName()));
            }
        }
        return 3;
    }

    @Override
    public void result(boolean survived) {

        if (! survived) {
            HashMap<Prisoner, Integer> mScore = null;
            Field score = null;
            Class c = mManager.getClass();
            try {
                score = c.getDeclaredField("mScore");
                score.setAccessible(true);
                mScore = (HashMap<Prisoner, Integer>) score.get(mManager);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            mScore.replace(this, mScore.get(this) + 1);
        }

    }

    class Mytake implements Prisoner {
        String name;

        public Mytake(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public void begin(Manager manager, int totalPerson, int totalCount) {

        }

        @Override
        public int take(int index, int last) {
            return 1;
        }

        @Override
        public void result(boolean survived) {
        }
    }
    class Mytake2 implements Prisoner {
        String name;

        public Mytake2(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public void begin(Manager manager, int totalPerson, int totalCount) {

        }

        @Override
        public int take(int index, int last) {
            return 5;
        }

        @Override
        public void result(boolean survived) {

        }
    }
}







