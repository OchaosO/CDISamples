package chaosnetworkz.javaee.samples.cdi.test;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Alternative;

import chaosnetworkz.javaee.samples.cdi.KontakteProvider;
import chaosnetworkz.javaee.samples.qualifier.Test;

@Dependent
//Eigener Qualifier
@Test
//Bean ist als Alternative angelegt und kann in der beans.xml aktiv gesetzt werden
//Alternativen können auch mit einer Producer Methode verwenden werden (siehe KontakteProviderFactory)
@Alternative
public class MockKontakteProvider extends KontakteProvider implements Serializable{
	
	private final List<String> mockKontakteNamen;
	
	public MockKontakteProvider() {
		mockKontakteNamen = new ArrayList<String>( Arrays.asList( new String[] {"Mock - Peter","Mock - Peter","Mock - Peter" } )); 
	}
	
	@Override
	public List<String> getKontakteNamen() {

		return mockKontakteNamen;
		
		
		
	}
}
