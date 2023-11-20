package by.tms.lesson30_31_design_patterns_gof.structural.bridge.colors;

public class RedColor implements Color {
    @Override
    public void fillColor() {
        System.out.println("Filling in red color");
    }
}
