package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

public class ZexiPrisoner implements Prisoner {
    private int totalCount;
    private int totalPerson;
    @Override
    public String getName() {
        return "冯泽熙20182112769";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
    }

    public int take(int index, int last) {
        if (index <= totalPerson) {
            return index+3;
        } else {
            return totalCount / (index*2-1);
        }
    }

    public void result(boolean survived) {
        if (survived == true) {
            System.out.println("hahah");
        } else {
            System.out.println("-.-!!!");
        }


    }
}