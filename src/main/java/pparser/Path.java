package pparser;

import java.util.Arrays;
import java.util.List;

import pparser.internal.ValueObject;

import net.sf.staccatocommons.lang.value.RelevantState;
import net.sf.staccatocommons.restrictions.check.NonNull;

public class Path extends ValueObject<Path> {

  private static final RelevantState<Path> STATE = new RelevantState<Path>(1) {
    protected void collectState(@NonNull Path object, @NonNull RelevantState.StateCollector s) {
      s.add(object.routes);
    }
  };

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
  protected RelevantState<Path> state() {
    return STATE;
  }
}
