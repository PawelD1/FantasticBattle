package com.battle.facade;

import com.battle.builder.*;
import com.battle.command.Action;
import com.battle.strategy.ChoiceStrategy;

import java.util.ArrayList;

public class FacadeInit {

    private final ArrayList<Knight> knights = new ArrayList<>();
    private final ArrayList<Wizard> wizards = new ArrayList<>();
    private final ArrayList<Monster> monsters = new ArrayList<>();

    public ArrayList<Knight> getKnights() {
        return knights;
    }

    public ArrayList<Wizard> getWizards() {
        return wizards;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void show(Action action) {
        int i = 0;
        int j = 1;
        for(Knight knight: knights) {
            System.out.println(j+".Człowiek: (" + knights.get(i).getHeroName() + ") Punkty zdrowia: " + knights.get(i).getCurrentHp() + "/" + knights.get(i).getMaxHp());
            ++i;
            ++j;
        }
        i=0;
        for(Wizard wizard: wizards) {
            System.out.println(j+".Czarownik: (" + wizards.get(i).getHeroName() + ") Punkty zdrowia: " + wizards.get(i).getCurrentHp() + "/" + wizards.get(i).getMaxHp() + " Punkty magii: " + wizards.get(i).getCurrentMp() + "/" + wizards.get(i).getMaxMp());
            ++i;
            ++j;
        }

        i = 0;
        for(Monster monster: monsters) {
            System.out.println((i+1)+".Potwór: (" + monsters.get(i).getHeroName() + ") Punkty zdrowia: " + monsters.get(i).getCurrentHp() + "/" + monsters.get(i).getMaxHp());
            ++i;
        }

    }

    public void init(ChoiceStrategy choiceStrategy) {

        HeroBuilder hBuilder = choiceStrategy.createFirstHero();
        Knight knight = hBuilder.getResultKnight();
        knights.add(knight);
        hBuilder = choiceStrategy.createSecondHero();
        Wizard wizard;
        if (hBuilder.getHeroName().equals("Knight") || hBuilder.getHeroName().equals("Archer")) {
            knight = hBuilder.getResultKnight();
            knights.add(knight);
        } else {
            wizard = hBuilder.getResultWizard();
            wizards.add(wizard);
        }
        hBuilder = choiceStrategy.createThirdHero();
        if (hBuilder.getHeroName().equals("Knight") || hBuilder.getHeroName().equals("Archer")) {
            knight = hBuilder.getResultKnight();
            knights.add(knight);
        } else {
            wizard = hBuilder.getResultWizard();
            wizards.add(wizard);
        }
        Director director = new Director();
        hBuilder = director.constructGreenDragon(hBuilder);
        monsters.add(hBuilder.getMonster());
        hBuilder = director.constructRedDragon(hBuilder);
        monsters.add(hBuilder.getMonster());
        hBuilder = director.constructAzureDragon(hBuilder);
        monsters.add(hBuilder.getMonster());
        System.out.println("");
    }
}
