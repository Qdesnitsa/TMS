package by.tms.lesson13_generic_collection.shopping.action;

import by.tms.lesson13_generic_collection.shopping.action.impl.AddArticleIChoiceImpl;
import by.tms.lesson13_generic_collection.shopping.action.impl.DelArticleIChoiceImpl;
import by.tms.lesson13_generic_collection.shopping.action.impl.EditArticleIChoiceImpl;
import by.tms.lesson13_generic_collection.shopping.action.impl.ExitProgram;
import by.tms.lesson13_generic_collection.shopping.action.impl.ShowArticleIChoiceImpl;

public enum ChoiceTypeTotal {
    SHOW(1, new ShowArticleIChoiceImpl()),
    ADD(2, new AddArticleIChoiceImpl()),
    DELETE(3, new DelArticleIChoiceImpl()),
    EDIT(4, new EditArticleIChoiceImpl()),
    EXIT(5, new ExitProgram());

    private int typeChoice;
    private IChoice action;

    ChoiceTypeTotal(int typeChoice, IChoice action) {
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

  public IChoice getAction() {
    return action;
  }
}

