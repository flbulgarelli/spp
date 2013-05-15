package pparser.ast;

import net.sf.staccatocommons.lang.value.RelevantState;
import net.sf.staccatocommons.restrictions.check.NonNull;
import pparser.internal.ValueObject;

public class IdPredicate extends ValueObject<IdPredicate> implements ASTElement {

  private static final RelevantState<IdPredicate> STATE = new RelevantState<IdPredicate>(1) {
    @Override
    protected void collectState(@NonNull IdPredicate object, @NonNull RelevantState.StateCollector s) {
      s.add(object.arg0);
    }
  };

  private final ASTElement arg0;

  public IdPredicate(ASTElement arg0) {
    this.arg0 = arg0;
  }

  @Override
  public <T> T accept(ASTElementVisitor<T> visitor) {
    return visitor.visit(this);
  }

  public ASTElement getArg0() {
    return arg0;
  }

  @Override
  protected RelevantState<IdPredicate> state() {
    return STATE;
  }

}
