package unfinishedClass.customRClass.scriptBlock;

import unfinishedClass.customRClass.RStringChecker;
import unfinishedClass.customRClass.scriptBlock.information.Information;
import unfinishedClass.customRClass.scriptBlock.information.InformationType;
import unfinishedClass.customRClass.scriptBlock.spider.AbstractBCSpider;

public class CommentAnalysisSpider extends AbstractBCSpider {

	public CommentAnalysisSpider(ScriptBlock targetBlock) {
		super(targetBlock);
	}

	@Override
	protected void dealWithTargetBlock() {
		ScriptBlock subBlock = targetBlock.getSub();
		Information information = targetBlock.getInformation();
		String informationString = information.getOriginalString();
		
		if (RStringChecker.checkRect(informationString)){
			information.setType(InformationType.RECT);
			if (subBlock != null){
				new CommentContentAnalysisSpider(subBlock)
					.workUntilEnd();
			}
		} else {
			information.setType(InformationType.VOID);
			information.appendDescription("AnalysisSpider解析"
					+ "Comment注释的方形区域检查时发现非法的区域声明。");
		}
	}

}
