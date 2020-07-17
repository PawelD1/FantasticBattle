package com.battle.iterator;

import com.battle.builder.Knight;
import com.battle.builder.Monster;
import com.battle.facade.FacadeInit;

import java.util.ArrayList;

public class KnightsCollection implements IterableCollection {

    public KnightsCollection(FacadeInit facadeInit) {
        this.knights = facadeInit.getKnights();
        this.monsters = facadeInit.getMonsters();
    }

    private ArrayList<Monster> monsters;

    private ArrayList<Knight> knights;

    public ArrayList<Knight> getKnights() {
        return knights;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    @Override
    public Iterator createIterator(){
        return new KnightIterator(this);
    }
}