package com.nodomain.petajuegos.heroessimulator.Clases;


public class Cazador {
    static int ad = 9;
    static int armor = 13;
    static double as = 0.800;
    static double crit = 10;
    static double hp = 105;
    static double mana = 50;
    static int mr = 9;
    static double lvl = 1;
    public Cazador(double lvl) {
        this.lvl = lvl;
    }
    public static int getAd() {
        return ad;
    }

    public static int getArmor() {
        return armor;
    }

    public static double getAs() {
        return as;
    }

    public static double getCrit() {
        return crit;
    }

    public static double getHp() {
        return hp + (lvl * 100);
    }

    public static double getMana() {
        return mana + (lvl * 10);
    }

    public static int getMr() {
        return mr;
    }

}