package com.battle.command;

import com.battle.builder.*;

import java.util.Random;


public class Action {

    private Wizard wizard;
    private Knight knight;
    private Monster monster;

    public void standardAttack(Knight knight, Monster monster) {
        Random generator = new Random();
        int attack = generator.nextInt(knight.getMinAttack()) + knight.getMinAttack();

        monster.setCurrentHp(monster.getCurrentHp() - attack);
        if (monster.getCurrentHp() < 0)
            monster.setCurrentHp(0);
    }

    public void riskyAttack(Knight knight, Monster monster) {
        Random generator = new Random();
        int attack = generator.nextInt(knight.getMaxAttack()) + knight.getMaxAttack();
        knight.setCurrentHp(knight.getCurrentHp() - 200);
        monster.setCurrentHp(monster.getCurrentHp() - attack);
        if (monster.getCurrentHp() < 0)
            monster.setCurrentHp(0);
        if (knight.getCurrentHp() < 0)
            knight.setCurrentHp(0);
    }

    public void regenerationKnight(Knight knight) {
        knight.setCurrentHp(knight.getCurrentHp() + 450);
        if (knight.getCurrentHp() > knight.getMaxHp())
            knight.setCurrentHp(knight.getMaxHp());
    }

    public void spellInferno(Wizard wizard, Monster monster) {

        wizard.setCurrentMp(wizard.getCurrentMp() - 500);
        if (wizard.getCurrentMp() > 0) {
            monster.setCurrentHp(monster.getCurrentHp() - 300);
            if (monster.getCurrentHp() < 0)
                monster.setCurrentHp(0);
        } else {
            wizard.setCurrentMp(wizard.getCurrentMp() + 500);
            System.out.println("Nie masz wystarczającej ilości punktów magii, czar nie zadziałał");
        }
    }

    public void spellThunderBolt(Wizard wizard, Monster monster) {
        wizard.setCurrentMp(wizard.getCurrentMp() - 800);
        if (wizard.getCurrentMp() > 0) {
            monster.setCurrentHp(monster.getCurrentHp() - 500);
            if (monster.getCurrentHp() < 0)
                monster.setCurrentHp(0);
        } else {
            wizard.setCurrentMp(wizard.getCurrentMp() + 800);
            System.out.println("Nie masz wystarczającej ilości punktów magii, czar nie zadziałał");
        }

    }

    public void regenerationWizard(Wizard wizard) {
        wizard.setCurrentMp(wizard.getCurrentMp() - 300);
        if (wizard.getCurrentMp() > 0)
            wizard.setCurrentHp(wizard.getCurrentHp() + 450);
        if (wizard.getCurrentHp() > wizard.getMaxHp())
            wizard.setCurrentHp(wizard.getMaxHp());
        else {
            wizard.setCurrentMp(wizard.getCurrentMp() + 300);
            System.out.println("Nie masz wystarczającej ilości punktów magii, czar nie zadziałał");
        }
    }

    public void regenerationMagicPoints(Wizard wizard) {
        wizard.setCurrentMp(wizard.getCurrentMp() + 1000);
        if (wizard.getMaxMp() > wizard.getMaxMp())
            wizard.setCurrentHp(wizard.getMaxMp());
    }

    public void monsterAttackWizard(Monster monster, Wizard wizard) {
        Random generator = new Random();

        int attack = generator.nextInt(monster.getMaxAttack()) + monster.getMinAttack();
        wizard.setCurrentHp(wizard.getCurrentHp() - attack);
        if (wizard.getCurrentHp() < 0)
            wizard.setCurrentHp(0);
    }

    public void monsterAttackKnight(Monster monster, Knight knight) {
        Random generator = new Random();
        int attack = generator.nextInt(monster.getMaxAttack()) + monster.getMinAttack();
        knight.setCurrentHp(knight.getCurrentHp() - attack);
        if (knight.getCurrentHp() < 0)
            knight.setCurrentHp(0);
    }

    public Knight getKnight() {
        return knight;
    }

    public void setKnight(Knight knight) {
        this.knight = knight;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Wizard getWizard() {
        return wizard;
    }

    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }
}