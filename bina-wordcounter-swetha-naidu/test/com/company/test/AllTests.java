package com.company.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/*
 * This is a test suite that has all the test-cases.
 * Running the AllTests file is sufficient to check if all the test-cases are passing.
 */
@RunWith(Suite.class)
@SuiteClasses({ WordCounter_getwordcounttests.class,
		WordCounter_settergettertests.class,
		WordCounter_specialcharacterstest.class })
public class AllTests {

}
