package com.battle.command;

public class MonsterAttackWizardCommand extends Command {

    public MonsterAttackWizardCommand(Action action) {
        super(action);
    }

    @Override
    public boolean execute() {
        action.monsterAttackWizard(action.getMonster(), action.getWizard());
        return true;
    }
}
