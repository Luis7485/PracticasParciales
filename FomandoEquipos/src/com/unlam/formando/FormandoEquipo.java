package com.unlam.formando;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FormandoEquipo extends EjercicioOIA{
	
	private int maxResult;
	private String palMax;
	private Scanner scanner;
	private PrintWriter print;
	
	public FormandoEquipo(File entrada, File salida) {
		super(entrada, salida);
		try {
			scanner = new Scanner(entrada);
			print = new PrintWriter(salida);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		maxResult = 0;
		palMax = "";
	}
	
	@Override
	public void resolver() {
		int auxResult=0;
		String auxpal;
		int contAux;
		int cantpreg = scanner.nextInt();
		int cantcola = scanner.nextInt();
		String [] mat= new String[cantcola];
		for(int i = 0;i <cantcola;i++ ){
			mat[i] = scanner.next();
			}
		for(int ii = 0; ii<cantcola; ii++){
			for(int i = 0; i<cantpreg; i++){
				auxpal = mat[ii].substring(0,i+1);
				contAux = 0;
				for(int j = 0; j<cantcola; j++){
					if(auxpal.equals(mat[j].substring(0, i+1)))
						contAux++;
				}
				if(contAux>1)
					auxResult = (int) (contAux*Math.pow(i+1, 2));
				else
					auxResult = 0;
				if(auxResult>maxResult){
					palMax=auxpal;
					maxResult=auxResult;
				}				
			}
		}
		print.println(maxResult);
		print.println(palMax);
		
		scanner.close();
		print.close();
	}
	
	public int getMaxResult() {
		return maxResult;
	}

	public String getPalMax() {
		return palMax;
	}


	public static void main(String [] args) throws FileNotFoundException{
		
		File entrada = new File("entrada.in");
		File salida = new File("salida.out");
		
		FormandoEquipo nuevo = new FormandoEquipo(entrada, salida);
		
		nuevo.resolver();
		
		System.out.println("*********************************************");
		System.out.println("resultado maximo = "+nuevo.getMaxResult()+" palabra elegida: "+nuevo.getPalMax());
		System.out.println("*********************************************");
	}

}	