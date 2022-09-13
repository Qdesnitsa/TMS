package by.teachmeskills.lesson30_31_design_patterns_gof.structural.decorator;

import by.teachmeskills.lesson30_31_design_patterns_gof.structural.decorator.beverage.DarkRoast;
import by.teachmeskills.lesson30_31_design_patterns_gof.structural.decorator.beverage.Espresso;
import by.teachmeskills.lesson30_31_design_patterns_gof.structural.decorator.beverage.HouseBlend;
import by.teachmeskills.lesson30_31_design_patterns_gof.structural.decorator.condiment.Mocha;
import by.teachmeskills.lesson30_31_design_patterns_gof.structural.decorator.condiment.Soy;
import by.teachmeskills.lesson30_31_design_patterns_gof.structural.decorator.condiment.Whip;

public class Main {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage.cost());

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage.cost());
    }
}