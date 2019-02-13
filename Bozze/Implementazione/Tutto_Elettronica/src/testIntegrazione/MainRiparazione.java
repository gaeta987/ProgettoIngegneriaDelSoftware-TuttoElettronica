package testIntegrazione;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestDoSaveRiparazione.class,
	TestDoRetrieveAll.class,
	TestDoRetrieveAllRiparazioni.class,
	TestDoUpdateData.class,
	TestDoUpdateStato.class})
public class MainRiparazione {

}
