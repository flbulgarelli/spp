package pparser.ast;

import net.sf.staccatocommons.lang.value.RelevantState;
import net.sf.staccatocommons.restrictions.check.NonNull;
import pparser.internal.ValueObject;

public class OrPredicate extends ValueObject<OrPredicate> implements Predicate {

  private static final RelevantState<OrPredicate> STATE = new RelevantState<OrPredicate>(2) {
    protected void collectState(@NonNull OrPredicate object, @NonNull RelevantState.StateCollector s) {
      s.add(object.p1).add(object.p2);
    }
  };
  private final Predicate p1;
  private final Predicate p2;

  public OrPredicate(Predicate p1, Predicate p2) {
    this.p1 = p1;
    this.p2 = p2;
  }

  @Override
  public <T> T accept(PredicateVisitor<T> visitor) {
    return visitor.visit(this);
  }

  @Override
  protected RelevantState<OrPredicate> state() {
    return STATE;
  }

}
