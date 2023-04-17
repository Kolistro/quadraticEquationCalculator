package quadraticEquationCalculator;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

/**
 * Программа UserInterface предназначена для работы с пользователями
 * @author Kolistro
 *
 */
public class UserInterface {
	public static void main(String[] args) throws IOException {
		System.out.println("Калькулятор квадратных уравнений");
		
		Coefficients coefficients = new Coefficients();
		QuadraticEquation qEquation = new QuadraticEquation(new Coefficients());
		
		String ch = "n";
		
		do {
			System.out.println("Выберите вариант ввода исходных данных: ");
			System.out.println("1. консоль");
			System.out.println("2. из файла");
			
			Scanner in = new Scanner(System.in);
			int number = in.nextInt();
			
			LinkedList<String> roots= new LinkedList();
			
			switch(number) {
			case(1)->{
				DataInput.consoleInput(coefficients);
				
				try {
					qEquation = new QuadraticEquation(coefficients);
					qEquation.solve();
					roots.addLast(qEquation.toString());
				}catch(Exception e) {
					roots.addLast(e.getMessage());
				}
			}
				
			case(2)->{
				Scanner fileInput = null;
				PrintWriter fileOutput = null;
			 	String nameFile = "";
			 	System.out.println("Введите точное название файла (Например: text.txt): ");
			 	nameFile = in.next();
			 	
			 	fileInput = DataInput.creationFileInput(nameFile);
			 	fileOutput = DataOutput.creationFileOutput("out.txt");
				
			 	
			 	while(fileInput.hasNextLine()) {
					DataInput.fileInput(coefficients, fileInput);
					
					try {
						qEquation = new QuadraticEquation(coefficients);
						qEquation.solve();
						roots.addLast(qEquation.toString());
					}catch(ArithmeticException e) {
						roots.addLast(e.getMessage());
					}
				}
			 	
			 	fileInput.close();
			 	fileOutput.close();
			}

		}
		
	 	System.out.println("Выберите вариант где вы хотите увидеть вычисленные результаты");
		System.out.println("1. в консоль");
		System.out.println("2. в файле");
		
		number = in.nextInt();
		
		switch(number) {
			case(1)->{
				DataOutput.consoleOutput(qEquation.toString());
			}
			
			case(2)->{
				PrintWriter fileOutput = null;
				
				String nameFile = "";
			 	System.out.println("Введите точное название файла (Например: text.txt): ");
			 	nameFile = in.next();
			 	
			 	fileOutput = DataOutput.creationFileOutput(nameFile);
			 	for(String root: roots) {
			 		DataOutput.fileOutput(root, fileOutput);
			 	}
			 	
			 	fileOutput.close();
			}
			
		}
			
			System.out.println("Хотите повторить? (y/n)");
			ch = in.next();
		}while(!ch.equals("n"));
		
	}
}
