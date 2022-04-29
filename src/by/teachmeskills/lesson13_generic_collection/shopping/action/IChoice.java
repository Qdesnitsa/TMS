package by.teachmeskills.lesson13_generic_collection.shopping.action;

import java.lang.reflect.InvocationTargetException;

public interface IChoice {
  void actionAfterChoice()
      throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;
}
