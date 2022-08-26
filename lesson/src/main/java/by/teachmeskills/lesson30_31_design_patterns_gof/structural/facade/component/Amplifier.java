package by.teachmeskills.lesson30_31_design_patterns_gof.structural.facade.component;

public class Amplifier {
    public Tuner tuner;
    public DvdPlayer dvdPlayer;
    public CdPlayer cdPlayer;

    public void on() {}
    public void off() {}
    public void setCd() {}
    public void setDvd() {}
    public void setTuner() {}
    public void setVolume() {}
}
