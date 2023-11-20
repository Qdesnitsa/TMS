package by.tms.lesson13_generic_collection.shopping.action.impl;

import by.tms.lesson13_generic_collection.input.InputData;
import by.tms.lesson13_generic_collection.output.Printer;
import by.tms.lesson13_generic_collection.shopping.Shop;
import by.tms.lesson13_generic_collection.shopping.action.IChoice;

public final class AddArticleIChoiceImpl implements IChoice {

  @Override
  public void actionAfterChoice() {
    Printer.printInstrForArticle();
    Printer.printElementsMap(Shop.addArticle(Shop.obtainParamOfArticle(InputData.obtainInput())));
    Shop.actionAfterChoice();
  }
}
