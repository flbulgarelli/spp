package pparser;

public class Expression {

  private String operation;
  private Path target;
  private Object arg0;
  private Object arg1;

  public Expression(String operation, Path target, Object arg0, Object arg1) {
    this.operation = operation;
    this.target = target;
    this.arg0 = arg0;
    this.arg1 = arg1;
  }

}
