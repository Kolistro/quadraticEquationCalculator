package quadraticEquationCalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

public class quadraticEquationTest {

	@Test(expected = ArithmeticException.class)
	public void solveTestArithmeticException() {
		QuadraticEquation quadraticEquation = new QuadraticEquation(new Coefficients(1, 1, 1));
		quadraticEquation.solve();
	}

	@Test
	public void solveTestDiscriminantIsZero() {
		double result1 = 0;
		double result2 = 0;
		double expected1 = -1;
		double expected2 = expected1;
		try {
			QuadraticEquation quadraticEquation = new QuadraticEquation(new Coefficients(1, 2, 1));
			quadraticEquation.solve();
			result1 = quadraticEquation.getX1();
			result2 = quadraticEquation.getX2();
		}catch(ArithmeticException e) {
			System.out.println("Действительных корней нет!");
		}
		Assert.assertEquals(expected1, result1, 0.0001);
		Assert.assertEquals(expected2, result2, 0.0001);
		Assert.assertEquals(result1, result2, 0.0001);
	}
	
	@Test
	public void solveTest() {
		double result1 = 0;
		double result2 = 0;
		double expected1 = -0.2808;
		double expected2 = 1.7808;
		try {
			QuadraticEquation quadraticEquation = new QuadraticEquation(new Coefficients(2, -3, -1));
			quadraticEquation.solve();
			result1 = quadraticEquation.getX1();
			result2 = quadraticEquation.getX2();
		}catch(ArithmeticException e) {
			System.out.println("Действительных корней нет!");
		}
		Assert.assertEquals(expected1, result1, 0.0001);
		Assert.assertEquals(expected2, result2, 0.0001);
	}
	
	
}
