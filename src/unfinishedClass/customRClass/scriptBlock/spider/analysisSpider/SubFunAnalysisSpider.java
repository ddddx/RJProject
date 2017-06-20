package unfinishedClass.customRClass.scriptBlock.spider.analysisSpider;

import unfinishedClass.customRClass.RStringChecker;
import unfinishedClass.customRClass.scriptBlock.ScriptBlock;
import unfinishedClass.customRClass.scriptBlock.information.Information;
import unfinishedClass.customRClass.scriptBlock.information.InformationType;
import unfinishedClass.customRClass.scriptBlock.spider.AbstractBCSpider;

public class SubFunAnalysisSpider extends AbstractBCSpider {

	public SubFunAnalysisSpider(ScriptBlock targetBlock) {
		super(targetBlock);
	}

	@Override
	protected void dealWithTargetBlock() {
		Information information = targetBlock.getInformation();
		String informationString = information.getOriginalString();
		
		
		if (RStringChecker.checkSubFun(informationString)){
			information.setType(InformationType.SUBFUN);
		} else {
			information.setType(InformationType.VOID);
			information.appendDescription("子Function（SubFun）声明格式非法。");
		}
		
		//检查是否使用了泛型
		ScriptBlock subBlock = targetBlock.getSub();
		if (subBlock != null){
			new GenericsAssignAnalysisSpider(subBlock)
				.workUntilEnd();
		}
	}

}
