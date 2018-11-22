package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

public class LihuiPrisoner implements Prisoner {
    private int totalCount;
    private int totalPerson;

    @Override
    public String getName() {
        return "金礼辉2018214750";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
    }

    @Override
    public int take(int index, int last) {
        //经过⑨缜密的计算，拿这个数最能活
        return last/(totalPerson-index+4);
    }

    @Override
    public void result(boolean survived) {

    }
}