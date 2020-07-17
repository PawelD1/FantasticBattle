package com.battle.command;


public abstract class Command {
    public Action action;

    Command(Action action) {
        this.action = action;
    }

    public abstract boolean execute();


}
