package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

public class QianYingtianPrisoner implements Prisoner {
    private int totalCount;
    private int totalPerson;
    @Override
    public String getName() {
        return "钱瀛天2018214239";
    }
    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
    }
    @Override
    public int take(int index, int last) {
        if(index==0)
            return last;
        return (totalCount-last)/index;
    }
    @Override
    public void result(boolean survived) {
    }
}
