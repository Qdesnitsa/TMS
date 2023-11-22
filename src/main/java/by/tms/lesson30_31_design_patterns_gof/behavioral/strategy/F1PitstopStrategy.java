package by.tms.lesson30_31_design_patterns_gof.behavioral.strategy;

public class F1PitstopStrategy implements FillStrategy {
    @Override
    public void fill() {
        System.out.println("Fill up with gasoline after pitstop process!");
    }
}
