package pparser;

/**
 * Null implementation of {@link EventHandler}, that simply does nothing when a
 * predicate detection event occurs.
 * 
 * @author flbulgarelli
 */
public class NullEventHandler implements EventHandler {

  @Override
  public void keywordPredicate(String operation, Object arg0, Object arg1, Object arg2) {
  }

  @Override
  public void operatorPredicate(Operator operation, Object arg0, Object arg1) {

  }

  @Override
  public void orPredicate() {
  }

  @Override
  public void andPredicate() {
  }

}
