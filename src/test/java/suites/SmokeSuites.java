package suites;

import dealTest.DealTest;
import loginTest.SmokeValidLoginTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import spareTest.SpareTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                SmokeValidLoginTest.class,
                SpareTest.class,
                DealTest.class
        }
)

public class SmokeSuites {
}
