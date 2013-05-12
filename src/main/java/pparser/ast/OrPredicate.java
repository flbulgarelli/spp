package pparser.ast;

public class OrPredicate extends LogicalConnectorPredicate {

  public OrPredicate(Predicate arg0, Predicate arg1) {
    super(arg0, arg1);
  }

  @Override
  public <T> T accept(PredicateVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
