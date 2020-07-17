package com.battle.builder;

public class HeroBuilder implements Builder {

    private String heroName;
    private int maxHp;
    private int currentHp;
    private int minAttack;
    private int maxAttack;
    private int maxMp;
    private int currentMp;

    @Override
    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    @Override
    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    @Override
    public void setCurrentHp(int cHp) {
        this.currentHp = cHp;
    }

    @Override
    public void setMinAttack(int minA) {
        this.minAttack = minA;
    }

    @Override
    public void setMaxAttack(int maxA) {
        this.maxAttack = maxA;
    }


    @Override
    public void setMaxMp(int maxP) {
        this.maxMp = maxP;
    }

    @Override
    public void setCurrentMp(int cMP) {
        this.currentMp = cMP;
    }

    public String getHeroName() {
        return heroName;
    }

    public Knight getResultKnight() {
        return new Knight(heroName, maxHp, currentHp, minAttack, maxAttack);
    }

    public Wizard getResultWizard() {
        return new Wizard(heroName, maxHp, currentHp, maxMp, currentMp);
    }

    public Monster getMonster() {
        return new Monster(heroName, maxHp, currentHp, minAttack, maxAttack);
    }

}


   
