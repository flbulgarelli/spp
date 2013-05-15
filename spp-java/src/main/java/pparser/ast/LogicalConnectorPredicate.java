package pparser.ast;

import net.sf.staccatocommons.lang.value.RelevantState;
import net.sf.staccatocommons.restrictions.check.NonNull;
import pparser.internal.ValueObject;

public abstract class LogicalConnectorPredicate //
  extends ValueObject<LogicalConnectorPredicate> implements Predicate {

  private static final RelevantState<LogicalConnectorPredicate> STATE = //
  new RelevantState<LogicalConnectorPredicate>(2) {
    protected void collectState(@NonNull LogicalConnectorPredicate object,
      @NonNull RelevantState.StateCollector s) {
      s.add(object.arg0).add(object.arg1);
    }
  };
  private final Predicate arg0;
  private final Predicate arg1;

  public LogicalConnectorPredicate(Predicate arg0, Predicate arg1) {
    this.arg0 = arg0;
    this.arg1 = arg1;
  }
  
  public Predicate getArg0() {
    return arg0;
  }
  
  public Predicate getArg1() {
    return arg1;
  }

  @Override
  protected RelevantState<LogicalConnectorPredicate> state() {
    return STATE;
  }
  
}
