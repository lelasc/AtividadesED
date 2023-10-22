import java.util.Scanner;

public class Busca {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("Quantidade de pessoas: ");
		int tam, i;
		tam = sc.nextLine().trim().charAt(0) - '0';
		String nome;
		
		String[] nomes = new String[tam];
		
		System.out.println("Digite os nomes: ");
		for (i=0; i<tam; i++) {
			System.out.printf("Nome %d: ", i);
			nomes[i] = sc.nextLine();
		}
		
		System.out.printf("Buscar nome: ");
		nome = sc.nextLine();
		
		boolean encontrou = false;
		for (i=0; i<tam; i++) {
			if (nome.equals(nomes[i])) {
				encontrou = true;
			}
		}
		
		if (encontrou) {
			System.out.printf("Nome encontrado na posição(ões) ");
			for (i=0; i<tam; i++) {
				if (nome.equals(nomes[i])) {
					System.out.printf(i + " ");
				}
			}
		}
		
		
		if (!encontrou)
			System.out.printf("Nome nao encontrado");
		sc.close();
	}
}
