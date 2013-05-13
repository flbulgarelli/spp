package pparser.value;

import java.util.Arrays;
import java.util.List;

import net.sf.staccatocommons.collections.stream.Streams;

public final class Path {

  private final List<String> routes;

  public Path(List<String> routes) {
    this.routes = routes;
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

}
