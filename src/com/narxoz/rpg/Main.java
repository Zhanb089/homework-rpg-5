package com.narxoz.rpg;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.decorator.BasicAttack;
import com.narxoz.rpg.decorator.FireRuneDecorator;
import com.narxoz.rpg.decorator.PoisonCoatingDecorator;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.facade.AdventureResult;
import com.narxoz.rpg.facade.DungeonFacade;
import com.narxoz.rpg.hero.HeroProfile;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 5: Decorator + Facade ===\n");

        HeroProfile hero = new HeroProfile("CyberKnight", 120);
        BossEnemy boss = new BossEnemy("Malware Dragon", 250, 15);

        AttackAction strike = new BasicAttack("Power Strike", 20);
        
        AttackAction ultimateAttack = new FireRuneDecorator(new PoisonCoatingDecorator(strike));

        System.out.println("--- Attack Setup ---");
        System.out.println("Final Action: " + ultimateAttack.getActionName());
        System.out.println("Total Damage: " + ultimateAttack.getDamage());
        System.out.println("All Effects: " + ultimateAttack.getEffectSummary());

        DungeonFacade dungeon = new DungeonFacade();
        AdventureResult result = dungeon.runAdventure(hero, boss, ultimateAttack);

        for (String line : result.getLog()) {
            System.out.println(line);
        }
        
        System.out.println("--- Dungeon Result ---");
        System.out.println("Winner: " + result.getWinner());
        System.out.println("Reward: " + result.getReward());
    }
}
