package ${packageName};

public class TestEntity {

	private ${type} ${name};

	public ${type} get${name?cap_first}() {
		return ${name};
	}

	public void set${name?cap_first}(${type} ${name}) {
		this.${name} = ${name};
	}
}