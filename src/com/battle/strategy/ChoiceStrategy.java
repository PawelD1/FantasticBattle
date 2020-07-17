package com.battle.strategy;


import com.battle.builder.HeroBuilder;

public interface ChoiceStrategy {

    HeroBuilder createFirstHero();

    HeroBuilder createSecondHero();

    HeroBuilder createThirdHero();
}
