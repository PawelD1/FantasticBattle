package com.battle.builder;


public interface Builder {
    void setHeroName(String name);

    void setMaxHp(int maxHp);

    void setCurrentHp(int cHp);

    void setMinAttack(int minA);

    void setMaxAttack(int maxA);

    void setMaxMp(int maxP);

    void setCurrentMp(int cMP);

}
