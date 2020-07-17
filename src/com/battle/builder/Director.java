package com.battle.builder;


public class Director {
    public HeroBuilder constructKnight(HeroBuilder builder) {
        builder.setHeroName("Knight");
        builder.setMaxHp(3000);
        builder.setCurrentHp(3000);
        builder.setMinAttack(200);
        builder.setMaxAttack(300);
        return builder;
    }

    public HeroBuilder constructArcher(HeroBuilder builder) {
        builder.setHeroName("Archer");
        builder.setMaxHp(2500);
        builder.setCurrentHp(2500);
        builder.setMinAttack(150);
        builder.setMaxAttack(600);
        return builder;
    }

    public HeroBuilder constructWizard(HeroBuilder builder) {
        builder.setHeroName("Wizard");
        builder.setMaxHp(3500);
        builder.setCurrentHp(3500);
        builder.setMaxMp(2000);
        builder.setCurrentMp(2000);
        return builder;
    }

    public HeroBuilder constructGreenDragon(HeroBuilder builder) {
        builder.setHeroName("Green Dragon");
        builder.setMaxHp(1000);
        builder.setCurrentHp(1000);
        builder.setMinAttack(50);
        builder.setMaxAttack(400);
        return builder;
    }

    public HeroBuilder constructRedDragon(HeroBuilder builder) {
        builder.setHeroName("Red Dragon");
        builder.setMaxHp(750);
        builder.setCurrentHp(750);
        builder.setMinAttack(200);
        builder.setMaxAttack(350);
        return builder;
    }

    public HeroBuilder constructAzureDragon(HeroBuilder builder) {
        builder.setHeroName("Azure Dragon");
        builder.setMaxHp(5000);
        builder.setCurrentHp(5000);
        builder.setMinAttack(500);
        builder.setMaxAttack(600);
        return builder;
    }

}
