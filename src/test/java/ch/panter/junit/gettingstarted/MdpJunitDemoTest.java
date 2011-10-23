package ch.panter.junit.gettingstarted;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// -------------- static imports ----------------
import static org.junit.Assert.*;

public class MdpJunitDemoTest {

    private String instance;

    @Before
    public void init() {
        this.instance = "JuNiT4";
    }

    @After
    public void clear() {
        this.instance = null;
    }

    @Test
	public void isEmptyTest() {
    	MdpJunitDemo jUnitDemo = new MdpJunitDemo();
		if (instance == null || instance.length() == 0) {
			assertTrue(jUnitDemo.isEmpty(instance));
		} else {
			assertFalse(jUnitDemo.isEmpty(instance));
		}
	}

    @Test
    public void capitalizeTest() {
    	isEmptyTest();

    	MdpJunitDemo jUnitDemo = new MdpJunitDemo();
    	instance = jUnitDemo.capitalize(instance);
    	char[] chars = instance.toCharArray();
    	for (int i = 0; i < chars.length; i++) {
    		if (Character.getType(chars[i]) != Character.UPPERCASE_LETTER) {
    			continue;
    		}
			if (i == 0) {
				assertTrue(Character.isUpperCase(chars[i]));
			} else {
				assertTrue(Character.isLowerCase(chars[i]));
			}
		}

    	System.out.println("===========================");
    	System.out.println("Capitalize-Test:");
    	System.out.println("===========================");
    	System.out.println(instance);
    }

    @Test
    public void reverseTest() {
    	isEmptyTest();

    	MdpJunitDemo jUnitDemo = new MdpJunitDemo();
    	String orig = new String(instance);
    	char[] origChars = orig.toCharArray();

    	instance = jUnitDemo.reverse(instance);
    	char[] chars = instance.toCharArray();
    	for (int i = 0; i < chars.length; i++) {
    		if (Character.getType(chars[i]) != Character.UPPERCASE_LETTER) {
    			continue;
    		}
    		if (Character.isUpperCase(chars[i])) {
    			assertTrue(Character.isLowerCase(origChars[i]));
    		} else {
    			assertTrue(Character.isUpperCase(origChars[i]));
    		}
    	}

    	System.out.println("===========================");
    	System.out.println("Reverse-Test:");
    	System.out.println("===========================");
    	System.out.println("Modified: " + instance);
    	System.out.println("Orig: " + orig);
    }

    @Test
    public void joinTest() {
    	String s1 = "abcde";
    	String s2 = "defgh";
    	String s3 = "ghijk";

    	MdpJunitDemo jUnitDemo = new MdpJunitDemo();
    	String result = jUnitDemo.join(s1, s2, s3);

    	isEmptyTest();
    	// First String
    	assertEquals(result.substring(0, s1.length()), s1);
    	whitespaceTest(result.substring(s1.length(), s1.length()+1));

    	// Second String
    	assertEquals(result.substring(s1.length()+1, s1.length()+1 + s2.length()), s2);
    	whitespaceTest(result.substring(s1.length() + s2.length() + 1, s1.length()+1 + s2.length()+1));

    	// Third String
    	assertEquals(result.substring(s1.length()+1 + s2.length()+1, s1.length()+1 + s2.length()+1 + s3.length()), s3);
    	// no more whitespaces after last string

    	System.out.println("===========================");
    	System.out.println("Join-Test:");
    	System.out.println("===========================");
    	System.out.println(result);
    }

    private void whitespaceTest(String s) {
    	assertEquals(s, " ");
    }
}
