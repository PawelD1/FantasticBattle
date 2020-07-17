package com.battle.command;

public class RiskyAttackCommand extends Command {

    public RiskyAttackCommand(Action action) {
        super(action);
    }

    @Override
    public boolean execute() {
        action.riskyAttack(action.getKnight(), action.getMonster());
        return true;
    }
}
