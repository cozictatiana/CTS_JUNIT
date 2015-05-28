package teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Suita.class, TestCriptare.class, TestDAO.class,
		TestEmail.class, TestGrafic.class, TestManager.class,
		TestStatistica.class })
public class AllTests {

}
