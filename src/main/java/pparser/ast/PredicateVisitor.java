package pparser.ast;


public interface PredicateVisitor<T> {

  T visit(KeywordPredicate predicate);

  T visit(OperatorPredicate predicate);

  T visit(AndPredicate andPredicate);

  T visit(OrPredicate orPredicate);
}
