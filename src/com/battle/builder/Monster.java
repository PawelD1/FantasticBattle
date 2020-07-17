package com.battle.builder;

public class Monster {

    private String heroName;
    private int maxHp;
    private int currentHp;
    private int minAttack;
    private int maxAttack;

    public Monster(String monsterName, int maxHp, int currentHp, int minAttack, int maxAttack) {
        this.heroName = monsterName;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
        this.minAttack = minAttack;
        this.maxAttack = maxAttack;
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

    public void setMonsterName(String monsterName) {
        this.heroName = monsterName;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getMinAttack() {
        return minAttack;
    }

    public void setMinAttack(int minAttack) {
        this.minAttack = minAttack;
    }

    public int getMaxAttack() {
        return maxAttack;
    }

    public void setMaxAttack(int maxAttack) {
        this.maxAttack = maxAttack;
    }
}
