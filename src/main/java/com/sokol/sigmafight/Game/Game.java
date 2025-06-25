package com.sokol.sigmafight.Game;

public class Game {
    private int gold = 100;
    private int minDamage = 5;
    private int maxDamage = 10;
    private int heroHP = 100;
    private int enemyHP = 100;

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        if (gold < 0) {
            throw new IllegalArgumentException("Gold must be a positive number");
        }
        this.gold = gold;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getHeroHP() {
        return heroHP;
    }

    public void setHeroHP(int heroHP) {
        if(heroHP < 0){
            throw new IllegalArgumentException("Hero HP must be a positive number");
        }
        this.heroHP = heroHP;
    }

    public int getEnemyHP() {

        return enemyHP;
    }

    public void setEnemyHP(int enemyHP) {
        if (enemyHP < 0){
            throw new IllegalArgumentException("Enemy HP must be a positive number");
        }
        this.enemyHP = enemyHP;
    }
}
