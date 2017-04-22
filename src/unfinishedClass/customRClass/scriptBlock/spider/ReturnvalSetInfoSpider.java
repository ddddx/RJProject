package unfinishedClass.customRClass.scriptBlock.spider;

import unfinishedClass.customRClass.scriptBlock.ScriptBlock;
import unfinishedClass.customRClass.scriptBlock.information.Information;

public class ReturnvalSetInfoSpider extends AbstractBCSpider {
	protected ReturnvalSetStruct returnvalSetStruct;
	
	public ReturnvalSetInfoSpider(ScriptBlock targetBlock) {
		super(targetBlock);
		returnvalSetStruct = new ReturnvalSetStruct();
	}

	@Override
	protected void dealWithTargetBlock() {
		Information information = targetBlock.getInformation();
		switch(information.getType()){
		case RETURNVAL:
			returnvalSetStruct
				.addReturnvalStruct(information.getOriginalString());
			break;
		default:
			break;
		}
	}
	
	public ReturnvalSetStruct getReturnvalSetStruct(){
		return returnvalSetStruct;
	}
}
