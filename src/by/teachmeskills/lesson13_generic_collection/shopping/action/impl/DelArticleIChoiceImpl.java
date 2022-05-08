package by.teachmeskills.lesson13_generic_collection.shopping.action.impl;

import static by.teachmeskills.lesson13_generic_collection.shopping.Shop.*;

import by.teachmeskills.lesson13_generic_collection.input.InputData;
import by.teachmeskills.lesson13_generic_collection.output.Printer;
import by.teachmeskills.lesson13_generic_collection.shopping.Shop;
import by.teachmeskills.lesson13_generic_collection.shopping.action.IChoice;
import by.teachmeskills.lesson13_generic_collection.validation.ValidInput;

public final class DelArticleIChoiceImpl implements IChoice {

  @Override
  public void actionAfterChoice() {
    Printer.printInstrToDelete();
    Printer.printElementsMap(deleteArticle(ValidInput.checkOverflowInt(InputData.obtainInput())));
    Shop.actionAfterChoice();
  }
}
