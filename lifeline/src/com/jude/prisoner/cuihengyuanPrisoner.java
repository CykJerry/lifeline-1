package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

public class cuihengyuanPrisoner implements Prisoner {

    private int totalCount;
    private int totalPerson;

    @Override
    public String getName() {
        return "崔恒源2018210808";
    }

    @Override
    public void begin(Manager manager, int totalPerson, int totalCount) {
        this.totalCount = totalCount;
        this.totalPerson = totalPerson;
    }

    @Override
    public int take(int index, int last) {
        int beTaken = totalCount - last;
        int i = 0;
        int j = 0;
        if (index % 2 == 0) {
            while (beTaken % (index - 1) != 0) {
                beTaken--;
                i = beTaken;
            }
            j = i / (index - 1);
            return (j - (index - 1) / 2);//或者j+(index - 1)/2+1
        }
        if (index % 2 != 0) {
            int k = beTaken / (index - 1);
            return k + (index + 1) / 2;//或者k-(index+1)/2
        }
return (totalCount/totalPerson)+2;
    }


    @Override
    public void result(boolean survived) {

    }
}
