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

    public void fight() throws InterruptedException {

        while (game.getHeroHP() > 0 && game.getEnemyHP() > 0) {

            Thread.sleep(1000); // kick waiting time

            int heroDamage = hero.attack(game.getMinDamage(), game.getMaxDamage());
            int enemyDamage = enemy.attack(5, 25);

            int randomNumber = getRandomNumber();

            if (randomNumber == 1) {
                game.setEnemyHP(game.getEnemyHP() - heroDamage);
                System.out.println("Hero " + "-" + heroDamage + "(Enemy HP: " + game.getEnemyHP() + ")");
            } else if (randomNumber == 0) {
                game.setHeroHP(game.getHeroHP() - enemyDamage);
                System.out.println("Enemy " + "-" + enemyDamage + "(Hero HP: " + game.getHeroHP() + ")");
            } else if (randomNumber == 2) {
                game.setEnemyHP(game.getEnemyHP() - heroDamage);
                System.out.println("Hero " + "-" + heroDamage + "(Enemy HP: " + game.getEnemyHP() + ")");
            }
        }
        if (game.getHeroHP() <= 0) {
            System.out.println("You lose");
            game.setEnemyHP(100);
        } else if (game.getEnemyHP() <= 0) {
            System.out.println("You win");
            game.setGold(game.getGold() + 20);
            System.out.println("+20 gold");
            game.setEnemyHP(100);
        } else
            System.out.println("draw");
    }
}
