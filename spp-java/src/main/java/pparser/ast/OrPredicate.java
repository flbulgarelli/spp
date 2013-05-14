package pparser.ast;

public class OrPredicate extends LogicalConnectorPredicate {

  public OrPredicate(ASTElement arg0, ASTElement arg1) {
    super(arg0, arg1);
  }

  @Override
  public <T> T accept(ASTElementVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
