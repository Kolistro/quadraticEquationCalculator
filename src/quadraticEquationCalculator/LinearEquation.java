package quadraticEquationCalculator;


/**
 * Программа LinearEquation реализует приложение,которое
 * по заданным коэффициентам вычисляет корень линейного уравнения.
 * 
 * @author Kolistro
 *
 */
public class LinearEquation implements Equation {

	private double a;
	private double b;
	private double x;
	
	/**
	 * 
	 * @param a коэффициент перед x
	 * @param b свободный коэффициент
	 */
	LinearEquation(double a, double b){
		this.a = a;
		this.b = b;
		this.x = 0.0;
	}
	
	public double getX() {
		return x;
	}
	
	/**
	 * Вычисляет корнь линейного уравнения.
	 * @exception если коэффициент a равен 0 выбрасывает исключение ArithmeticException
	 */
	@Override
	public void solve() throws ArithmeticException{
		if(a == 0.0 && b == 0.0) {
			throw new ArithmeticException("Действительных корней бесконечно много!");
		}
		
		if(a == 0.0) {
			 throw new ArithmeticException("Действительных корней нет!");
		}
		
		x = (-b) / a;
		
	}
	 public String toString() {
		 return "x = " + x ; 
	 }

}
