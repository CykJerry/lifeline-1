package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

public class XsPrisoner implements Prisoner {
    private int totalCount;
    private int totalPerson;

    @Override
    public String getName() {
        return "梁瀚2018214044";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
    }

    @Override
    public int take(int index, int last) {
        return ((totalCount - last) / (index + 1) + last / totalPerson - 1);
    }

    @Override
    public void result(boolean survived) {

    }

}
