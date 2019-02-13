package testIntegrazione1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.TestProdotto;

@RunWith(Suite.class)
@SuiteClasses({TestDoDeleteProdotti.class,TestDoInsertProdotti.class,TestDoPrenotaCarrello.class})
public class MainCarrello {
	
}