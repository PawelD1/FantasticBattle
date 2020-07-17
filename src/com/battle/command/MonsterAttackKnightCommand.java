package com.battle.command;

public class MonsterAttackKnightCommand extends Command {

    public MonsterAttackKnightCommand(Action action) {
        super(action);
    }

    @Override
    public boolean execute() {
        action.monsterAttackKnight(action.getMonster(), action.getKnight());
        return true;
    }
}
