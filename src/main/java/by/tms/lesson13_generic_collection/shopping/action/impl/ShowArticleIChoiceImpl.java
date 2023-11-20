package by.tms.lesson13_generic_collection.shopping.action.impl;

import by.tms.lesson13_generic_collection.shopping.Shop;
import by.tms.lesson13_generic_collection.shopping.action.IChoice;

public final class ShowArticleIChoiceImpl implements IChoice {

  @Override
  public void actionAfterChoice() {
    Shop.actionAfterChoiceShow();
    Shop.actionAfterChoice();
  }
}
