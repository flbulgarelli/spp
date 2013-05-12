package pparser;

import java.util.LinkedList;
import java.util.List;

public class PathBuilder {

  private List<String> routes = new LinkedList<String>();

  public Path build() {
    return new Path(routes);
  }

  public void addRoute(String route) {
    routes.add(route);
  }

}
