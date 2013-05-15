package pparser.ast;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import net.sf.staccatocommons.restrictions.check.NonNull;
import pparser.EventHandler;
import pparser.ExpressionOperator;
import pparser.PredicateOperator;

/**
 * {@link EventHandler} that builds and Abstract Syntax Tree of the pedicates
 * expression.
 * 
 * @author flbulgarelli
 */
public class ASTBuilder implements EventHandler {

  /**
   * The implementation of this builder is based on a lifo queue - each
   * predicate parsed is enqueued, and dequeued when a logical connector is
   * detected.
   */
  private Queue<ASTElement> elements = Collections.asLifoQueue(new LinkedList<ASTElement>());

  @Override
  public void keywordPredicate(String operation, int arity) {
    pushElement(new KeywordPredicate(operation, Collections.unmodifiableList(dequeue(arity))));
  }

  @Override
  public void operatorPredicate(@NonNull PredicateOperator operation) {
    List<ASTElement> args = dequeue(2);
    pushElement(new OperatorPredicate(operation, args.get(0), args.get(1)));
  }

  @Override
  public void idPredicate() {
    pushElement(new IdPredicate(elements.remove()));
  }

  @Override
  public void orPredicate() {
    List<ASTElement> args = dequeue(2);
    pushElement(new OrPredicate(args.get(0), args.get(1)));
  }

  @Override
  public void andPredicate() {
    List<ASTElement> args = dequeue(2);
    pushElement(new AndPredicate(args.get(0), args.get(1)));
  }

  @Override
  public void listExpression(int size) {
    // TODO Auto-generated method stub
  }

  @Override
  public void numberExpression(Object number) {
    // cast ensured by ValuesFactoryImpl
    pushElement(new NumberExpression((BigDecimal) number));
  }

  @Override
  public void operatorExpression(ExpressionOperator operator) {
    List<ASTElement> args = dequeue(2);
    pushElement(new OperatorExpression(operator, (Expression) args.get(0), (Expression) args.get(1)));
  }

  @Override
  public void pathExpression(Object path) {
    // cast ensured by ValuesFactoryImpl
    pushElement((Path) path);
  }

  @Override
  public void stringExpression(Object string) {
    // cast ensured by ValuesFactoryImpl
    pushElement(new StringExpression((String) string));
  }

  protected void pushElement(ASTElement expression) {
    elements.add(expression);
  }

  public ASTElement build() {
    return elements.element();
  }

  protected List<ASTElement> dequeue(int n) {
    LinkedList<ASTElement> list = new LinkedList<ASTElement>();
    Queue<ASTElement> dequeuedElements = Collections.asLifoQueue(list);
    for (int i = 0; i < n; i++)
      dequeuedElements.add(elements.remove());
    return list;
  }

}
