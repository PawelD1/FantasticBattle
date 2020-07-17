package com.battle.command;

public class ThunderBoldSpellCommand extends Command {

    public ThunderBoldSpellCommand(Action action) {
        super(action);
    }

    @Override
    public boolean execute() {
       action.spellThunderBolt(action.getWizard(), action.getMonster());
        return true;
    }
}
