package by.tms.lesson30_31_design_patterns_gof.structural.flyweight;

public class Terrorist implements Player {
    private final String TASK;
    private String weapon;

    public Terrorist() {
        TASK = "PLANT A BOMB";
    }

    @Override
    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public void mission() {
        System.out.println("Terrorist with weapon " + weapon + "|" + " Task is " + TASK);
    }
}
