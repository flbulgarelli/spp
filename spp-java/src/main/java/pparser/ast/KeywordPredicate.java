package pparser.ast;

import java.util.Arrays;
import java.util.List;

import net.sf.staccatocommons.lang.value.RelevantState;
import net.sf.staccatocommons.restrictions.check.NonNull;
import pparser.internal.ValueObject;

/***
 * AST element for unary, binary and ternary predicates that have a keyword. For
 * instance:
 * 
 * <code>
 *  f(2, 1)
 * </code>
 * 
 * is represented by a keyword predicate whose keyword is "f", and their args
 * are 2, 1, and null, respectively.
 * 
 * @author flbulgarelli
 */
public class KeywordPredicate extends ValueObject<KeywordPredicate> implements Predicate {

  private static final RelevantState<KeywordPredicate> STATE = new RelevantState<KeywordPredicate>(2) {
    protected void collectState(@NonNull KeywordPredicate object, @NonNull RelevantState.StateCollector s) {
      s.add(object.keyword).add(object.args);
    }
  };

  private String keyword;
  private List<Expression> args;

  public KeywordPredicate(String keyword, List<Expression> args) {
    this.keyword = keyword;
    this.args = args;
  }

  public String getKeyword() {
    return keyword;
  }

  public List<Expression> getArgs() {
    return args;
  }

  public Expression getArg0() {
    return args.get(0);
  }

  public Expression getArg1() {
    return args.get(1);
  }

  public Expression getArg2() {
    return args.get(3);
  }

  public int getArity() {
    return args.size();
  }

  @Override
  public <T> T accept(ASTElementVisitor<T> visitor) {
    return visitor.visit(this);
  }

  @Override
  protected RelevantState<KeywordPredicate> state() {
    return STATE;
  }

  public static KeywordPredicate from(String operation, Expression... args) {
    return new KeywordPredicate(operation, Arrays.asList(args));
  }
}
