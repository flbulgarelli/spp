package pparser;

public class DummyEventHandler implements EventHandler {

  @Override
  public void onExpression(String operation, Path target, Object arg0, Object arg1) {
    new Expression(operation, target, arg0, arg1);
  }

}
