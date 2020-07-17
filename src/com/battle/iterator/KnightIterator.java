package com.battle.iterator;

import com.battle.builder.Knight;
import com.battle.builder.Monster;
import com.battle.command.*;

import java.util.ArrayList;
import java.util.Scanner;

public class KnightIterator implements Iterator {

    private final  KnightsCollection knightsCollection;
    private final ArrayList<Knight> knights;
    private ArrayList<Monster> monsters;
    private Knight knight;
    private Monster monster;
    private int currentPosition = 0;

    public KnightIterator(KnightsCollection knightsCollection) {
        this.knightsCollection = knightsCollection;
        this.knights = knightsCollection.getKnights();
        this.monsters = knightsCollection.getMonsters();
    }

    @Override
    public boolean hasNext() {
        return currentPosition < knightsCollection.getKnights().size();
    }

    private void executeCommand(Command command) {
        command.execute();
    }

    @Override
    public KnightsCollection getNext() {
        Scanner keyInCommand = new Scanner(System.in);
        this.currentPosition = 0;
        Action action = new Action();
        while (true) {
            if (!hasNext()) {
                return knightsCollection;
            }
            int monsterNumber;
            while (true) {
                System.out.println("Wybierz potwora do zaatakowania: ");
                monsterNumber = Integer.parseInt(keyInCommand.nextLine());
                if(monsters.size()==0) {
                    System.out.println("Potwory zostały już pokonane!");
                    break;
                }
                if (monsterNumber > monsters.size())
                    System.out.println("Podano niepoprawny numer potwora");
                else {
                    monster = monsters.get(monsterNumber - 1);
                    System.out.println("Wybrano potwora: " + monsters.get(monsterNumber -1).getHeroName());
                    break;
                }
            }
            while (true) {
                System.out.println("Wybierz akcję dla postaci " + knights.get(this.currentPosition).getHeroName() + ", podaj jedną z poniższych cyfr: ");
                System.out.println("1- Standardowy atak");
                System.out.println("2- Ryzykowny atak- większe obrażenia, ale i strata 200 punktów życia");
                System.out.println("3- Regeneracja");
                int actionNumber = Integer.parseInt(keyInCommand.nextLine());
                switch (actionNumber) {
                    case 1:
                        setKnight(knightsCollection.getKnights().get(this.currentPosition));
                        setMonster(monster);
                        action.setKnight(knight);
                        action.setMonster(monster);
                        int monsterHp = monster.getCurrentHp();
                        StandardAttackCommand standardAttackCommand = new StandardAttackCommand(action);
                        executeCommand(standardAttackCommand);
                        setKnight(knight);
                        setMonster(monster);
                        int hurt=monsterHp- monster.getCurrentHp();
                        System.out.println("Wybrano standardowy atak, zadano "+ hurt + " punktów obrażeń potworowi " + monster.getHeroName());
                        if(monster.getCurrentHp() == 0 && monsters.size() != 0)
                            monsters.remove(monsters.get(monsterNumber - 1));
                        else if(monster.getCurrentHp() != 0) {
                            monsters.add(monsterNumber - 1, action.getMonster());
                            monsters.remove(monsters.get(monsterNumber));
                        }
                        break;
                    case 2:
                        System.out.println("Wybrano ryzykowny atak");
                        setKnight(knightsCollection.getKnights().get(this.currentPosition));
                        setMonster(monster);
                        action.setKnight(knight);
                        action.setMonster(monster);
                        monsterHp = monster.getCurrentHp();
                        RiskyAttackCommand riskyAttackCommand = new RiskyAttackCommand(action);
                        executeCommand(riskyAttackCommand);
                        setKnight(knight);
                        setMonster(monster);
                        hurt=monsterHp - monster.getCurrentHp();
                        System.out.println("Wybrano ryzykowny atak, zadano "+ hurt + " punktów obrażeń potworowi " + monster.getHeroName());
                        if(monster.getCurrentHp() == 0 && monsters.size() != 0)
                            monsters.remove(monsters.get(monsterNumber - 1));
                        else if(monster.getCurrentHp() != 0) {
                            monsters.add(monsterNumber - 1, action.getMonster());
                            monsters.remove(monsters.get(monsterNumber));
                        }
                        if(knight.getCurrentHp() == 0 && knights.size() != 0) {
                            knights.remove(knight);
                        }

                        break;
                    case 3:
                        System.out.println("Wybrano regenerację");
                        setKnight(knightsCollection.getKnights().get(this.currentPosition));
                        action.setKnight(knight);
                        int knightHp = knight.getCurrentHp();
                        RegenerationKnightCommand regenerationKnightCommand = new RegenerationKnightCommand(action);
                        executeCommand(regenerationKnightCommand);
                        setKnight(knight);
                        int newKnightHp = knight.getCurrentHp();
                        System.out.println("Wybrano regenerację tej postaci, odzyskano "+ (newKnightHp - knightHp) + " punktów zdrowia. Postać posiada teraz " +newKnightHp);

                        break;
                    default:
                        System.out.println("Podano niepoprawny numer akcji, musisz podać numer akcji jeszcze raz");
                        continue;
                }
                break;
            }
            this.currentPosition++;

        }
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
}