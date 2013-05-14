package pparser.ast;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import net.sf.staccatocommons.restrictions.check.NonNull;
import pparser.EventHandler;
import pparser.Operator;
import pparser.value.Path;

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
  private Queue<ASTElement> elements = Collections.asLifoQueue(new LinkedList<ASTElement>());

  @Override
  public void keywordPredicate(String operation, int arity) {
    elements.add(new KeywordPredicate(operation, Collections.unmodifiableList(dequeue(arity))));
  }

  @Override
  public void operatorPredicate(@NonNull Operator operation) {
    List<ASTElement> args = dequeue(2);
    elements.add(new OperatorPredicate(operation, args.get(0), args.get(1)));
  }
  
  @Override
  public void idPredicate() {
    elements.add(new IdPredicate(elements.remove()));
  }

  public ASTElement build() {
    return elements.element();
  }

  @Override
  public void orPredicate() {
    List<ASTElement> args = dequeue(2);
    elements.add(new OrPredicate(args.get(0), args.get(1)));
  }

  @Override
  public void andPredicate() {
    List<ASTElement> args = dequeue(2);
    elements.add(new AndPredicate(args.get(0), args.get(1)));
  }
  
  @Override
  public void listExpression(int size) {
    // TODO Auto-generated method stub
  }
  
  @Override
  public void numberExpression(Object number) {
    //cast ensured by ValuesFactoryImpl
    elements.add(new NumberExpression((BigDecimal) number));
  }
  
  @Override
  public void operatorExpression(String operator) {
    // TODO Auto-generated method stub
  }
  
  @Override
  public void pathExpression(Object path) {
    //cast ensured by ValuesFactoryImpl
    elements.add((Path) path);
  }
  
  @Override
  public void stringExpression(Object string) {
    //cast ensured by ValuesFactoryImpl
    elements.add(new StringExpression((String) string));
  }
  
  protected List<ASTElement> dequeue(int n) {
    LinkedList<ASTElement> list = new LinkedList<ASTElement>();
    Queue<ASTElement> dequeuedElements = Collections.asLifoQueue(list);
    for (int i = 0; i < n; i++)
      dequeuedElements.add(elements.remove());
    return list;
  }

}
