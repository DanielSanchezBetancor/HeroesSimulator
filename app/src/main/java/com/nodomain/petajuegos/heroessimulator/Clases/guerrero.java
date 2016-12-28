package com.nodomain.petajuegos.heroessimulator.Clases;

public class Guerrero {
    static double hp = 100;
    static double ad = 10;
    static double armor = 10;
    static double mr = 10;
    static double as = 1.00;
    static double crit = 0;
    static double lvl = 1;

    public Guerrero(double lvl) {
        this.lvl = lvl;
    }

    public static double getHp() {
        return hp + (lvl * 125);
    }

    public static double getAd() {
        return ad;
    }

    public static double getArmor() {
        return armor;
    }

    public static double getMr() {
        return mr;
    }

    public static double getAs() {
        return as;
    }

    public static double getCrit() {
        return crit;
    }
}
