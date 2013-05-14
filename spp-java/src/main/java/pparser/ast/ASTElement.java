package pparser.ast;

/**
 * A Predicate AST element.
 * 
 * In order to remain client-agnostic, this interface does not define any
 * beheviour, since it should be plugged using {@link ASTElementVisitor}s
 * 
 * @author flbulgarelli
 */
public interface ASTElement {

  /**Executes a polymorphic operation over this {@link ASTElement}*/
  <T> T accept(ASTElementVisitor<T> visitor);

}
