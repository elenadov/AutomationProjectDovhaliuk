package suites;

import dealTest.DealTest;
import loginTest.SmokeValidLoginTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import providersTest.PrivateProviderCreationTest;
import spareTest.SpareTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                SmokeValidLoginTest.class,
                SpareTest.class,
                DealTest.class,
                PrivateProviderCreationTest.class
        }
)

public class SmokeSuites {
}
