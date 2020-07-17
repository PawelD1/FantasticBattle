package com.battle.iterator;

import com.battle.builder.Monster;
import com.battle.builder.Wizard;
import com.battle.command.*;

import java.util.ArrayList;
import java.util.Scanner;

public class WizardIterator implements Iterator {

    private WizardsCollection wizardsCollection;
    private ArrayList<Wizard> wizards;
    private ArrayList<Monster> monsters;
    private Wizard wizard;
    private Monster monster;
    private int monsterNumber;
    private int currentPosition = 0;

    public WizardIterator(WizardsCollection wizardsCollection) {
        this.wizardsCollection = wizardsCollection;
        this.wizards = wizardsCollection.getWizards();
        this.monsters = wizardsCollection.getMonsters();
    }

    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < wizardsCollection.getWizards().size();
    }

    private void executeCommand(Command command) {
        command.execute();
    }

    @Override
    public WizardsCollection getNext() {
        Scanner keyInCommand = new Scanner(System.in);
        this.currentPosition = 0;
        Action action = new Action();
        while (true) {
            if (!hasNext()) {
                return wizardsCollection;
            }
            while (true) {
                System.out.println("Wybierz potwora do zaatakowania: ");
                monsterNumber = Integer.parseInt(keyInCommand.nextLine());
                if (monsters.size() == 0) {
                    System.out.println("Potwory zostały już pokonane!");
                    break;
                } else if (monsterNumber > monsters.size())
                    System.out.println("Podano niepoprawny numer potwora");
                else {
                    monster = monsters.get(monsterNumber - 1);
                    System.out.println("Wybrano potwora: " + monsters.get(monsterNumber - 1).getHeroName());
                    break;
                }
            }
            while (true) {
                System.out.println("Wybierz akcję dla postaci " + wizards.get(this.currentPosition).getHeroName() + ", podaj jedną z poniższych cyfr: ");
                System.out.println("1- Inferno, koszt: 500 punktów many");
                System.out.println("2- Błyskawica, koszt: 800 punktów many ");
                System.out.println("3- Regeneracja, koszt: 300 punktów many");
                System.out.println("4- Regeneracja punktów magii");
                int actionNumber = Integer.parseInt(keyInCommand.nextLine());
                switch (actionNumber) {
                    case 1:
                        setWizard(wizardsCollection.getWizards().get(this.currentPosition));
                        setMonster(monster);
                        action.setWizard(wizard);
                        action.setMonster(monster);
                        int monsterHp = monster.getCurrentHp();
                        InfernoSpellCommand infernoSpellCommand = new InfernoSpellCommand(action);
                        executeCommand(infernoSpellCommand);
                        setWizard(wizard);
                        setMonster(monster);
                        int hurt = monsterHp - monster.getCurrentHp();
                        if (monster.getCurrentHp() == 0 && monsters.size() != 0)
                            monsters.remove(monsters.get(monsterNumber - 1));
                        else if (monster.getCurrentHp() != 0) {
                            monsters.add(monsterNumber - 1, action.getMonster());
                            monsters.remove(monsters.get(monsterNumber));
                        }
                        System.out.println("Wybrano czar inferno, zadano " + hurt + " punktów obrażeń potworowi " +
                                monster.getHeroName() + " pozostało mu " + monster.getCurrentHp() + " punktów zdrowia");

                        break;
                    case 2:
                        setWizard(wizardsCollection.getWizards().get(this.currentPosition));
                        setMonster(monster);
                        action.setWizard(wizard);
                        action.setMonster(monster);
                        monsterHp = monster.getCurrentHp();
                        ThunderBoldSpellCommand thunderBoldSpellCommand = new ThunderBoldSpellCommand(action);
                        executeCommand(thunderBoldSpellCommand);
                        setWizard(wizard);
                        setMonster(monster);
                        hurt = monsterHp - monster.getCurrentHp();
                        if (monster.getCurrentHp() == 0 && monsters.size() != 0)
                            monsters.remove(monsters.get(monsterNumber - 1));
                        else if (monster.getCurrentHp() != 0) {
                            monsters.add(monsterNumber - 1, action.getMonster());
                            monsters.remove(monsters.get(monsterNumber));
                        }
                        System.out.println("Wybrano czar błyskawica, zadano " + hurt + " punktów obrażeń potworowi " + monster.getHeroName());

                        break;
                    case 3:
                        setWizard(wizardsCollection.getWizards().get(this.currentPosition));
                        action.setWizard(wizard);
                        int wizardHp = wizard.getCurrentHp();
                        RegenerationWizardCommand regenerationWizardCommand = new RegenerationWizardCommand(action);
                        executeCommand(regenerationWizardCommand);
                        setWizard(wizard);
                        int newWizardHp = wizard.getCurrentHp();
                        System.out.println("Wybrano regenerację punktów zdrowia tej postaci, odzyskano " + (newWizardHp - wizardHp) +
                                " punktów zdrowia. Postać posiada teraz " + wizardHp + "punktów zdrowia. Liczba punktów magii wynosi " + wizard.getCurrentMp());

                        break;
                    case 4:
                        setWizard(wizardsCollection.getWizards().get(this.currentPosition));
                        action.setWizard(wizard);
                        int wizardMp = wizard.getCurrentMp();
                        RegenerationMagicPointsCommand regenerationMagicPointsCommand = new RegenerationMagicPointsCommand(action);
                        executeCommand(regenerationMagicPointsCommand);
                        setWizard(wizard);
                        int newWizardMp = wizard.getCurrentMp();
                        System.out.println("Wybrano regenerację punktów magii tej postaci, odzyskano " + (newWizardMp - wizardMp) +
                                " punktów magii. Postać posiada teraz " + wizardMp + "punktów magii");

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
}