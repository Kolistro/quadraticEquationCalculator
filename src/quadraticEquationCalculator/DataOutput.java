package quadraticEquationCalculator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Сервисный класс для вывода данных 
 * @author Kolistro
 *
 */
public class DataOutput {
	/**
	 * Выводит данные в консоль
	 * @param str строка, содержащая корни решенных уравнений
	 */
	public static void consoleOutput(String str) {
		System.out.println(str);
	}
	
	/**
	 * Создает файл для вывода данных
	 * @param nameFile название файла
	 * @return PrintWriter возвращает созданный файл для дальнейшей работы с ним
	 * @throws IOException исключение, связанное с созданием/открытием файла
	 * @see IOException
	 */
	public static PrintWriter creationFileOutput(String nameFile) throws IOException{
		PrintWriter fileOutput = null;
		try {
			File file = new File(nameFile);
			fileOutput = new PrintWriter(file);
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return fileOutput;
	}
	
	/**
	 * Сохраняет данные в файле
	 * @param str строка, содержащая корни решенных уравнений
	 * @param fileOutput файл, в который производится запись
	 */
	public static void fileOutput(String str, PrintWriter fileOutput) {
		fileOutput.println(str);
		System.out.println("Файл записан!");
	}
}
