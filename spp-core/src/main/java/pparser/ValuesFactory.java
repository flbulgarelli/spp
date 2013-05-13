package pparser;

import java.util.List;

/**
 * Factory for values that are created by the {@link PredicateParser}.
 * 
 * Any implementor of spp <strong>must</strong> provide an implementation of
 * this interface.
 * 
 * @author flbulgarelli
 */
public interface ValuesFactory {

  /**
   * Creates a number string for the given token image.
   * 
   * For example, given the string. <code>"\"hello\""</code>, it should return a
   * numeric representation of the string <code>"hello"</code>.
   */
  Object createString(String tokenImage);

  /**
   * Creates a number object for the given token image.
   * 
   * For example, given the string. <code>"1"</code>, it should return a numeric
   * representation of the number <code>1</code>
   */
  Object createNumber(String tokenImage);

  /**
   * Creates a path object for the given routes token images
   */
  Object createPath(List<String> tokenImages);

}
