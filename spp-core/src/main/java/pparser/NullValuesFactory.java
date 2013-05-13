package pparser;

import java.util.List;

public class NullValuesFactory implements ValuesFactory {

  @Override
  public Object createString(String tokenImage) {
    return null;
  }

  @Override
  public Object createNumber(String tokenImage) {
    return null;
  }

  @Override
  public Object createPath(List<String> tokenImages) {
    return null;
  }

}
