package pparser.value;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ValuesFactoryImplTest {

  @Test
  public void createString() throws Exception {
    assertEquals("foo", new ValuesFactoryImpl().createString("\"foo\""));
  }

  @Test
  public void createPath() throws Exception {
    assertEquals(Path.from("x", "y"), new ValuesFactoryImpl().createPath(Arrays.asList("x", "y")));
  }
}
