package by.teachmeskills.lesson13_generic_collection.shopping.action.impl;

import static by.teachmeskills.lesson13_generic_collection.shopping.Shop.actionAfterChoiceShow;

import by.teachmeskills.lesson13_generic_collection.shopping.Shop;
import by.teachmeskills.lesson13_generic_collection.shopping.action.IChoice;
import java.lang.reflect.InvocationTargetException;

public final class ShowArticleIChoiceImpl implements IChoice {

  @Override
  public void actionAfterChoice()
      throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
    actionAfterChoiceShow();
    Shop.actionAfterChoice();
  }
}
