package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

public class GitYiMPrisoner implements Prisoner {
    private int totalCount;
    private int totalPerson;

    @Override
    public String getName() {
        return "GitYiM2017212668";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
    }

    @Override
    public int take(int index, int last) {
        if (index == 0)
            return totalCount / totalPerson;
        else
            return (totalCount - last) / index;
    }

    @Override
    public void result(boolean survived) {
        System.out.println("惊了！我还活着");
    }

}