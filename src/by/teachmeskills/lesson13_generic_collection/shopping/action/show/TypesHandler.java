package by.teachmeskills.lesson13_generic_collection.shopping.action.show;

import by.teachmeskills.lesson13_generic_collection.shopping.action.show.impl.SortAddDescIChoiceShowImpl;
import by.teachmeskills.lesson13_generic_collection.shopping.action.show.impl.SortPriceAscIChoiceShowImpl;
import by.teachmeskills.lesson13_generic_collection.shopping.action.show.impl.SortPriceDescIChoiceShowImpl;
import java.util.HashMap;
import java.util.Map;

public class TypesHandler {
  private Map<Integer, IChoiceShow> types;

  public TypesHandler() {
    types = new HashMap<>();
    types.put(1, new SortPriceAscIChoiceShowImpl());
    types.put(2, new SortPriceDescIChoiceShowImpl());
    types.put(3, new SortAddDescIChoiceShowImpl());
  }

  public void addType(int type, IChoiceShow action) {
    types.put(type,action);
  }

  public IChoiceShow getType(int type) {
    return types.get(type);
  }

}
