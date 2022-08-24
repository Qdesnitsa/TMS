package by.teachmeskills.lesson30_31_design_patterns_gof.adapter;

import by.teachmeskills.lesson30_31_design_patterns_gof.adapter.duck_impl.MallardDuck;
import by.teachmeskills.lesson30_31_design_patterns_gof.adapter.duck_impl.TurkeyAdapter;
import by.teachmeskills.lesson30_31_design_patterns_gof.adapter.turkey_impl.WildTurkey;

public class Main {
    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();
        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("\nThe Duck says...");
        testDuck(duck);

        System.out.println("\nThe TurkeyAdapter says...");
        testDuck(turkeyAdapter);
    }

    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
