package cz.upce.ex01;

import cz.upce.ex01.controllers.NoParameterController;
import cz.upce.ex01.controllers.ParameterController;
import cz.upce.ex01.controllers.SetController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Ex01ApplicationTests {
	@Autowired
	private SetController setController;
	@Autowired
	private NoParameterController noParameterController;
	@Autowired
	private ParameterController parameterController;


	@Test
	void contextLoads() throws Exception {
		Assertions.assertThat(setController).isNotNull();
		Assertions.assertThat(noParameterController).isNotNull();
		Assertions.assertThat(parameterController).isNotNull();
	}

}
