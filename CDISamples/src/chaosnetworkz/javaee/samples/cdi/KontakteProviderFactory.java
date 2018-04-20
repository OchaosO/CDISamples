package chaosnetworkz.javaee.samples.cdi;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

import chaosnetworkz.javaee.samples.cdi.test.MockKontakteProvider;
import chaosnetworkz.javaee.samples.qualifier.Test;

@Dependent
public class KontakteProviderFactory {
	
	//Nutzung der Produces Annotation um Instanz des TestKontakteProviders zu erzeugen (@Test)
	//Vorteil: Manipulation bei dem Erzeugen möglich
	//Auch hier kann ein Scope angegeben werden z.b.: SessionScope
	//Damit wird die in der Factory Methode erzeugte Komponente nicht direkt erstellt sondern es wird 
	//hier auch ein Proxy angelegt
	@Produces @Test
	public KontakteProvider getProvider() {
		MockKontakteProvider provider = new MockKontakteProvider();
		
		provider.getKontakteNamen().add("Add Mock from Provider - KarlHeinz");
		
		final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		provider.getKontakteNamen().add( format.format(new Date()) );
		
		return provider;
	}
	


}
