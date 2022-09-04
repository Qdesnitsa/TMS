package by.teachmeskills.lesson30_31_design_patterns_gof.structural.facade;

import by.teachmeskills.lesson30_31_design_patterns_gof.structural.facade.component.*;

public class Main {
    public static void main(String[] args) {
        Projector projector = new Projector();
        CdPlayer cdPlayer = new CdPlayer();
        DvdPlayer dvdPlayer = new DvdPlayer();
        Tuner tuner = new Tuner();
        Amplifier amplifier = new Amplifier();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amplifier,tuner,dvdPlayer,cdPlayer,projector);
        homeTheater.watchMovie("Raiders of the Lost Ark");
        homeTheater.endMovie("Raiders of the Lost Ark");
    }
}
