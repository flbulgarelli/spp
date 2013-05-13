package pparser;

import java.util.List;

public interface ValuesFactory {

  Object createString(String tokenImage);

  Object createNumber(String tokenImage);

  Object createPath(List<String> tokenImages);

}
