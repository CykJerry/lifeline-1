package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

public class CopyerderPrisoner implements Prisoner {
    private Manager manager;
    private int totalCount;
    private int totalPerson;

    @Override
    public String getName() {
        return "王岌2018210642";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.manager = manager;
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
    }

    @Override
    public int take(int index, int last) {
        return 
        if (index > (totalPerson / 2))
            return (totalCount - last)/(index + 1) - totalCount / totalPerson;
        else
            return (totalCount - last)/(index + 1) + totalCount / totalPerson;
    }

    @Override
    public void result(boolean survived) {

    }

}
