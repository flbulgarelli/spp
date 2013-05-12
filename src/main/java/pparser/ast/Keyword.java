package pparser.ast;

import net.sf.staccatocommons.lang.value.RelevantState;
import net.sf.staccatocommons.restrictions.check.NonNull;

public class Keyword implements Predicate {

  private static final RelevantState<Keyword> STATE = new RelevantState<Keyword>(4) {
    protected void collectState(@NonNull Keyword object, @NonNull RelevantState.StateCollector s) {
      s.add(object.operation).add(object.arg0).add(object.arg1).add(object.arg2);
    }
  };
  
  private String operation;
  private Object arg0;
  private Object arg1;
  private Object arg2;

  public Keyword(String operation, Object arg0, Object arg1, Object arg2) {
    this.operation = operation;
    this.arg0 = arg0;
    this.arg1 = arg1;
    this.arg2 = arg2;
  }

  public static Keyword from(String operation, Object... args) {
    return new Keyword(operation, getAtOrNull(0, args), getAtOrNull(1, args), getAtOrNull(2, args));
  }

  @SafeVarargs
  private static <T> T getAtOrNull(int index, T... elements) {
    return index < elements.length ? elements[index] : null;
  }

  @Override
  public int hashCode() {
    return STATE.hashCode(this);
  }

  @Override
  public boolean equals(Object other) {
    return STATE.equals(this, other);
  }

  @Override
  public String toString() {
    return STATE.toString(this);
  }
}
