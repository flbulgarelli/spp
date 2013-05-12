package pparser;

import net.sf.staccatocommons.restrictions.check.NonNull;

public class NullEventHandler implements EventHandler {

  @Override
  public void onKeywordPredicate(String operation, Object arg0, Object arg1, Object arg2) {
  }

  @Override
  public void onOperatorPredicate(@NonNull String operation, @NonNull Object arg0, @NonNull Object arg1) {

  }

}
