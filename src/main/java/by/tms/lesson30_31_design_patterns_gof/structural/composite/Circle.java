package by.tms.lesson30_31_design_patterns_gof.structural.composite;

public class Circle implements Shape {
    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Circle with color " + fillColor);
    }
}
