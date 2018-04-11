package chaosnetworkz.javaee.samples.cdi;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

import chaosnetworkz.javaee.samples.cdi.test.TestKontakteProvider;
import chaosnetworkz.javaee.samples.qualifier.Test;

@Dependent
public class KontakteProviderFactory {
	
	//Nutzung der Produces Annotation um Instanz des TestKontakteProviders zu erzeugen
	//und bei der erzeugung noch zu manipulieren
	//Per qualifier @Test wird dann der hier definierte TestKontakteProvider instanziert
	@Produces @Test
	public KontakteProvider getProvider() {
		TestKontakteProvider provider = new TestKontakteProvider();
		provider.getKontakteNamen().add("Test add per producer - Hansi");
		return provider;
	}

}
