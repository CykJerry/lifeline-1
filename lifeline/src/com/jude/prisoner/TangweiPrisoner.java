package com.jude.prisoner;

import com.jude.Manager;
import com.jude.Prisoner;

public class TangweiPrisoner {
    public class NimaPrisoner implements Prisoner {
        private int totalCount;
        private int totalPerson;

        @Override
        public String getName() {
            return "唐伟2018210739";
        }

        @Override
        public void begin(Manager manager, int totalPerson, int totalCount) {
            this.totalCount = totalCount;
            this.totalPerson = totalPerson;
        }

        @Override
        public int take(int index, int last) {

            return ((totalCount - last / 2) * (index + 1) - totalCount / totalPerson) / 2;
        }

        @Override
        public void result(boolean survived) {

        }
    }
}


