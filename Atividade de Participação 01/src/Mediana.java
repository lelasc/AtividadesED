import java.util.Scanner;

public class Mediana {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quantidade de pessoas: ");
		int tam = sc.nextInt();
		int[] idades = new int[tam];
		float mediana;
		int n;
		
		System.out.println("Digite as idades: ");
		for (int i=0; i<tam; i++) {
			n = sc.nextInt();
			while (n < 0) {
				System.out.printf("Idade inválida! Digite novamente: ");
				n = sc.nextInt();
			}
			idades[i] = n;
		}
			
		if (tam%2 == 0) {
			mediana = (float)(idades[tam/2] + idades[(tam/2-1)])/2;
		} else {
			mediana = (float)idades[(tam/2)];
		}
		
		System.out.printf("Mediana = %.2f", mediana);
		sc.close();
	}
}
