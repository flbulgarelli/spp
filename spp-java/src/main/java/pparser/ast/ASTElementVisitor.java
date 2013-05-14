package pparser.ast;

import pparser.value.Path;

/**
 * Visitor for a {@link ASTElement}s AST
 * 
 * @author flbulgarelli
 * 
 * @param <T>
 *          the return type of the visitor
 * 
 * @see Visitor Pattern
 */
public interface ASTElementVisitor<T> {

  T visit(KeywordPredicate predicate);

  T visit(OperatorPredicate predicate);

  T visit(AndPredicate andPredicate);

  T visit(OrPredicate orPredicate);

  T visit(IdPredicate idPredicate);

  T visit(Path path);

  T visit(NumberExpression numberExpression);

  T visit(StringExpression stringExpression);
}
