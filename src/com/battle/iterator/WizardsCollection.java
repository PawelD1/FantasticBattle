package com.battle.iterator;

import com.battle.builder.Monster;
import com.battle.builder.Wizard;
import com.battle.facade.FacadeInit;

import java.util.ArrayList;

public class WizardsCollection implements IterableCollection {

    public WizardsCollection(FacadeInit facadeInit) {
        this.wizards = facadeInit.getWizards();
        this.monsters = facadeInit.getMonsters();
    }

    private ArrayList<Wizard> wizards;

    private ArrayList<Monster> monsters;

    public ArrayList<Wizard> getWizards() {
        return wizards;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    @Override
    public Iterator createIterator(){
        return new WizardIterator(this);
    }
}