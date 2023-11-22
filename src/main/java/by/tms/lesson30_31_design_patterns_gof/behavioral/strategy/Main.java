package by.tms.lesson30_31_design_patterns_gof.behavioral.strategy;

import by.tms.lesson30_31_design_patterns_gof.behavioral.strategy.auto.*;

public class Main {
    public static void main(String[] args) {

        Auto sedan = new Sedan();
        Auto hybrid = new HybridAuto();
        Auto f1car = new F1Car();

        sedan.fill();
        hybrid.fill();
        f1car.fill();

        ChildrenBuggies buggies = new ChildrenBuggies();
        buggies.setFillStrategy(new StandartFillStrategy());

        buggies.fill();
    }
}
