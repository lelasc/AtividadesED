import java.util.Scanner;

public class Moda {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quantidade de pessoas: ");
		int tam = sc.nextInt();
		int[] idades = new int[tam];
		int[] vetCont = new int[tam];
		int i, j, cont, modas, maiorCont,n;
		
		System.out.println("Digite as idades: ");
		for (i=0; i<tam; i++) {
			n = sc.nextInt();
			while (n < 0) {
				System.out.printf("Idade inválida! Digite novamente: ");
				n = sc.nextInt();
			}
			idades[i] = n;
		}
		
		//vetor com as frequências
		int somaFrequencia = 0;
		for (i=0; i<tam; i++){
			cont = 0;
			for (j=0; j<tam; j++){
				if (idades[i] == idades[j])
					cont++;
			}
			vetCont[i] = cont;
			somaFrequencia += vetCont[i];
		}
		
		//quais numeros aparecem mais vezes
		maiorCont = vetCont[0];
		for (i=0; i<tam; i++) {
			if (vetCont[i] > maiorCont)
					maiorCont = vetCont[i];
		}
		
		//quantidade de modas
		 modas = 0;
	     for (i=0; i<tam; i++) {
	         if (vetCont[i] == maiorCont && noVetor(idades[i], idades, i) == false) {
	                	 modas++;
	         }
	     }
		
		if (maiorCont*tam == somaFrequencia) {
			System.out.println("O conjunto é amodal");
		}else {
		
			System.out.printf("Há %d moda(s), sendo ela(s) ", modas);
			
			for (i = 0; i < tam; i++) {
            	if (vetCont[i] == maiorCont && noVetor(idades[i], idades, i) == false)
                System.out.printf("%d ", idades[i]);
            }

		}
		sc.close();
	}
	
	
	public static boolean noVetor(int n, int[] vet, int fim) {
        for (int i = 0; i < fim; i++) {
            if (vet[i] == n) {
                return true;
            }
        }
        return false;
    }
}