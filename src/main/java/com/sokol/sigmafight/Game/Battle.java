package com.sokol.sigmafight.Game;

import com.sokol.sigmafight.Game.Additionally.Enemies.Arena;
import com.sokol.sigmafight.Game.Additionally.Enemies.Boss;
import com.sokol.sigmafight.Game.Additionally.Enemies.Robber;
import com.sokol.sigmafight.Game.Additionally.Enemy;
import com.sokol.sigmafight.Game.Additionally.Hero;

import java.util.Scanner;

public class Battle {
    public MainHero mainHero;
    public Hero hero;
    public Enemy enemy;
    Robber robber;
    Boss boss;
    Arena arena;

    public Battle(MainHero mainHero, Hero hero, Enemy enemy, Robber robber, Boss boss, Arena arena) {
        this.mainHero = mainHero;
        this.hero = hero;
        this.enemy = enemy;
        this.robber = robber;
        this.boss = boss;
        this.arena = arena;
    }

    public void fight() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--Battle fight--");
            System.out.println("What enemies do you want to fight?");
            System.out.println("1. - Robber");
            System.out.println("2. - Boss");
            System.out.println("3. - Arena");
            System.out.println("4. - Exit to main menu");

            int choice = sc.nextInt();

            if (mainHero.getHeroHP() >= 25) {
                switch (choice) {
                    case 1:
                        robber.battle(mainHero);
                        robber.getResult();
                        break;
                    case 2:
                        boss.battle(mainHero);
                        boss.getResult();
                        break;
                    case 3:
                        arena.battle(mainHero);
                        break;
                    case 4: {
                        return;
                    }
                }
            }
            else if (mainHero.getHeroHP() < 24 ) {
                System.out.println("You have " + mainHero.getHeroHP() + " HP. You need 25 HP to fight.");
                break;
            }
        }
    }
}
