package com.battle.command;

public class StandardAttackCommand extends Command {
    public StandardAttackCommand(Action action) {
        super(action);
    }

    @Override
    public boolean execute() {
        action.standardAttack(action.getKnight(), action.getMonster());
        return true;
    }
}
