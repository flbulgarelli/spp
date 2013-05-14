package pparser.ast;

import net.sf.staccatocommons.lang.value.RelevantState;
import net.sf.staccatocommons.restrictions.check.NonNull;
import pparser.internal.ValueObject;

public abstract class LogicalConnectorPredicate //
  extends ValueObject<LogicalConnectorPredicate> implements ASTElement {

  private static final RelevantState<LogicalConnectorPredicate> STATE = //
  new RelevantState<LogicalConnectorPredicate>(2) {
    protected void collectState(@NonNull LogicalConnectorPredicate object,
      @NonNull RelevantState.StateCollector s) {
      s.add(object.arg0).add(object.arg1);
    }
  };
  private final ASTElement arg0;
  private final ASTElement arg1;

  public LogicalConnectorPredicate(ASTElement arg0, ASTElement arg1) {
    this.arg0 = arg0;
    this.arg1 = arg1;
  }
  
  public ASTElement getArg0() {
    return arg0;
  }
  
  public ASTElement getArg1() {
    return arg1;
  }

  @Override
  protected RelevantState<LogicalConnectorPredicate> state() {
    return STATE;
  }
  
}
