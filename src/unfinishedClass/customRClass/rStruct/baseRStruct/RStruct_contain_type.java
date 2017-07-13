package unfinishedClass.customRClass.rStruct.baseRStruct;

import unfinishedClass.customRClass.rStruct.baseInterface.IRStruct_contain_type;
import unfinishedClass.customRClass.scriptBlock.information.InformationType;

/**
 * 包含类型的RStruct的父类，
 * 实现IRStruct_contain_type接口。
 */
public class RStruct_contain_type implements IRStruct_contain_type{
	/**
	 * RStruct的类型标签，
	 * 一般用于RClassStruct、RClassRefStruct、GPAssignStruct。
	 */
	protected InformationType type;
	
	/**
	 * 定义RStruct类型，
	 * 一般用于RClassStruct、RClassRefStruct、GPAssignStruct。
	 * @param type
	 * 		被指定的类型标签。
	 */
	@Override
	public void defineType(InformationType type) {
		this.type = type;
	}

}