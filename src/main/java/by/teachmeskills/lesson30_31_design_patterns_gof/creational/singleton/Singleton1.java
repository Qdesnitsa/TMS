package by.teachmeskills.lesson30_31_design_patterns_gof.creational.singleton;

// 1. Не решает проблему многопоточного доступа
public class Singleton1 {
    private static Singleton1 instance;

    private Singleton1() {
        throw new RuntimeException();
    }

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}

// 2. Решение проблемы многопоточного доступа - synchronized.
class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {
        throw new RuntimeException();
    }

// Синхронизация актуальна только при первом вызове метода. Затем -> лишние траты ресурсов -> значительное замедление выполнения.
    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

//3. Решение проблемы многопоточного доступа - new instance.
class Singleton3 {
// Если приложение всегда создаёт и использует экземпляр синглетного класса или затраты на создание не существенны,
// то экземпляр можно создать заранее при загрузке класса до обращения потока к статической переменной.
    private static Singleton3 instance = new Singleton3();

    private Singleton3() {
        throw new RuntimeException();
    }

    public static Singleton3 getInstance() {
        return instance;
    }
}

//4. Решение проблемы многопоточного доступа - условная блокировка.
class Singleton4 {
    private static volatile Singleton4 instance;

    private Singleton4() {
        throw new RuntimeException();
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

//public static final Singleton5 INSTANCE = new Singleton5();
//Потокобезопасный
enum Singleton5 {
    INSTANCE;
}
