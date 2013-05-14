package pparser.ast;

import net.sf.staccatocommons.lang.value.RelevantState;
import net.sf.staccatocommons.restrictions.check.NonNull;
import pparser.internal.ValueObject;

public abstract class LiteralExpression<T> extends ValueObject<LiteralExpression<T>> implements ASTElement {
  
  @SuppressWarnings("rawtypes")
  private static final RelevantState<LiteralExpression> STATE = new RelevantState<LiteralExpression>(1) {
    @Override
    protected void collectState(@NonNull LiteralExpression object, @NonNull RelevantState.StateCollector s) {
      s.add(object.value);
    }
  };

  private final T value;

  public LiteralExpression(T arg0) {
    this.value = arg0;
  }

  public Object getValue() {
    return value;
  }

  @Override
  @SuppressWarnings({ "unchecked", "rawtypes" })
  protected RelevantState<LiteralExpression<T>> state() {
    return (RelevantState)STATE;
  }

}
