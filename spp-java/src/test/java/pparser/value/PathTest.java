package pparser.value;

import static org.junit.Assert.*;

import org.junit.Test;

import pparser.value.Path;

public class PathTest {

  @Test
  public void toStringOfPathIsRoutesJoined() {
    assertEquals("x.y", Path.from("x", "y").toString());
    assertEquals("x", Path.from("x").toString());
  }

  @Test
  public void isValueObject() throws Exception {
    assertEquals(Path.from("x", "y"), Path.from("x", "y"));
  }

}
