package by.tms.lesson30_31_design_patterns_gof.structural.bridge.shapes;

import by.tms.lesson30_31_design_patterns_gof.structural.bridge.colors.Color;

public class Rectangle extends Shape {

    public Rectangle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Drawing rectangle");
        color.fillColor();
    }
}
