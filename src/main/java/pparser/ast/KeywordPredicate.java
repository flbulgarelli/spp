package pparser.ast;

import pparser.internal.ValueObject;
import net.sf.staccatocommons.lang.value.RelevantState;
import net.sf.staccatocommons.restrictions.check.NonNull;

public class KeywordPredicate extends ValueObject<KeywordPredicate> implements Predicate {

  private static final RelevantState<KeywordPredicate> STATE = new RelevantState<KeywordPredicate>(4) {
    protected void collectState(@NonNull KeywordPredicate object, @NonNull RelevantState.StateCollector s) {
      s.add(object.keyword).add(object.arg0).add(object.arg1).add(object.arg2);
    }
  };

  private final String keyword;
  private final Object arg0;
  private final Object arg1;
  private final Object arg2;

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

  public String getKeyword() {
    return keyword;
  }

  public Object getArg0() {
    return arg0;
  }

  public Object getArg1() {
    return arg1;
  }

  public Object getArg2() {
    return arg2;
  }

  @Override
  protected RelevantState<KeywordPredicate> state() {
    return STATE;
  }

  public static KeywordPredicate from(String operation, Object... args) {
    return new KeywordPredicate(operation, getAtOrNull(0, args), getAtOrNull(1, args), getAtOrNull(2, args));
  }

  @SafeVarargs
  private static <T> T getAtOrNull(int index, T... elements) {
    return index < elements.length ? elements[index] : null;
  }
}
