package com.sokol.sigmafight;

import com.sokol.sigmafight.Game.Additionally.Enemies.Arena;
import com.sokol.sigmafight.Game.Additionally.Enemies.Boss;
import com.sokol.sigmafight.Game.Additionally.Enemies.Robber;
import com.sokol.sigmafight.Game.Additionally.Enemy;
import com.sokol.sigmafight.Game.Additionally.Hero;
import com.sokol.sigmafight.Game.Battle;
import com.sokol.sigmafight.Game.MainHero;
import com.sokol.sigmafight.Game.MainMenu;
import com.sokol.sigmafight.Game.Shop;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Enemy enemy = new Enemy();
        Hero hero = new Hero();
        MainHero mainHero = new MainHero();
        Robber robber = new Robber(mainHero, hero, enemy);
        Boss boss = new Boss(mainHero, hero, enemy);
        Arena arena = new Arena(mainHero, hero, enemy);

        Shop shop = new Shop(mainHero);
        Battle battle = new Battle(mainHero, hero, enemy, robber, boss, arena);

        MainMenu mainMenu = new MainMenu(shop, battle);
        mainMenu.chooseOption();
    }

}
