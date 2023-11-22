package by.tms.lesson30_31_design_patterns_gof.behavioral.chain_of_responsibility;

public interface DispenseChain {
    void setNextChain(DispenseChain nextChain);

    void dispense(Currency cur);
}
