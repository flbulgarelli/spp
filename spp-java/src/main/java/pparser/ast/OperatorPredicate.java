package pparser.ast;

import net.sf.staccatocommons.lang.value.RelevantState;
import net.sf.staccatocommons.restrictions.check.NonNull;
import pparser.Operator;
import pparser.internal.ValueObject;

public class OperatorPredicate extends ValueObject<OperatorPredicate> implements Predicate {

  private static final RelevantState<OperatorPredicate> STATE = new RelevantState<OperatorPredicate>(3) {
    protected void collectState(@NonNull OperatorPredicate object, @NonNull RelevantState.StateCollector s) {
      s.add(object.operator).add(object.arg0).add(object.arg1);
    }
  };

  private Operator operator;
  private Object arg0;
  private Object arg1;

  public OperatorPredicate(Operator operator, Object arg0, Object arg1) {
    this.operator = operator;
    this.arg0 = arg0;
    this.arg1 = arg1;
  }
  
  public Operator getOperator() {
    return operator;
  }
  
  public Object getArg0() {
    return arg0;
  }
  
  public Object getArg1() {
    return arg1;
  }
  
  @Override
  public <T> T accept(PredicateVisitor<T> visitor) {
    return visitor.visit(this);
  }

  @Override
  protected RelevantState<OperatorPredicate> state() {
    return STATE;
  }

}
