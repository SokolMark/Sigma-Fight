package com.sokol.sigmafight.Game;

import com.sokol.sigmafight.Game.Additionally.Enemy;
import com.sokol.sigmafight.Game.Additionally.Hero;

import java.util.concurrent.ThreadLocalRandom;

public class Battle {
    public Game game;
    public Hero hero;
    public Enemy enemy;

    public Battle(Game game, Hero hero, Enemy enemy) {
        this.game = game;
        this.hero = hero;
        this.enemy = enemy;
    }

    public int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(3);
    }

    public void minusHpOfEnemy() {
        int heroDamage = hero.attack(game.getMinDamage(), game.getMaxDamage());

        game.setEnemyHP(game.getEnemyHP() - heroDamage);
        System.out.println("✅ The hero deals damage to the enemy" + " - " + heroDamage);
    }

    public void minusHpOfHero() {
        int enemyDamage = enemy.attack(5, 25);

        game.setHeroHP(game.getHeroHP() - enemyDamage);
        System.out.println("\uD83D\uDC94 The enemy deals damage to the hero " + "-" + enemyDamage);
    }

    public void getGold(int gold) {
        game.setGold(game.getGold() + gold);
    }

    public void getFullEnemyHP() {
        game.setEnemyHP(100);
    }

    public void fight() throws InterruptedException {

        while (game.getHeroHP() > 0 && game.getEnemyHP() > 0) {

            Thread.sleep(1000); // kick waiting time

            int randomNumber = getRandomNumber();

            switch (randomNumber) {
                case 0 -> minusHpOfHero();
                case 1 -> minusHpOfEnemy();
            }

        }
        if (game.getHeroHP() <= 0) {
            System.out.println("☠\uFE0FYOU LOST☠\uFE0F");
            getFullEnemyHP();
            game.setHeroHP(0);

        } else if (game.getEnemyHP() <= 0) {
            System.out.println("⚔\uFE0FYOU WON⚔\uFE0F");
            getGold(20);
            System.out.println("+20 gold");
            getFullEnemyHP();

        } else
            System.out.println("draw");
    }


}
