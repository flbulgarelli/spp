package pparser.ast;

/**
 * A Predicate AST element.
 * 
 * In order to remain client-agnostic, this interface does not define any
 * beheviour, since it should be plugged using {@link PredicateVisitor}s
 * 
 * @author flbulgarelli
 */
public interface Predicate {

  /**Executes a polymorphic operation over this {@link Predicate}*/
  <T> T accept(PredicateVisitor<T> visitor);

}
