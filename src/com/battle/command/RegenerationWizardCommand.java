package com.battle.command;

public class RegenerationWizardCommand extends Command {

    public RegenerationWizardCommand(Action action) {
        super(action);
    }

    @Override
    public boolean execute() {
        action.regenerationWizard(action.getWizard());
        return true;
    }
}
