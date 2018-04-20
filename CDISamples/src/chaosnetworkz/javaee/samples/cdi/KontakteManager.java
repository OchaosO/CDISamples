package chaosnetworkz.javaee.samples.cdi;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import chaosnetworkz.javaee.samples.cdi.interceptor.Logging;
import chaosnetworkz.javaee.samples.qualifier.Test;

//@RequestScoped //->Bei jedem Request wird eine neue Instanz erzeugt (die Java EE stellt hier einen Proxy bereit und dieser Proxy wird bei 
				//einem Inject erzeugt. Soll das Objekt dann verwendet werden entscheidet der Proxy abhängig vom Scope  ob eine neue Instanz erzeugt wird oder 
				//eine bestehende verwendet werden kann
@SessionScoped
//@Dependent -> Bei einem Aufruf bzw. Inject wird eine neue Instanz erzeugt (ACHTUNG: ohne Proxy, die erzeugte Instanz wird direkt an das aufrufende Objekt gebunden
				//) 
public class KontakteManager implements Serializable, KontakteHandler{

	//Kontakte Provider per CDI injizieren 
	//Per selbst definierten Qualifier @Test und Alternatives 
	//Je nachdem was benötigt wird
	@Inject @Test
	private KontakteProvider kontakteProvider;
	
	//Producer Injizieren, dass klappt hier ohne weitere Angaben,
	//da es im gesamten Projekt keine weitere Listen vom Typ String gibt die mit produces annotiert ist
	@Inject
	private List<String> kontakteNamen;
	
	@Inject
	private KontakteNamenList kontakteEvent;
	
	
	
	/* (non-Javadoc)
	 * @see chaosnetworkz.javaee.samples.cdi.KontakteHandler#getKontakteNamen()
	 */
	@Override //Interface für einen Dekorator
	@Logging //Einbinden des eigenen Logging Interceptors
	public List<String> getKontakteNamen() {
		return kontakteProvider.getKontakteNamen();
	}
	
	public List<String> getStandardKontakte() {
		return kontakteNamen;
	}
	
	public List<String> getKontakteEvent() {
		return kontakteEvent.getName();
	}
	

}
