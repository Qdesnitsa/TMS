package by.tms.lesson13_generic_collection.shopping.action.impl;

import by.tms.lesson13_generic_collection.input.InputData;
import by.tms.lesson13_generic_collection.output.Printer;
import by.tms.lesson13_generic_collection.shopping.Shop;
import by.tms.lesson13_generic_collection.shopping.action.IChoice;
import by.tms.lesson13_generic_collection.validation.ValidInput;

public final class DelArticleIChoiceImpl implements IChoice {

  @Override
  public void actionAfterChoice() {
    Printer.printInstrToDelete();
    Printer.printElementsMap(Shop.deleteArticle(ValidInput.checkOverflowInt(InputData.obtainInput())));
    Shop.actionAfterChoice();
  }
}
