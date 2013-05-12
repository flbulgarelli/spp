package pparser.ast;

import net.sf.staccatocommons.lang.value.RelevantState;
import net.sf.staccatocommons.restrictions.check.NonNull;

public class KeywordPredicate implements Predicate {

  private static final RelevantState<KeywordPredicate> STATE = new RelevantState<KeywordPredicate>(4) {
    protected void collectState(@NonNull KeywordPredicate object, @NonNull RelevantState.StateCollector s) {
      s.add(object.keyword).add(object.arg0).add(object.arg1).add(object.arg2);
    }
  };

  private String keyword;
  private Object arg0;
  private Object arg1;
  private Object arg2;

  public KeywordPredicate(String keyword, Object arg0, Object arg1, Object arg2) {
    this.keyword = keyword;
    this.arg0 = arg0;
    this.arg1 = arg1;
    this.arg2 = arg2;
  }

  @Override
  public <T> T accept(PredicateVisitor<T> visitor) {
    return visitor.visit(this);
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

  public static KeywordPredicate from(String operation, Object... args) {
    return new KeywordPredicate(operation, getAtOrNull(0, args), getAtOrNull(1, args), getAtOrNull(2, args));
  }

  @SafeVarargs
  private static <T> T getAtOrNull(int index, T... elements) {
    return index < elements.length ? elements[index] : null;
  }
}
