package pparser;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringParsingTest {

  @Test
  public void parseString() throws Exception {
    assertEquals(PredicateParser.parseString("\"foo\""), "foo");
  }
}
