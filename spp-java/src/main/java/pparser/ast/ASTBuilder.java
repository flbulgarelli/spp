package pparser.ast;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import net.sf.staccatocommons.restrictions.check.NonNull;
import pparser.EventHandler;
import pparser.Operator;

/**
 * {@link EventHandler} that builds and Abstract Syntax Tree of the pedicates
 * expression.
 * 
 * @author flbulgarelli
 */
public class ASTBuilder implements EventHandler {

  /**
   * The implementation of this builder is based on a lifo queue - each predicate parsed
   * is enqueued, and dequeued when a logical connector is detected. 
   */
  private Queue<Predicate> predicates = Collections.asLifoQueue(new LinkedList<Predicate>());

  @Override
  public void keywordPredicate(String operation, Object arg0, Object arg1, Object arg2) {
    predicates.add(new KeywordPredicate(operation, arg0, arg1, arg2));
  }

  @Override
  public void operatorPredicate(@NonNull Operator operation, @NonNull Object arg0, @NonNull Object arg1) {
    predicates.add(new OperatorPredicate(operation, arg0, arg1));
  }

  public Predicate build() {
    return predicates.element();
  }

  @Override
  public void orPredicate() {
    Predicate secondArgument = predicates.remove();
    Predicate firstArgument = predicates.remove();
    predicates.add(new OrPredicate(firstArgument, secondArgument));
  }

  @Override
  public void andPredicate() {
    Predicate secondArgument = predicates.remove();
    Predicate firstArgument = predicates.remove();
    predicates.add(new AndPredicate(firstArgument, secondArgument));
  }

}
