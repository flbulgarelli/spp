package pparser.ast;


public class AndPredicate extends LogicalConnectorPredicate {

  public AndPredicate(ASTElement arg0, ASTElement arg1) {
    super(arg0, arg1);
  }

  @Override
  public <T> T accept(ASTElementVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
