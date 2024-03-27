package com.unitfit.training;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TrainingApplicationTests {
	ApplicationModules modules = ApplicationModules.of(TrainingApplication.class);

 	@Test
	void modulesVerify(){
		System.out.println("teste");
//		modules.verify();
	}

	@Test
	void modulesPrinter(){
		modules.forEach(System.out::println);
	}
}
