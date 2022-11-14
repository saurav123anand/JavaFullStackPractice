package com.example.userms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class CalculatorApplicationTests {
	Calculator calculator=new Calculator();
	@Test
	void contextLoads() {
	}

	@Test
	void testSum(){
		//expected
		int expectedResult=22;

		//actual
		int actualResult=calculator.doSum(12,3,5);

		assertThat(actualResult).isEqualTo(expectedResult);
	}


}
