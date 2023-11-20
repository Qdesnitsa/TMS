package by.tms.lesson30_31_design_patterns_gof.creational.singleton.singleton_types;

// паттерн «Lazy Initialization Holder». Вложенные классы не инициализируются до первого их использования
public class Singleton6 {
    private Singleton6() {
    }

    public static Singleton6 getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final Singleton6 instance = new Singleton6();
    }
}
