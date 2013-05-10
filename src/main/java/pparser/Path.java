package pparser;

import java.util.List;

public class Path {

  private final List<String> routes;

  public Path(List<String> routes) {
    this.routes = routes;
  }

  public List<String> getRoutes() {
    return routes;
  }
}


