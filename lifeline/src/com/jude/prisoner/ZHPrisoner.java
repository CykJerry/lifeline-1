package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

import java.security.PublicKey;

public  class ZHPrisoner implements Prisoner {
    private int totalCount;
    private int totalPerson;
    public String getName(){
        return "朱鸿2017214906";
    }
    public void begin(Manager manager, int totalPerson, int totalCount)
    {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
    };

    public int take(int index, int last){

        return ((totalCount - last + 1) / (index + 1) + (totalCount + 1) / totalPerson) / 2;
    };
    public void result(boolean survived){
    };
}
