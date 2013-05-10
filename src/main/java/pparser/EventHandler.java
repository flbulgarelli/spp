package pparser;

public interface EventHandler {
  void onExpression(String operation, Path target, Object arg0, Object arg1);
}
