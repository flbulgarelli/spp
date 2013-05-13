package pparser.value;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import pparser.ValuesFactory;

public class ValuesFactoryImpl implements ValuesFactory {

  @Override
  public String createString(String string) {
    return string.substring(1, string.length() - 1);
  }

  @Override
  public Object createNumber(String tokenImage) {
    return new BigDecimal(tokenImage);
  }

  /**
   * Creates a {@link Path} instance for the given routes
   */
  @Override
  public Object createPath(List<String> tokenImages) {
    return new Path(Collections.unmodifiableList(tokenImages));
  }

}
