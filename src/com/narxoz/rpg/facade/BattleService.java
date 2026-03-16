package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;
import java.util.Random;

public class BattleService {
    private Random random = new Random(1L);

    public BattleService setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public AdventureResult battle(HeroProfile hero, BossEnemy boss, AttackAction action) {
        AdventureResult result = new AdventureResult();
        int round = 1;

        result.addLine("Battle started: " + hero.getName() + " vs " + boss.getName());

        while (hero.isAlive() && boss.isAlive() && round <= 20) {
            result.addLine("--- Round " + round + " ---");

            int hDamage = action.getDamage();
            boss.takeDamage(hDamage);
            result.addLine(hero.getName() + " hits for " + hDamage + " damage.");

            if (boss.isAlive()) {
                int bDamage = boss.getAttackPower();
                hero.takeDamage(bDamage);
                result.addLine(boss.getName() + " counters for " + bDamage + " damage.");
            }
            round++;
        }

        result.setRounds(round - 1);
        result.setWinner(hero.isAlive() ? hero.getName() : boss.getName());
        return result;
    }
}
