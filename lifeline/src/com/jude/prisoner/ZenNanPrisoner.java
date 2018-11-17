package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

public class ZenNanPrisoner implements Prisoner {
    private Manager manager;
    private int totalPerson;
    private int totalCount;
    @Override
    public String getName() {
        return "林镇南2018212778";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.manager = manager;
        this.totalPerson = totalPerson;
        this.totalCount = totalCount;
    }

    @Override
    public int take(int index, int last) {
        return index - (totalCount - last)+last/2;
    }

    @Override
    public void result(boolean survived) {

    }
}
