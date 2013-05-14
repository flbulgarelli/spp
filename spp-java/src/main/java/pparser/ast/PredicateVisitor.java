package pparser.ast;

/**
 * Visitor for a {@link Predicate}s AST
 * 
 * @author flbulgarelli
 * 
 * @param <T>
 *          the return type of the visitor
 * 
 * @see Visitor Pattern
 */
public interface PredicateVisitor<T> {

  T visit(KeywordPredicate predicate);

  T visit(OperatorPredicate predicate);

  T visit(AndPredicate andPredicate);

  T visit(OrPredicate orPredicate);

  T visit(IdPredicate idPredicate);
}
