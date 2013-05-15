package pparser.ast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import pparser.value.ValuesFactoryImpl;

import net.sf.staccatocommons.collections.stream.Streams;

/**
 * A sequence of routes that point to a variable in a predicate expression.
 * 
 * It is created by the {@link ValuesFactoryImpl}
 * 
 * @author flbulgarelli
 */
public final class Path implements Expression {

  private final List<String> routes;

  public Path(List<String> routes) {
    this.routes = Collections.unmodifiableList(routes);
  }

  public List<String> getRoutes() {
    return routes;
  }

  public static Path from(String... routes) {
    return new Path(Arrays.asList(routes));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((routes == null) ? 0 : routes.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Path other = (Path) obj;
    if (routes == null) {
      if (other.routes != null) return false;
    } else if (!routes.equals(other.routes)) return false;
    return true;
  }

  @Override
  public String toString() {
    return Streams.from(routes).joinStrings(".");
  }

  @Override
  public <T> T accept(ASTElementVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
