package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

public class PokerPrisoner implements Prisoner {
    private int totalCount;
    private int totalPerson;

    @Override
    public String getName() {
        return "张洪耀2018211717";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
    }

    @Override
    public int take(int index, int last) {
        if (index == 0) {
            return totalCount - totalPerson;
        }
        else if(index == 1){
            return ((totalCount - last) / (index + 1) + totalCount / totalPerson) / 2;
        }
        else {
            return ((totalCount * totalPerson / last + 100) + index);
        }
    }

    @Override
    public void result(boolean survived) {

    }

}