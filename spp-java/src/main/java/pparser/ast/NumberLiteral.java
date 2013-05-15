package pparser.ast;

import java.math.BigDecimal;

public class NumberLiteral extends LiteralExpression<BigDecimal> {

  public NumberLiteral(BigDecimal arg0) {
    super(arg0);
  }

  @Override
  public <T> T accept(ASTElementVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
