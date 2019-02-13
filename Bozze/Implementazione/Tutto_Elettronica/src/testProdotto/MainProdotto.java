package testProdotto;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testIntegrazione.TestDoSave;

@RunWith(Suite.class)
@SuiteClasses({TestDoDelete.class,
	TestDoRetrieveAll.class,
	TestDoRetrieveByKey.class,
	TestDoRetrieveCategoria.class,
	TestDoRetrieveOnSale.class,
	TestDoSaveInMagazzino.class,
	TestDoUpdatePrezzo.class,
	TestDoUpdatePromoAdd.class,
	TestDoUpdateQuantita.class,
	TestDoUpdateQuantitaNelCarrello.class})
public class MainProdotto {

}
