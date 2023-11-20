package by.tms.lesson30_31_design_patterns_gof.structural.bridge.shapes;

import by.tms.lesson30_31_design_patterns_gof.structural.bridge.colors.Color;

public abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void draw();
}
