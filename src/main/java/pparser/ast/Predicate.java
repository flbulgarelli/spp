package pparser.ast;

public interface Predicate {
  
  <T> T accept(PredicateVisitor<T> visitor);

}
