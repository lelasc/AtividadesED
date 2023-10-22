import java.util.Scanner;

public class Desvio {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quantidade de pessoas: ");
		int tam = sc.nextInt();
		int[] idades = new int[tam];
		float soma = 0, media;
		int n;
		
		
		System.out.println("Digite as idades: ");
		for (int i = 0; i < tam; i++) {
			n = sc.nextInt();
			while (n <= 0) {
				System.out.printf("Idade inválida! Digite novamente: ");
				n = sc.nextInt();
			}
			idades[i] = n;
			soma += idades[i];
		}
		
		media = soma/tam;
		System.out.println("Média = " + media);

		for (int i=0; i<tam; i++) {
			System.out.printf("Desvio %d = %.1f\n", i, idades[i] - media);
		}
		sc.close();
	}
}
