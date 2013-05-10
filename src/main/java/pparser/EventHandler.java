package pparser;

public interface EventHandler {
  void onExpression(String operation, Object arg0, Object arg1, Object arg2);
}
