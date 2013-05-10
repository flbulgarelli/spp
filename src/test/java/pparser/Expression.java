package pparser;

public class Expression {

  private String operation;
  private Object arg0;
  private Object arg1;
  private Object arg2;

  public Expression(String operation, Object arg0, Object arg1, Object arg2) {
    this.operation = operation;
    this.arg0 = arg0;
    this.arg1 = arg1;
    this.arg2 = arg2;
  }

}
