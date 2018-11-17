package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

public class CharlesPrisoner implements Prisoner {
    private int totalCount;
    private int totalPerson;

    @Override
    public String getName() {
        return "滕思远2018210021";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
    }

    @Override
    public int take(int index, int last) {

        return totalCount /  totalPerson;
    }

    @Override
    public void result(boolean survived) {

    }

}