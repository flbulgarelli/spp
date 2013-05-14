package pparser.ast;

import java.math.BigDecimal;

public class NumberExpression extends LiteralExpression<BigDecimal> {

  public NumberExpression(BigDecimal arg0) {
    super(arg0);
  }

  @Override
  public <T> T accept(ASTElementVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
