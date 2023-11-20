package by.tms.lesson30_31_design_patterns_gof.creational.singleton.singleton_types;

// 2. Решение проблемы многопоточного доступа - synchronized.
public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {
    }

// Синхронизация актуальна только при первом вызове метода. Затем -> лишние траты ресурсов -> значительное замедление выполнения.
    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
