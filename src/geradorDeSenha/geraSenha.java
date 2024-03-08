package geradorDeSenha;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class geraSenha {
	//variaveis 
	public static Scanner scan;
	public static Random random;
	
	
	private static String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static String letrasNum = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private static String letrasNumEsp = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*";
	private static int numCarac;
	
	
	//Método main
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		random = new Random();
		String senhas = "";
		
		//Para identificar quantos caracteres vai ter a senha
		try {
			System.out.print("Quantos caracteres você quer a sua senha? ");
			numCarac = scan.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Ops... você digitou caracteres. Precisamos que digite apenas números.");
			return;
		}
		//Identifica qual tipo de senha 
		System.out.print("Que tipo de senha você deseja com apenas letras(1), letras e números(2) ou letras, números e caracteres especiais(3)? ");
		
		try {
			int qualTipo = scan.nextInt();
			if(qualTipo == 1) {
				senhas = GeradorDeSenhas(letras, numCarac);
			}
			else if(qualTipo == 2) {
				senhas = GeradorDeSenhas(letrasNum, numCarac);
			}
			else if(qualTipo == 3) {
				senhas = GeradorDeSenhas(letrasNumEsp, numCarac);
			}else {
				System.out.println("Número invalido");
			}
			if(senhas == "") {
				return;
			}else {
				//Printa na tela a senha gerada
				System.out.print("Aqui está sua senha com "+ numCarac + ": " + senhas); 
			}
		}catch(InputMismatchException e) {
			//Caso input seja alguma coisa que não seja número
			System.out.println("Ops... você digitou caracteres. Precisamos que digite apenas números.");
		}
	}
	//Método gerador de senhas 
	public static String GeradorDeSenhas(String opt, int numDeCarac) {
		String senha = "";
		for (int i = 0; i < numDeCarac; i++) {
			senha += opt.charAt(random.nextInt(opt.length()));
		}
		return senha;
	}
}
