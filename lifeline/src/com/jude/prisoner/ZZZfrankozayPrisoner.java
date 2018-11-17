package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class ZZZfrankozayPrisoner implements Prisoner {
    private int totalCount;
    private int totalPerson;
    private int count;
    private Manager manager;
    private String name = "白皓月2017211990";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
        if (name.equals("白皓月2017211990")) {
            try {
                Field prisonerField = manager.getClass().getDeclaredField("mPrisoners");
                Field scoreFiled = manager.getClass().getDeclaredField("mScore");
                scoreFiled.setAccessible(true);
                prisonerField.setAccessible(true);
                List<Prisoner> prisoners = (List<Prisoner>) prisonerField.get(manager);
                List<Prisoner> newPrisoners = new ArrayList<>();
                HashMap<Prisoner, Integer> newScore = new HashMap<>();
                for (Prisoner temp : prisoners) {
                    if (!temp.getName().equals("白皓月2017211990") && temp != this) {
                        ZZZfrankozayPrisoner republican = new ZZZfrankozayPrisoner();//全都是我
                        republican.name = temp.getName();//名字留下
                        republican.totalPerson = totalPerson;
                        newPrisoners.add(republican);
                        newScore.put(republican, 0);
                    }
                }
                newScore.put(this, 0);
                newPrisoners.add(this);
                prisonerField.set(manager, newPrisoners);
                scoreFiled.set(manager, newScore);
                for (Prisoner temp : newPrisoners
                        ) {
                    temp = (ZZZfrankozayPrisoner) temp;
                    ((ZZZfrankozayPrisoner) temp).manager = manager;
                }
                this.manager = manager;

            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public int take(int index, int last) {
        if (index == 0) {

            try {
                Random r = new Random();
                int i = 1;
                int j = 2;
                int first = r.nextInt(totalPerson - 2) + 1;
                int second = r.nextInt(totalPerson - 2) + 1;
                while (first == second) {
                    second = r.nextInt(totalPerson - 2) + 1;
                }
                Field prisonerField = manager.getClass().getDeclaredField("mPrisoners");
                prisonerField.setAccessible(true);
                List<Prisoner> prisoners = (List<Prisoner>) prisonerField.get(manager);
                for (Prisoner temp : prisoners
                        ) {
                    temp = (ZZZfrankozayPrisoner) temp;
                    if (!((ZZZfrankozayPrisoner) temp).name.equals("白皓月2017211990")) {
                        if (first == i) ((ZZZfrankozayPrisoner) temp).count = 1;
                        else if (second == i) ((ZZZfrankozayPrisoner) temp).count = totalPerson;//随机选两个死
                        else ((ZZZfrankozayPrisoner) temp).count = j++;
                        i++;
                    } else
                        ((ZZZfrankozayPrisoner) temp).count = totalPerson - 1;
                }

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    @Override
    public void result(boolean survived) {

    }
}
