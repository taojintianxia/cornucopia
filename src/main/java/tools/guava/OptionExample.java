package tools.guava;

import org.junit.Test;

public class OptionExample {

	// Java里居然能出现这样的代码判空并设置默认值
	// (Integer)myParams.get("auditId")==null?0:(Integer)myParams.get("auditId");
	// 看看guava怎么设置
	@Test
	public void testNullHandler() {
		
	}

}
