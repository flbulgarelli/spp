package pparser;

public class DummyEventHandler implements EventHandler {
  
  @Override
  public void onExpression(String operation, Object arg0, Object arg1, Object arg2) {
    new Expression(operation, arg0, arg1, arg2);
  }


}
