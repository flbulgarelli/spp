package pparser;

/**
 * Hook interface for {@link PredicateParser} predicate detection.
 * 
 * In order to listen to predicatate detection events produced by the
 * {@link PredicateParser}, any implementation of spp <strong>should</strong>
 * provide an implementation of this interface.
 * 
 * @author flbulgarelli
 */
public interface EventHandler {

  /**
   * Event that denotes that an n-ariy keyword predicate has been parsed, with 0
   * < n <= 3.
   * */
  void keywordPredicate(String operation, int arity);

  /**
   * Event that denotes that a binary operator predicate has been parsed.
   * 
   */
  void operatorPredicate(PredicateOperator operation);

  /**
   * Event that an OR predicate has been detected. This predicate performs the
   * disjunction of the last two parsed predicates
   */
  void orPredicate();

  /**
   * Event that an AND predicate has been detected. This predicate performs the
   * conjunction of the last two parsed predicates
   */
  void andPredicate();

  void idPredicate();

  void operatorExpression(ExpressionOperator operator);

  void stringExpression(Object string);

  void numberExpression(Object number);

  void pathExpression(Object path);

  void listExpression(int size);

}
