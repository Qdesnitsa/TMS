package by.teachmeskills.lesson13_generic_collection.shopping.action;

import by.teachmeskills.lesson13_generic_collection.shopping.action.impl.AddArticleIChoiceImpl;
import by.teachmeskills.lesson13_generic_collection.shopping.action.impl.DelArticleIChoiceImpl;
import by.teachmeskills.lesson13_generic_collection.shopping.action.impl.EditArticleIChoiceImpl;
import by.teachmeskills.lesson13_generic_collection.shopping.action.impl.ExitProgram;
import by.teachmeskills.lesson13_generic_collection.shopping.action.impl.ShowArticleIChoiceImpl;
import java.lang.reflect.InvocationTargetException;

public enum ChoiceTypeTotal {
    SHOW(1, ShowArticleIChoiceImpl.class),
    ADD(2, AddArticleIChoiceImpl.class),
    DELETE(3, DelArticleIChoiceImpl.class),
    EDIT(4, EditArticleIChoiceImpl.class),
    EXIT(5, ExitProgram.class);

    private int typeChoice;
    private Class<? extends IChoice> action;

    ChoiceTypeTotal(int typeChoice, Class<? extends IChoice> action) {
      this.typeChoice = typeChoice;
      this.action = action;
    }

    public static ChoiceTypeTotal getActionByType(int typeChoice) {
      for(ChoiceTypeTotal type : ChoiceTypeTotal.values()) {
        if (type.typeChoice == typeChoice) {
          return type;
        }
      }
      throw new RuntimeException("Incorrect input.");
    }

  public IChoice getAction()
      throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    return action.getDeclaredConstructor().newInstance();
  }
}

