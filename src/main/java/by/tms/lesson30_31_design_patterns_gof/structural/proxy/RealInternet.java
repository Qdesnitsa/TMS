package by.tms.lesson30_31_design_patterns_gof.structural.proxy;

public class RealInternet implements Internet {

    @Override
    public void connectTo(String serverhost) {
        System.out.println("Connecting to " + serverhost);
    }
}
