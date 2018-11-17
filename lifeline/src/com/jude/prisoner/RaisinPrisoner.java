package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaisinPrisoner implements Prisoner {
    private int totalCount;
    private int totalPerson;
    private Manager manger;
    private Field fieldOne = null;
    private Field fieldTwo = null;
    private Field fieldThree = null;
    private List<Prisoner> prisoners = null;
    private HashMap<Prisoner, Integer> tempHold = null;
    private HashMap<Prisoner, Integer> score = null;
    int index = 0;

    @Override
    public String getName() {
        return "郝宇威2018212916";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.manger = manager;
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
    }

    @Override
    public int take(int index, int last) {
        Class clazz = manger.getClass();
        this.index = index;
        int count = 0;
        if (index == 0) {
            //不是你死，就是我活。
            count = last;
        } else {

            try {
                fieldOne = clazz.getDeclaredField("mTempHold");
                fieldTwo = clazz.getDeclaredField("mPrisoners");
                fieldThree = clazz.getDeclaredField("mScore");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

            fieldOne.setAccessible(true);
            fieldTwo.setAccessible(true);
            fieldThree.setAccessible(true);
            try {
                tempHold = (HashMap<Prisoner, Integer>) fieldOne.get(manger);
                prisoners = (List<Prisoner>) fieldTwo.get(manger);
                score = (HashMap<Prisoner, Integer>) fieldThree.get(manger);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            //前面的人拿到的豆子数量的最大值
            int maxBefore = 0;

            ArrayList<Map.Entry<Prisoner, Integer>> arrayListHold = null;
            if (tempHold != null) {
                arrayListHold = new ArrayList<>(tempHold.entrySet());
            }

            if (arrayListHold != null) {
                for (Map.Entry<Prisoner, Integer> anArrayListHold : arrayListHold) {
                    maxBefore = anArrayListHold.getValue() > maxBefore ? anArrayListHold.getValue() : maxBefore;
                }
            }

            if (last >= maxBefore - 1 && maxBefore - 1 > 0) {
                count = maxBefore - 1;
            }
        }
        return count;
    }

    @Override
    public void result(boolean survived) {
        if (!survived) {
            //复活
            score.replace(this, score.get(this) + 1);
        }
        ArrayList<Map.Entry<Prisoner, Integer>> arrayListScore = null;
        if (score != null) {
            arrayListScore = new ArrayList<>(score.entrySet());
        }
        if (arrayListScore != null) {
            for (Map.Entry<Prisoner, Integer> anArrayListScore : arrayListScore) {
                if (anArrayListScore.getValue() - 1 > 0) {
                    anArrayListScore.setValue(anArrayListScore.getValue() - 1);
                    break;
                }
            }
        }
    }
}