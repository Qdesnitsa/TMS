### Недостатки паттерна Singleton: ###
1. Нарушение **Single Responsibility Principle**. Любой Singleton-класс отвечает сразу за две вещи:
   за то, что класс имеет лишь один объект, и за реализацию того, для чего этот класс вообще был создан.
2. Сильно затрудняет **юнит-тестирование**: 
   Если хотите протестировать какой-то класс, то вы обязаны вместе с ним тестировать и Singleton.
   Порядок тестов теперь имеет значение. 
   Тесты могут иметь нежелательные сторонние эффекты, порождённые Singleton’ом.
   Вы не можете запускать несколько тестов параллельно.
   Несколько вызовов одного и того же теста могут приводить к разным результатам.
3. **Скрытые зависимости**.
4. Загрузчик класса. Классическая реализация не проверяет, существует ли один экземпляр на JVM, 
   он лишь удостоверяется, что существует один экземпляр на classloader.
   Проблемы могут возникнуть, если используете несколько загрузчиков класса или приложение должно работать на сервере 
   (где может быть запущено **несколько экземпляров приложения в разных загрузчиках классов**).
5. Десеариализация. Стандартная реализация Singleton не запрещает создавать новые объекты. 
   Она запрещает создавать новые объекты через конструктор. А ведь существуют и другие **способы создать экземпляр класса**, 
   и один из них — **сериализация и десериализация**. Полной защиты от намеренного создания второго экземпляра Singleton’а 
   можно добиться только с помощью использования enum’а с единственным состоянием, но это — неоправданное злоупотребление возможностями языка, 
   ведь очевидно, что enum был придуман не для этого.
