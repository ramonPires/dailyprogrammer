package br.com.ramon.datedillema;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Arrays;
import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class DateParserTest {

	private String input;

    private String expected;

	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { "2/13/15","2015-02-13"},
                 { "1-31-10","2010-01-31"},
                 { "5 10 2015","2015-05-10"},
                 { "2012 3 17", "2012-03-17"},
                 { "2001-01-01", "2001-01-01"},
                 { "2008/01/07", "2008-01-07"}
        });
    }

    public DateParserTest(String input, String expected){
    	this.input = input;
    	this.expected = expected;
    }

	@Test
	public void testParseDate(){
		DateParser parser = new DateParser();
		assertEquals(expected,parser.parse(input));
	}
}