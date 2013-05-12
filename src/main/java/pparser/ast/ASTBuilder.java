package pparser.ast;

import java.util.LinkedList;
import java.util.List;

import pparser.EventHandler;

public class ASTBuilder implements EventHandler {

  private List<Expression> expressions = new LinkedList<>();

  @Override
  public void onExpression(String operation, Object arg0, Object arg1, Object arg2) {
    expressions.add(new Expression(operation, arg0, arg1, arg2));
  }

  public List<Expression> build() {
    return expressions;
  }

}
