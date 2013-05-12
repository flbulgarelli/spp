package pparser.ast;

import java.util.LinkedList;
import java.util.List;

import net.sf.staccatocommons.restrictions.check.NonNull;

import pparser.EventHandler;
import pparser.Operator;

public class ASTBuilder implements EventHandler {

  private List<Predicate> predicates = new LinkedList<>();

  @Override
  public void onKeywordPredicate(String operation, Object arg0, Object arg1, Object arg2) {
    predicates.add(new KeywordPredicate(operation, arg0, arg1, arg2));
  }

  @Override
  public void onOperatorPredicate(@NonNull Operator operation, @NonNull Object arg0, @NonNull Object arg1) {
    predicates.add(new OperatorPredicate(operation, arg0, arg1));
  }

  public List<Predicate> build() {
    return predicates;
  }

}
