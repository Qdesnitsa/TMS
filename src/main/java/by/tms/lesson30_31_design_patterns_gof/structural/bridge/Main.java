package by.tms.lesson30_31_design_patterns_gof.structural.bridge;

import by.tms.lesson30_31_design_patterns_gof.structural.bridge.colors.*;
import by.tms.lesson30_31_design_patterns_gof.structural.bridge.shapes.*;

public class Main {
    public static void main(String[] args) {
        Shape rectangle1 = new Rectangle(new BlackColor());
        rectangle1.draw();

        Shape rectangle2 = new Rectangle(new RedColor());
        rectangle2.draw();

        Shape triangle = new Triangle(new GreenColor());
        triangle.draw();
    }
}
