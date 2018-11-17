package com.jude.prisoner;

import com.jude.Manager;

import com.jude.Prisoner;

public class RanHongJiePrisoner implements Prisoner {
    private int totalCount;
    private int totalPerson;

    public String getName() {
        return "冉红杰2017210851";
    }


    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
    }


    public int take(int index, int last) {

        return ((totalCount - last) / (index + 1) + last / (totalPerson - index)) / 2;
    }

    public void result(boolean survived) {
    }
}
