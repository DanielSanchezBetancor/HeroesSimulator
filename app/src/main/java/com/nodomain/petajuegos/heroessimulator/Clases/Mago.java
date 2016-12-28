package com.nodomain.petajuegos.heroessimulator.Clases;

/**
 * Created by AUTOESCUELA FENIX on 22/11/2016.
 */

public class Mago {
    static int ad = 5;
    static int ap = 10;
    static int armor = 13;
    static double as = 0.670;
    static double crit = 0.0;
    static double hp = 105;
    static double mana = 100;
    static int mr = 9;
    static double lvl = 1;

    public Mago(double lvl) {
        this.lvl = lvl;
    }

    public static int getAd() {
        return ad;
    }

    public static int getAp() {
        return ap;
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
        return hp + (lvl * 85);
    }

    public static double getMana() {
        return mana + (lvl * 10);
    }

    public static int getMr() {
        return mr;
    }

}
