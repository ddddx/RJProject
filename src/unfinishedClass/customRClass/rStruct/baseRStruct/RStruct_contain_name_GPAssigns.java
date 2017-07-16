package unfinishedClass.customRClass.rStruct.baseRStruct;

import unfinishedClass.customRClass.rStruct.GPAssignStruct;
import unfinishedClass.customRClass.rStruct.RSet;
import unfinishedClass.customRClass.rStruct.baseInterface.IRStruct_contain_GPAssigns;

/**
 * 包含泛参指配和名字的RStruct父类。
 */
public abstract class RStruct_contain_name_GPAssigns
	extends RStruct_contain_name 
	implements IRStruct_contain_GPAssigns {
	
	/**
	 * 泛参指配集合。
	 */
	protected RSet<GPAssignStruct> gpaSet;
	
	/**
	 * @throws NameConflictionException
	 * 		定义冲突的泛参名泛参指配时，抛出此异常。
	 */
	@Override
	public void defineGPAssigns_by_RSet(RSet<GPAssignStruct> gpaSet) {
		if (gpaSet == null) {
			throw new IllegalArgumentException("通过集合来指配泛参具体类型时，传入的参数为null。");
		}
		
		for (GPAssignStruct gpaStruct : gpaSet) {
			defineGPAssign(gpaStruct);
		}
	}
	
	/**
	 * @throws NameConflictionException
	 * 		定义冲突的泛参名泛参指配时，抛出此异常。
	 */
	@Override
	public void defineGPAssign(GPAssignStruct gpaStruct) {
		if (gpaStruct == null) {
			throw new IllegalArgumentException("不能使用null来指配泛参具体类型。");
		}
		
		//TODO 在这里对泛参指配的目标泛参名进行检查，
		//如果发生冲突，就要抛出NameConflictionException。
		
		gpaSet.add(gpaStruct);
	}
}