package by.tms.lesson30_31_design_patterns_gof.creational.singleton.singleton_types;

//3. Решение проблемы многопоточного доступа - new instance.
public class Singleton3 {

// Если приложение всегда создаёт и использует экземпляр синглетного класса или затраты на создание не существенны,
// то экземпляр можно создать заранее при загрузке класса до обращения потока к статической переменной.
    private static Singleton3 instance = new Singleton3();

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        return instance;
    }
}
