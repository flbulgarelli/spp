package pparser.ast;

import net.sf.staccatocommons.lang.value.RelevantState;
import pparser.ExpressionOperator;
import pparser.internal.ValueObject;

public class OperatorExpression extends ValueObject<OperatorExpression> implements Expression {

  private static final RelevantState<OperatorExpression> STATE = new RelevantState<OperatorExpression>(3) {
    protected void collectState(OperatorExpression object, RelevantState.StateCollector s) {
      s.add(object.operator).add(object.arg0).add(object.arg1);
    }
  };

  private final ExpressionOperator operator;
  private final Expression arg0;
  private final Expression arg1;

  public OperatorExpression(ExpressionOperator operator, Expression arg0, Expression arg1) {
    this.operator = operator;
    this.arg0 = arg0;
    this.arg1 = arg1;
  }

  @Override
  public <T> T accept(ASTElementVisitor<T> visitor) {
    return visitor.visit(this);
  }

  @Override
  protected RelevantState<OperatorExpression> state() {
    return STATE;
  }

}
