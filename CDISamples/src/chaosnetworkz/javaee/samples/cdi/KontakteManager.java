package chaosnetworkz.javaee.samples.cdi;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import chaosnetworkz.javaee.samples.qualifier.Test;

@Dependent
public class KontakteManager {

	//Kontakte Provider per CDI injizieren 
	//per selbst definierten Qualifier @TEST und Alternatives 
	//Je nachdem was benötigt wird
	@Inject @Test
	private KontakteProvider kontakteProvider;
	
	//Producer Injizieren, dass klappt ohne weitere angaben,
	//da es im gesamten Projekt keine weitere Liste vom Typ String gibt
	//die mit produces annotiert ist
	@Inject
	private List<String> kontakteNamen;
	
	public List<String> getKontakteNamen() {
		return kontakteProvider.getKontakteNamen();
	}

}
