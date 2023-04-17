package quadraticEquationCalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

public class LinearEquationTest {
	
	@Test(expected =  ArithmeticException.class)
	public void solveTestArithmeticExceptionForCoefficientsZero() {
		LinearEquation linearEquation = new LinearEquation(0.0, 0.0);
		linearEquation.solve();
	}
	
	@Test(expected = ArithmeticException.class)
	public void solveTestArithmeticExceptionForAZero() {
		LinearEquation linearEquation = new LinearEquation(0.0, 3);
		linearEquation.solve();
	}
	
	@Test
	public void solveTest() {
		double result = 0.0;
		try {
			LinearEquation linearEquation = new LinearEquation(2.0, -4.0);
			linearEquation.solve();
			result = linearEquation.getX();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		double expected = 2.0;
		Assert.assertEquals(expected, result, 0.0001);
	}
}
