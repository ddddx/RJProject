package unfinishedClass;

import basicInterface.IExceptionHolder;
import function.component.Excuter;
import functionInterface.IExcutee;
import functionInterface.IExcuter;

public class ExceptionExcuter extends Excuter implements IExcuter,IExceptionHolder{
	/**
	 * 当前Function中发生的异常对象。
	 */
	Exception exception;

	/**
	 * @param excuterName exceptionExcuter的名字。
	 */
	public ExceptionExcuter(String excuterName) {
		super(excuterName);
	}
	
	/**
	 * 重载这个获取Excutee的方法，
	 * 要求与这个ExceptionExcuter相连的Excutee必须是ExceptionExcutee，
	 * 能够设置Exception对象，
	 * 当这里获取Excutee的时候，会向获取的对象里面加入本对象的成员exception。
	 * @return 一个获取了exception的ExceptionExcutee。
	 */
	@Override
	public IExcutee getExcutee(){
		IExceptionHolder nextExcutee = (IExceptionHolder) super.getExcutee();
		nextExcutee.setException(exception);
		return (IExcutee) nextExcutee;
	}
	
	/**
	 * @param excutee excutee，要求是一个ExceptionExcutee类型的实例对象。
	 * @return 如果excutee不是ExceptionExcutee的实例的话，返回-1；
	 * 如果为null，返回0；
	 * 成功返回1。
	 */
	@Override
	public int linkExcutee(IExcutee excutee){
		if (excutee == null){
			return 0;
		}
		if (excutee instanceof ExceptionExcutee){
			return super.linkExcutee(excutee);
		}
		return -1;
	}

	/**
	 * 获取Exception。
	 * @return exception对象。
	 */
	@Override
	public Exception getException() {
		return exception;
	}

	/**
	 * 设置Exception对象。
	 * @param e exception对象。
	 */
	@Override
	public void setException(Exception e) {
		exception = e;
	}
	
	
}
