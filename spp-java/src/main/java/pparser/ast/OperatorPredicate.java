package pparser.ast;

import net.sf.staccatocommons.lang.value.RelevantState;
import net.sf.staccatocommons.restrictions.check.NonNull;
import pparser.PredicateOperator;
import pparser.internal.ValueObject;

public class OperatorPredicate extends ValueObject<OperatorPredicate> implements Predicate {

  private static final RelevantState<OperatorPredicate> STATE = new RelevantState<OperatorPredicate>(3) {
    protected void collectState(@NonNull OperatorPredicate object, @NonNull RelevantState.StateCollector s) {
      s.add(object.operator).add(object.arg0).add(object.arg1);
    }
  };

  private PredicateOperator operator;
  private Expression arg0;
  private Expression arg1;

  public OperatorPredicate(PredicateOperator operator, Expression arg0, Expression arg1) {
    this.operator = operator;
    this.arg0 = arg0;
    this.arg1 = arg1;
  }
  
  public PredicateOperator getOperator() {
    return operator;
  }
  
  public Expression getArg0() {
    return arg0;
  }
  
  public Expression getArg1() {
    return arg1;
  }
  
  @Override
  public <T> T accept(ASTElementVisitor<T> visitor) {
    return visitor.visit(this);
  }

  @Override
  protected RelevantState<OperatorPredicate> state() {
    return STATE;
  }

}
