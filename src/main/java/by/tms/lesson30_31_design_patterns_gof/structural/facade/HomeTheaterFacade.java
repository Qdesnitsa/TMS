package by.tms.lesson30_31_design_patterns_gof.structural.facade;

import by.tms.lesson30_31_design_patterns_gof.structural.facade.component.*;

public class HomeTheaterFacade {
    private Amplifier amp;
    private Tuner tuner;
    private DvdPlayer dvd;
    private CdPlayer cd;
    private Projector projector;

    public HomeTheaterFacade(Amplifier amp, Tuner tuner, DvdPlayer dvd, CdPlayer cd, Projector projector) {
        this.amp = amp;
        this.tuner = tuner;
        this.dvd = dvd;
        this.cd = cd;
        this.projector = projector;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        projector.on();
        projector.tvMode();
        tuner.on();
        amp.on();
        amp.setDvd();
        amp.setVolume();
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie(String movie) {
        System.out.println("Shutting movie theater down...");
        projector.off();
        amp.off();
        dvd.off();
        dvd.eject();
        dvd.stop();
    }
}
