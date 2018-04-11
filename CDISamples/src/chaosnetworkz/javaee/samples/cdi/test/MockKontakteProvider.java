package chaosnetworkz.javaee.samples.cdi.test;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Alternative;

import chaosnetworkz.javaee.samples.cdi.KontakteProvider;
import chaosnetworkz.javaee.samples.qualifier.Test;

@Dependent
//Eigener Qualifier
@Test
//Bean ist als Alternative angelegt und kann in der Beans.xml aktiv gesetzt werden
//Alternativ können Altarnative Beans auch mit einer Poducer Methode verwenden werden
@Alternative
public class MockKontakteProvider extends KontakteProvider{

	@Override
	public List<String> getKontakteNamen() {
		
		ArrayList<String> namen = new ArrayList<String>();
		namen.add("Mock - Peter");
		namen.add("Mock - Hans");
		namen.add("Mock - Karl");
		return namen;
		
	}
}
