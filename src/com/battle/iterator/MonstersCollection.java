package com.battle.iterator;

import com.battle.builder.Knight;
import com.battle.builder.Monster;
import com.battle.builder.Wizard;
import com.battle.facade.FacadeInit;

import java.util.ArrayList;

public class MonstersCollection implements IterableCollection {

    public MonstersCollection(FacadeInit facadeInit) {
        this.monsters = facadeInit.getMonsters();
        this.wizards = facadeInit.getWizards();
        this.knights = facadeInit.getKnights();
    }
    private ArrayList<Monster> monsters;
    private ArrayList<Knight> knights;
    private ArrayList<Wizard> wizards;

    public ArrayList<Knight> getKnights() {
        return knights;
    }

    public ArrayList<Wizard> getWizards() {
        return wizards;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    @Override
    public Iterator createIterator(){
        return new MonsterIterator(this);
    }
}