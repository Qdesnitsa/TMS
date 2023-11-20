package by.tms.lesson30_31_design_patterns_gof.creational.singleton.singleton_types;

//4. Решение проблемы многопоточного доступа - условная блокировка.
public class Singleton4 {
    private static volatile Singleton4 instance;

    private Singleton4() {
    }

// Если экземпляр не создан, то синхронизация только при первом вызове.
    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                instance = new Singleton4();
            }
        }
        return instance;
    }
}
