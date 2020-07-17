package com.battle.facade;

import com.battle.iterator.*;

public class FacadeGame {

    public boolean game(FacadeInit facadeInit) {
        KnightsCollection knightsCollection = new KnightsCollection(facadeInit);
        WizardsCollection wizardsCollection = new WizardsCollection(facadeInit);
        MonstersCollection monstersCollection = new MonstersCollection(facadeInit);
        KnightIterator knightIterator = new KnightIterator(knightsCollection);
        knightIterator.getNext();
        if (monstersCollection.getMonsters().size() == 0) {
            System.out.println("GRATULACJE, WYGRAŁEŚ!!! WSZYSTKIE POTWORY ZOSTAŁY POKONANE!");
            return false;
        }
        WizardIterator wizardIterator = new WizardIterator(wizardsCollection);
        wizardIterator.getNext();
        if (monstersCollection.getMonsters().size() == 0) {
            System.out.println("GRATULACJE, WYGRAŁEŚ!!! WSZYSTKIE POTWORY ZOSTAŁY POKONANE!");
            return false;
        }
        MonsterIterator monsterIterator = new MonsterIterator(monstersCollection);
        monsterIterator.getNext();
        if (knightsCollection.getKnights().size() == 0 && wizardsCollection.getWizards().size() == 0) {
            System.out.println("PRZEGRAŁEŚ, TWOJE POSTACIE ZOSTAŁY POKONANE...");
            return false;
        }
        return true;
    }
}