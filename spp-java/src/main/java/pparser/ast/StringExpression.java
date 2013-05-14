package pparser.ast;

public class StringExpression extends LiteralExpression<String> {

  public StringExpression(String arg0) {
    super(arg0);
  }

  @Override
  public <T> T accept(ASTElementVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
