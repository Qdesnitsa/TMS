package by.tms.lesson13_generic_collection.shopping.action.show.impl;

import by.tms.lesson13_generic_collection.output.Printer;
import by.tms.lesson13_generic_collection.shopping.action.show.IChoiceShow;
import by.tms.lesson13_generic_collection.shopping.Shop;

public final class SortPriceDescIChoiceShowImpl implements IChoiceShow {

  @Override
  public void sortAfterShow() {
    Printer.printElements(Shop.sortPriceDesc());
  }
}
