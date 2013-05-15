package pparser;

import static pparser.ast.dsl.DSL.*;

import org.junit.Test;

public class NumberTest extends AbstractParsingTest {
	
	@Test
	public void can_parse_number_expresion()  {
		assertParse("f(5)", KEYWORD("f", LIT(5)));
	}
	
	@Test
	public void can_parse_decimal_expresion()  {
		assertParse("f(5.5)", KEYWORD("f", LIT(5.5)));
	}
	
	@Test
	public void can_parse_two_decimal_expresion()  {
		assertParse("f(5.55)", KEYWORD("f", LIT(5.55)));
	}
	
	@Test(expected=RuntimeParseException.class)
	public void tryInvalidNumber() {
		PredicateParser.tryParse("f(5.5.)");
	}
	
	@Test(expected=RuntimeParseException.class)
	public void tryInvalidNumber2() {
		PredicateParser.tryParse("f(5.)");
	}
	
	@Test(expected=RuntimeParseException.class)
	public void tryInvalidNumber3() {
		PredicateParser.tryParse("f(.0)");
	}
}
