package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

public class TaokePrisoner implements Prisoner {
    private int totalCount;
    private int totalPerson;

    @Override
    public String getName() {
        return "陶克元2017212599";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
    }

    @Override
    public int take(int index, int last) {
        //经过我缜密的计算，我算出我拿这个数最能活
        return (totalCount - last)/index+totalCount/totalPerson;
    }

    @Override
    public void result(boolean survived) {

    }
}
