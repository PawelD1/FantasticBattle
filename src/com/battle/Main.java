package com.battle;

import com.battle.command.Action;
import com.battle.facade.FacadeGame;
import com.battle.facade.FacadeInit;
import com.battle.strategy.AdvancedStrategy;
import com.battle.strategy.ChoiceStrategy;
import com.battle.strategy.HardStrategy;
import com.battle.strategy.EasyStrategy;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner keyInCommand = new Scanner(System.in);
        FacadeGame app = new FacadeGame();
        FacadeInit facadeInit = new FacadeInit();
        System.out.println("Wybierz poziom trudności: e(easy) - łatwy, a(advanced) - średni, h(hard)- trudny");
        while (true) {
            String levelOfDifficult = keyInCommand.nextLine();
            switch (levelOfDifficult.toUpperCase()) {
                case "E":
                    ChoiceStrategy choiceStrategy = new EasyStrategy();
                    facadeInit.init(choiceStrategy);
                    break;
                case "A":
                    choiceStrategy = new AdvancedStrategy();
                    facadeInit.init(choiceStrategy);
                    break;
                case "H":
                    choiceStrategy = new HardStrategy();
                    facadeInit.init(choiceStrategy);
                    break;
                default:
                    System.out.println("Podano złą literę");
                    continue;
            }
            break;
        }
        Action action = new Action();
        boolean continueGame = true;
        do {
            facadeInit.show(action);
            continueGame = app.game(facadeInit);
        } while (continueGame);
        facadeInit.show(action);
    }
}
