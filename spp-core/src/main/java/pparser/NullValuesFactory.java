package pparser;

import java.util.List;

/**
 * Null object implementation for {@link ValuesFactory}, that simply returns
 * null for all its factory methods.
 * 
 * Only useful for implementing {@link PredicateParser#tryParse(String)}
 * 
 * @author flbulgarelli
 * */
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
