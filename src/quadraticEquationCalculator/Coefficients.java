package quadraticEquationCalculator;

/**
 * Класс для хранения коэффициентов уравнения
 * @author Kolistro
 *
 */
public class Coefficients {
	private double a;
	private double b;
	private double c;
	
	Coefficients(){
		this.a = 0;
		this.b = 0;
		this.c = 0;
	}
	
	/**
	 * 
	 * @param a коэффициент перед x*x
	 * @param b коэффициент перед x
	 * @param c свободный коэффициент
	 */
	Coefficients(double a, double b, double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	Coefficients(Coefficients coefficients){
		this.a = coefficients.getA();
		this.b = coefficients.getB();
		this.c = coefficients.getC();
	}
	
	public void setA(double a) {
		this.a = a;
	}
	
	public void setB(double b) {
		this.b = b;
	}
	
	public void setC(double c) {
		this.c = c;
	}
	
	public double getA() {
		return a;
	}
	
	public double getB() {
		return b;
	}
	
	public double getC() {
		return c;
	}
}
