package chaosnetworkz.javaee.samples.qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Qualifier
//Wo ist der Qualifier für Java Sichtbar
@Retention(RetentionPolicy.RUNTIME)
//Wo kann der Qulifier verwendet werden
@Target({ElementType.CONSTRUCTOR,
		ElementType.FIELD,
		ElementType.TYPE,
		ElementType.METHOD
		})
public @interface Test {

}
