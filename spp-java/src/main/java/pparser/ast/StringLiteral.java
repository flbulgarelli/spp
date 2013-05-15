package pparser.ast;

public class StringLiteral extends LiteralExpression<String> {

  public StringLiteral(String arg0) {
    super(arg0);
  }

  @Override
  public <T> T accept(ASTElementVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
