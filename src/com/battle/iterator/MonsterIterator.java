package com.battle.iterator;

import com.battle.builder.Knight;
import com.battle.builder.Monster;
import com.battle.builder.Wizard;
import com.battle.command.*;

import java.util.ArrayList;
import java.util.Random;

public class MonsterIterator implements Iterator{

    private final  MonstersCollection monstersCollection;
    private final ArrayList<Monster> monsters;
    private ArrayList<Knight> knights;
    private ArrayList<Wizard> wizards;
    private Monster monster;
    private Knight knight;
    private Wizard wizard;
    private int currentPosition = 0;

    public MonsterIterator(MonstersCollection monstersCollection) {
        this.monstersCollection = monstersCollection;
        this.monsters = monstersCollection.getMonsters();
        this.knights= monstersCollection.getKnights();
        this.wizards = monstersCollection.getWizards();
    }


    private void executeCommand(Command command) {
        command.execute();
    }

    @Override
    public boolean hasNext() {
        return currentPosition < monstersCollection.getMonsters().size();
    }

    @Override
    public MonstersCollection getNext() {
        Action action = new Action();
        this.currentPosition = 0;
        while (true) {
            if (!hasNext()) {
                System.out.println("Ilość potworów: " + monstersCollection.getMonsters().size());
                return monstersCollection;
            }

            int amount = knights.size() + wizards.size();
            Random generator = new Random();
            int choice = generator.nextInt(amount) + 1;
            monster = monsters.get(this.currentPosition);
            System.out.println("");
            if(knights.size() == 2 && wizards.size() == 1) {
                if(choice == 1) {
                    System.out.println(knights.get(choice-1).getHeroName());
                    knight = knights.get(choice-1);
                    damagesForKnight(knight, monster, action, choice - 1);
                }
                else if(choice == 2) {
                    System.out.println(knights.get(choice-1).getHeroName());
                    knight = knights.get(choice-1);
                    damagesForKnight(knight, monster, action, choice - 1);

                }
                else if(choice == 3) {
                    wizard = wizards.get(choice-3);
                    damagesForWizard(wizard, monster, action, choice - 3);
                }

            }
            else if(knights.size() == 1 && wizards.size() == 2) {
                if(choice == 1) {
                    System.out.println(knights.get(choice-1).getHeroName());
                    knight = knights.get(choice-1);
                    damagesForKnight(knight, monster, action, choice - 1);

                }
                else if(choice == 2) {
                    System.out.println(wizards.get(choice-2).getHeroName());
                    wizard = wizards.get(choice-2);
                    monster = monsters.get(this.currentPosition);
                    damagesForWizard(wizard, monster, action, choice -2);
                }
                else if(choice == 3) {
                    System.out.println(wizards.get(choice-2).getHeroName());
                    wizard = wizards.get(choice-2);
                    monster = monsters.get(this.currentPosition);
                    damagesForWizard(wizard, monster, action, choice - 2);

                }
            }
            else if(knights.size() == 1 && wizards.size() == 1)
            {
                if(choice == 1) {
                    System.out.println(knights.get(choice-1).getHeroName());
                    knight = knights.get(choice-1);
                    damagesForKnight(knight, monster, action, choice - 1);

                }
                else if(choice == 2) {
                    System.out.println(wizards.get(choice-2).getHeroName());
                    wizard = wizards.get(choice-2);
                    damagesForWizard(wizard, monster, action, choice - 2);
                }
            }
            else if((knights.size() == 3 || knights.size() == 2 || knights.size() ==1) && wizards.size() == 0) {
                System.out.println(knights.get(choice-1).getHeroName());
                knight = knights.get(choice-1);
                damagesForKnight(knight, monster, action, choice - 1);
                System.out.println("");
            }
            else if ((wizards.size() == 2 || wizards.size() == 1) && knights.size() == 0) {
                System.out.println(wizards.get(choice-1).getHeroName());
                monster = monsters.get(this.currentPosition);
                wizard = wizards.get(choice-1);
                damagesForWizard(wizard, monster, action, choice - 1);
            }
            this.currentPosition++;
        }
    }

    public void damagesForWizard(Wizard wizard, Monster monster, Action action, int choice) {

        setMonster(monstersCollection.getMonsters().get(this.currentPosition));
        setWizard(wizard);
        action.setMonster(monster);
        action.setWizard(wizard);
        int wizardHp = wizard.getCurrentHp();
        MonsterAttackWizardCommand monsterAttackWizardCommand = new MonsterAttackWizardCommand(action);
        executeCommand(monsterAttackWizardCommand);
        setMonster(monster);
        setWizard(wizard);
        int hurt= wizardHp- wizard.getCurrentHp();
        System.out.println("Potwór " + monster.getHeroName() + " zadał "+ hurt + " punktów obrażeń " + wizard.getHeroName());
        if(wizard.getCurrentHp() == 0 && wizards.size() != 0)
            wizards.remove(wizards.get(choice));
        else if (wizard.getCurrentHp() != 0)
        {
            wizards.add(choice , action.getWizard());
            wizards.remove(wizards.get(choice));
        }
    }

    public void damagesForKnight(Knight knight, Monster monster, Action action, int choice) {

        setMonster(monstersCollection.getMonsters().get(this.currentPosition));
        setKnight(knight);
        action.setMonster(monster);
        action.setKnight(knight);
        int knightHp = knight.getCurrentHp();
        MonsterAttackKnightCommand monsterAttackKnightCommand = new MonsterAttackKnightCommand(action);
        executeCommand(monsterAttackKnightCommand);
        setMonster(monster);
        setKnight(knight);
        int hurt= knightHp- knight.getCurrentHp();
        System.out.println("Potwór " + monster.getHeroName() + " zadał "+ hurt + " punktów obrażeń " + knight.getHeroName());
        if(knight.getCurrentHp() == 0 && knights.size() != 0)
            knights.remove(knights.get(choice));
        else if (knight.getCurrentHp() != 0)
        {
            knights.add(choice, action.getKnight());
            knights.remove(knights.get(choice));
        }
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public void setKnight(Knight knight) {
        this.knight = knight;
    }

    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }

}