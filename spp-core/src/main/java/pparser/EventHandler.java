package pparser;

public interface EventHandler {

  void keywordPredicate(String operation, Object arg0, Object arg1, Object arg2);

  void operatorPredicate(Operator operation, Object arg0, Object arg1);

  void orPredicate();

  void andPredicate();

}
