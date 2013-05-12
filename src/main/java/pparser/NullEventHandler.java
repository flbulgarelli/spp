package pparser;

import net.sf.staccatocommons.restrictions.check.NonNull;

public class NullEventHandler implements EventHandler {

  @Override
  public void keywordPredicate(String operation, Object arg0, Object arg1, Object arg2) {
  }

  @Override
  public void operatorPredicate(@NonNull Operator operation, @NonNull Object arg0, @NonNull Object arg1) {

  }

  @Override
  public void orPredicate() {
  }

  @Override
  public void andPredicate() {
  }

}
