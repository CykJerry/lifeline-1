package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

public class JingChaoPrisoner implements Prisoner {
    private int totalCount;
    private int totalPerson;

    public String getName() {
        return "吴京超2017214300";
    }

    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
    }

    public int take(int index, int last) {
        //经过我吴京超缜密的计算，我算出我拿这个数最能活
        if (index <= totalCount) {
            return ((totalCount - last) / (index + 1) + totalCount / totalPerson) / 2;
        } else {
            return totalCount / (index + last);
        }
    }

    public void result(boolean survived) {
        if (survived == true) {
            System.out.println("我没死，还活着！");
        } else {
            System.out.println("什么我居然死了！！！");
        }


    }
}
