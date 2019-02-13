package testUtente;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



@RunWith(Suite.class)
@SuiteClasses({TestDoDelete.class,
	TestDoRetrieveAll.class,
	TestDoRetrieveByCodiceFiscale.class,
	TestDoRetrieveByKey.class,
	TestDoRetrieveUtente.class,
	TestDoSave.class,
	TestDoSaveClienteRegistrato.class,
	TestDoUpdateCliente.class,
	TestDoUpdateDataGestore.class,
	TestDoUpdateEmail.class,
	TestDoUpdatePassword.class})
public class MainUtente {

}
