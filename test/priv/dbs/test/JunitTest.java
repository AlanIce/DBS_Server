package priv.dbs.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JunitTest {
	@Before
	public void Before() {
		System.out.println("Junit Test : Before");
	}
	
	@After
	public void After() {
		System.out.println("Junit Test : After");
	}
	
	@Test
	public void Test() {
		System.out.println("Junit Test : Hello World!");
	}
}
