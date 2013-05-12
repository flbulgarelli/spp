package pparser.internal;

import net.sf.staccatocommons.lang.value.RelevantState;

@SuppressWarnings("unchecked")
public abstract class ValueObject<A> {

  @Override
  public int hashCode() {
    return state().hashCode((A) this);
  }

  @Override
  public boolean equals(Object other) {
    return state().equals((A) this, other);
  }

  @Override
  public String toString() {
    return state().toString((A) this);
  }

  protected abstract RelevantState<A> state();
}
