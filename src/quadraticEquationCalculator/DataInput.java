package quadraticEquationCalculator;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Сервисный класс для ввода данных
 * @author Kolistro
 *
 */
public class DataInput {
	/**
	 * Берет данные, введенные пользователем, из консоли
	 * @param coefficients коэффициенты уравнения
	 * @see Coefficients
	 */
	public static void consoleInput(Coefficients coefficients) {
		Scanner in = new Scanner(System.in);
		System.out.println("Введите коэффицинты уравнения в строчку через пробел");
		coefficients.setA(in.nextDouble());
		coefficients.setB(in.nextDouble());
		coefficients.setC(in.nextDouble());
	
	}
	
	/**
	 * Создает файловый поток, для дальнейшей работы
	 * @param nameFile название файла, откуда будут браться данные
	 * @return возвращает созданный файл для дальнейшей работы с ним
	 * @throws IOException исключение, связанное с созданием/открытием файла
	 * @see IOException
	 */
	public static Scanner creationFileInput(String nameFile) throws IOException {		
		Scanner fileInput = null;
		try {
			File file = new File(nameFile);
			fileInput = new Scanner(file);
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return fileInput;
	}
	
	/**
	 * Берет данные из файла
	 * @param coefficients переменная для хранения коэффициентов уравнения
	 * @param fileInput файловый поток, откуда будут браться коэффициенты
	 */	
	 public static void fileInput(Coefficients coefficients, Scanner fileInput) {
		// считывает строку из файла
		String line =fileInput.nextLine();
		// разделяет строку в массив строк (разделителем служит пробел)
		String[] numbersString = line.split(" ");
		// временный массив для хранения первых трех коэффициентов
		double[] numbers = new double[3];
		// вспомогательная переменная, для передвижения по массиву numbers
		int counter = 0;
		
		// преобразование массива строк в массив чисел типа double
		for(String num: numbersString) {
			numbers[counter++] = Double.parseDouble(num);
		}
		
		coefficients.setA(numbers[0]);
		coefficients.setB(numbers[1]);
		coefficients.setC(numbers[2]);
	} 
}
