package com.battle.command;

public class RegenerationMagicPointsCommand extends Command{

    public RegenerationMagicPointsCommand(Action action) {
        super(action);
    }

    @Override
    public boolean execute() {
        action.regenerationMagicPoints(action.getWizard());
        return true;
    }
}
