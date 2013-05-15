package pparser.ast;

public class AndPredicate extends LogicalConnectorPredicate {

  public AndPredicate(Predicate arg0, Predicate arg1) {
    super(arg0, arg1);
  }

  @Override
  public <T> T accept(ASTElementVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
