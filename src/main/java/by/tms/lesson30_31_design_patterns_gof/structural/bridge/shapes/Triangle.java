package by.tms.lesson30_31_design_patterns_gof.structural.bridge.shapes;

import by.tms.lesson30_31_design_patterns_gof.structural.bridge.colors.Color;

public class Triangle extends Shape {

    public Triangle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Drawing triangle");
        color.fillColor();
    }
}
