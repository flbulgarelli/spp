package pparser;

import net.sf.staccatocommons.restrictions.check.NonNull;

public interface EventHandler {
  
  void keywordPredicate(@NonNull String operation, Object arg0, Object arg1, Object arg2);

  void operatorPredicate(@NonNull Operator operation, @NonNull Object arg0, @NonNull Object arg1);

  void orPredicate();

  void andPredicate();

}
