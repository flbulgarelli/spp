package pparser;

/**
 * Null implementation of {@link EventHandler}, that simply does nothing when a
 * predicate detection event occurs.
 * 
 * @author flbulgarelli
 */
public class NullEventHandler implements EventHandler {

  @Override
  public void keywordPredicate(String operation, int arity) {
  }

  @Override
  public void operatorPredicate(PredicateOperator operation) {
  }

  @Override
  public void orPredicate() {
  }

  @Override
  public void andPredicate() {
  }

  @Override
  public void idPredicate() {
  }

  @Override
  public void listExpression(int size) {
  }

  @Override
  public void numberExpression(Object number) {
  }

  @Override
  public void operatorExpression(ExpressionOperator operator) {
  }

  @Override
  public void stringExpression(Object string) {
  }
  
  @Override
  public void pathExpression(Object path) {
    
  }

}
