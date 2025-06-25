package com.sokol.sigmafight;

import com.sokol.sigmafight.Game.Additionally.Enemy;
import com.sokol.sigmafight.Game.Additionally.Hero;
import com.sokol.sigmafight.Game.Battle;
import com.sokol.sigmafight.Game.Game;
import com.sokol.sigmafight.Game.MainMenu;
import com.sokol.sigmafight.Game.Shop;

public class Main
{
    public static void main( String[] args ) throws InterruptedException {
        Enemy enemy = new Enemy();
        Hero hero = new Hero();
        Game game = new Game();

        Shop shop = new Shop(game);
        Battle battle = new Battle(game, hero, enemy);

        MainMenu mainMenu = new MainMenu(shop, battle);
        mainMenu.chooseOption();
    }

}
