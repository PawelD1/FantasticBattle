package com.battle.builder;


public class Wizard {

    private String heroName;
    private int maxHp;
    private int currentHp;
    private int maxMp;
    private int currentMp;

    public Wizard(String heroName, int maxHp, int currentHp, int maxMp, int currentMp) {
        this.heroName = heroName;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
        this.maxMp = maxMp;
        this.currentMp = currentMp;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }


    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }

    public void setCurrentMp(int currentMp) {
        this.currentMp = currentMp;
    }

    public String getHeroName() {
        return heroName;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public int getCurrentMp() {
        return currentMp;
    }
}
