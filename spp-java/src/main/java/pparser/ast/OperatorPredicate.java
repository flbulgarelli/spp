package pparser.ast;

import net.sf.staccatocommons.lang.value.RelevantState;
import net.sf.staccatocommons.restrictions.check.NonNull;
import pparser.Operator;
import pparser.internal.ValueObject;

public class OperatorPredicate extends ValueObject<OperatorPredicate> implements Predicate {

  private static final RelevantState<OperatorPredicate> STATE = new RelevantState<OperatorPredicate>(3) {
    protected void collectState(@NonNull OperatorPredicate object, @NonNull RelevantState.StateCollector s) {
      s.add(object.eq).add(object.arg0).add(object.arg1);
    }
  };

  private Operator eq;
  private Object arg0;
  private Object arg1;

  public OperatorPredicate(Operator eq, Object arg0, Object arg1) {
    this.eq = eq;
    this.arg0 = arg0;
    this.arg1 = arg1;
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
