package by.teachmeskills.lesson13_generic_collection.shopping.action.impl;

import static by.teachmeskills.lesson13_generic_collection.shopping.Shop.actionAfterChoiceShow;

import by.teachmeskills.lesson13_generic_collection.shopping.Shop;
import by.teachmeskills.lesson13_generic_collection.shopping.action.IChoice;

public final class ShowArticleIChoiceImpl implements IChoice {

  @Override
  public void actionAfterChoice() {
    actionAfterChoiceShow();
    Shop.actionAfterChoice();
  }
}
