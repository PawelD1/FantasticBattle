package com.battle.command;

public class InfernoSpellCommand extends Command {

    public InfernoSpellCommand(Action action) {
        super(action);
    }

    @Override
    public boolean execute() {
        action.spellInferno(action.getWizard(), action.getMonster());
        return true;
    }
}
