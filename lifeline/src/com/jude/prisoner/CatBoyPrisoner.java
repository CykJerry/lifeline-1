package com.jude.prisoner;

import com.jude.Prisoner;
import com.jude.Manager;

public class CatBoyPrisoner implements Prisoner {
    private int totalPerson;
    private int totalCount;

    @Override
    public String getName() {
        return "吴至龙2018211981";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalPerson = totalPerson;
        this.totalCount = totalCount;
    }

    @Override
    public int take(int index, int last) {
        if (totalPerson == index + 1) {
            return (totalCount - last) / (index + 1); //如果我是最后一个拿豆子，就算他们之前的人平均每人拿豆的数量。
        } else {
            return totalCount / totalPerson; //不是的话，就算平均每人拿豆的数量。
        }
    }

    @Override
    public void result(boolean survived) {

    }
}

