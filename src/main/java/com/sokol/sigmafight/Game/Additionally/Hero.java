package com.sokol.sigmafight.Game.Additionally;

import java.util.concurrent.ThreadLocalRandom;

public  class Hero extends  Attack {
    @Override
    public int attack(int minDamage, int maxDamage) {
        return ThreadLocalRandom.current().nextInt(minDamage, maxDamage);
    }
}
