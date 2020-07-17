package com.battle.strategy;


import com.battle.builder.Director;
import com.battle.builder.HeroBuilder;

public class HardStrategy implements ChoiceStrategy {

    @Override
    public HeroBuilder createFirstHero() {
        Director director = new Director();
        HeroBuilder builder = new HeroBuilder();
        return director.constructKnight(builder);
    }

    @Override
    public HeroBuilder createSecondHero() {
        Director director = new Director();
        HeroBuilder builder = new HeroBuilder();
        return director.constructWizard(builder);
    }

    @Override
    public HeroBuilder createThirdHero() {
        Director director = new Director();
        HeroBuilder builder = new HeroBuilder();
        return director.constructWizard(builder);

    }
}
