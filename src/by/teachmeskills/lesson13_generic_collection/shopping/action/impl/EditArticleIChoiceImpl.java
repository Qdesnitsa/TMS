package by.teachmeskills.lesson13_generic_collection.shopping.action.impl;

import static by.teachmeskills.lesson13_generic_collection.shopping.Shop.*;

import by.teachmeskills.lesson13_generic_collection.input.InputData;
import by.teachmeskills.lesson13_generic_collection.output.Printer;
import by.teachmeskills.lesson13_generic_collection.shopping.Shop;
import by.teachmeskills.lesson13_generic_collection.shopping.action.IChoice;
import java.lang.reflect.InvocationTargetException;

public final class EditArticleIChoiceImpl implements IChoice {

  @Override
  public void actionAfterChoice()
      throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
    Printer.printInstrForArticle();
    Printer.printElementsMap(modifyArticle(obtainParamOfArticle(InputData.obtainInput())));
    Shop.actionAfterChoice();
  }
}
