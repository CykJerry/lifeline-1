package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

public class Roger implements Prisoner {
    private int totalCount;
    private int totalPerson;
<<<<<<< HEAD:lifeline/src/com/jude/prisoner/Roger.java

    @Override
    public String getName() {
        return "王尼玛2016210409";
=======
    public String getName(){
        return "朱鸿2017214906";
>>>>>>> pr/19:lifeline/src/com/jude/prisoner/ZHPrisoner.java
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
<<<<<<< HEAD:lifeline/src/com/jude/prisoner/Roger.java
    }

    @Override
    public int take(int index, int last) {
        //经过我王尼玛缜密的计算，我算出我拿这个数最能活
        return ((totalCount - last) / (index + 1) + totalCount / totalPerson) / 2;
    }

    @Override
    public void result(boolean survived) {

    }
=======
    };

    public int take(int index, int last){
            if(index > totalPerson / 2){
                return ((totalCount - last + 1) / (index + 1) + (totalCount + 1) / totalPerson) / 2;
            }
            else
                return (totalCount / index + last + 1);
 
    };
    public void result(boolean survived){
    };
>>>>>>> pr/19:lifeline/src/com/jude/prisoner/ZHPrisoner.java
}
