package features;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MethodStackInvocationTracer {

	private static Logger logger = LoggerFactory.getLogger(MethodStackInvocationTracer.class);

	// 该方法应该放在一个期待查看上层调用的地方
	// 例如一个util中有报错,但是调用该util的方法很多,想查询到底是哪个方法调用该util中方法时出错
	public static void printInvocationStack() {
		logger.error("调用generateShardingTableNames时 , startDate在endDate之后 - sharding");
		try {
			StackTraceElement[] traces = Thread.currentThread().getStackTrace();
			logger.error("startDate在endDate之后的调用方法的栈列表为 :");
			for (StackTraceElement traceElement : traces) {
				logger.error("方法名 : " + traceElement.getClassName() + "." + traceElement.getMethodName()
						+ " 代码行数 : line " + traceElement.getLineNumber());
			}
		} catch (Exception e) {
			logger.error("获取generateShardingTableNamesDuringPeriod中日期判断处的调用堆栈出错" + e);
		}
	}

	public static void main(String... args) {
		MethodStackInvocationTracer.printInvocationStack();
	}
}
