package pparser.ast;


public interface PredicateVisitor<T> {

  T visit(KeywordPredicate predicate);

  T visit(OperatorPredicate predicate);
}
