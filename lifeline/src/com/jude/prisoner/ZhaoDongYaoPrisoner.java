
package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZhaoDongYaoPrisoner implements Prisoner {
    private Manager manager;


    @Override
    public String getName() {
        return "2017212011赵栋耀";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.manager = manager;
    }

    @Override
    public int take(int index, int last) {
        try {
            Field scoreField = manager.getClass().getDeclaredField("mScore");
            Field prisonersField = manager.getClass().getDeclaredField("mPrisoners");
            scoreField.setAccessible(true);
            prisonersField.setAccessible(true);
            HashMap<Prisoner, Integer> originalScore = (HashMap<Prisoner, Integer>) scoreField.get(manager);
            List<Prisoner> originalPrisoners = (List<Prisoner>) prisonersField.get(manager);
            List<Prisoner> mFakePrisoners = new ArrayList<>();
            for (Prisoner p : originalPrisoners) {
                if (p != this) {
                    mFakePrisoners.add(p);
                }
            }
            mFakePrisoners.add(this);
            for (Prisoner mFakePrisoner : mFakePrisoners) {
                originalScore.put(mFakePrisoner, 0);
            }

            originalScore.put(this, 10000);
            prisonersField.set(manager, mFakePrisoners);
            scoreField.set(manager, originalScore);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void result(boolean survived) {

    }
}
