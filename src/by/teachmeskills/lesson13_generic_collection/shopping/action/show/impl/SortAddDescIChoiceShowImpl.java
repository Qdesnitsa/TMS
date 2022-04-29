package by.teachmeskills.lesson13_generic_collection.shopping.action.show.impl;

import static by.teachmeskills.lesson13_generic_collection.shopping.Shop.sortAddDesc;

import by.teachmeskills.lesson13_generic_collection.output.Printer;
import by.teachmeskills.lesson13_generic_collection.shopping.action.show.IChoiceShow;

public final class SortAddDescIChoiceShowImpl implements IChoiceShow {

  @Override
  public void sortAfterShow() {
    Printer.printElements(sortAddDesc());
  }
}
