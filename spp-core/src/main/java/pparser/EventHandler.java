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
   * Event that denotes that an n-ariy keyword predicate has been parsed.
   * 
   * Only keyword predicates of up to 3 arguments are supported.
   * 
   * If the predicate has less than 3 arguments, the remaning arguments are
   * passed as <code>null</code>
   * */
  void keywordPredicate(String operation, Object arg0, Object arg1, Object arg2);

  /**
   * Event that denotes that a binary operator predicate has been parsed.
   * 
   * Both args are not null
   */
  void operatorPredicate(Operator operation, Object arg0, Object arg1);

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

  void idPredicate(Object arg0);

}
