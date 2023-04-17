package quadraticEquationCalculator;

/**
 * Программа QuadraticEquation реализует приложение,которое
 * по заданным коэффициентам вычисляет корни квадратного уравнения.
 * 
 * @author Kolistro
 *
 */
public class QuadraticEquation implements Equation{
	private Coefficients coefficients;
	private double x1;
	private double x2;
	
	/**
	 * 
	 * @param coefficients коэффициенты уравнения (получаемые либо из консольного, либо из файлового вводов).
	 * @see Coefficients
	 */
	QuadraticEquation(Coefficients coefficients){
		this.coefficients = new Coefficients(coefficients);
		this.x1 = 0.0;
		this.x2 = 0.0;
	}
	
	public double getX1() {
		return x1;
	}
	
	public double getX2() {
		return x2;
	}
	
	/**
	 * Вычисляет корни квадратного уравнения.
	 * Если коэффициент 'а' равен 0, коэффициенты передаются в программу LinearEquation
	 * @see LinearEquation
	 * @throws ArithmeticException Если дискриминант уравнения равен нулю, выбрасывается исключение
	 */
	@Override
	public void solve() throws ArithmeticException {
		if(coefficients.getA() == 0) {
			LinearEquation linearEquation = new LinearEquation(coefficients.getB(), coefficients.getC());
			try {
				linearEquation.solve();
				x1 = linearEquation.getX();
				x2 = x1;
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		// дискриминант уравнения
		double discriminant = coefficients.getB()*coefficients.getB() - 4*coefficients.getA()*coefficients.getC();
		
		if(discriminant < 0) {
			throw new ArithmeticException("Действительных корней нет!");
			
		}
		
		if(discriminant == 0) {
			x1 = (-coefficients.getB()) / 2 / coefficients.getA();
			x2 = x1;
		}
		
		x1 = ((-coefficients.getB()) - Math.sqrt(discriminant)) / 2 / coefficients.getA();
		x2 = ((-coefficients.getB()) + Math.sqrt(discriminant)) / 2 / coefficients.getA();
	}

	public String toString() {
		return  "x1 = " + x1 + "\t" + "x2 = " + x2 ;
	}
}
