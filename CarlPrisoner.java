package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CarlPrisoner implements Prisoner {

    private  int totalCount;
    private int totalPerson;

    public String getName(){
        return "罗浩2018214076";
    }
    public void  begin(Manager manager, int totalCount, int totalPerson){
        this.totalCount=totalCount;
        this.totalPerson=totalPerson;
    }

    @Override
    public int take(int index, int last) {

     return (totalPerson/totalCount-last)/index+1;

    }

    @Override
    public void result(boolean survived) {

    }

}
