package unfinishedClass.basicRClass;

import rClass.AbstractRClassForJava;
import rClass.RReference;
import rClassInterface.IRClass;
import rClassInterface.IRReference;

public class RShort extends AbstractRClassForJava implements IRClass {

	public RShort(){
		super("Short");
	}
	
	@Override
	public IRReference getNewInstance() {
		IRReference newInstance = new RReference();
		newInstance.mallocSpace(1);
		newInstance.writeObject(new Short((short)0), "Short");
		return newInstance;
	}

}
