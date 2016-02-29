import org.junit.runners.Suite;
import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	RegisterTest.class,
	StatisticsTest.class,
	TermsTest.class,
	NewestThreadTest.class
})
public class SeleniumSuite{
	
}