import java.util.Scanner;

public class Media {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int tam, n;
		float soma = 0;
	
		System.out.println("Quantidade de pessoas: ");
		tam = sc.nextInt();
	
		System.out.println("Digite as idades: ");
		for (int i = 0; i < tam; i++) {
			n = sc.nextInt();
			while (n < 0) {
				System.out.printf("Idade inválida! Digite novamente: ");
				n = sc.nextInt();
			}
			soma += n;
		}
		
		System.out.printf("Média = %.2f", soma/tam);
		sc.close();
	}
}
