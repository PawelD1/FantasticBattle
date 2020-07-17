package com.battle.command;

public class RegenerationKnightCommand extends Command {

    public RegenerationKnightCommand(Action action) {
        super(action);
    }

    @Override
    public boolean execute() {
        action.regenerationKnight(action.getKnight());
        return true;
    }
}
