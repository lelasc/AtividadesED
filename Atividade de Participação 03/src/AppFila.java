import java.util.Scanner;

public class AppFila {
	public static void main(String[] args) {
		LinkedQueue <String> normal = new LinkedQueue<String>();
		LinkedQueue <String> prioridade = new LinkedQueue<String>();		
		Scanner sc = new Scanner(System.in);
		
		boolean on = true, naFila;
		String nome;
				
		while (on){
			System.out.printf("--------- MENU ---------\n"
					+ "1 - Entrada normal\n"
					+ "2 - Entrada prioritária\n"
					+ "3 - Atender uma pessoa\n"
					+ "4 - Listar todos\n"
					+ "5 - Gerar estatíticas\n"
					+ "6 - SAIR\n");
			System.out.printf("Escolha uma opção: ");
			int op = sc.nextLine().trim().charAt(0) - '0';
			while (op < 1 || op > 6) {
				System.out.printf("Opção inválida! Digite novamente: ");
				op = sc.nextLine().trim().charAt(0) - '0';
			}
			
			
			switch (op) {
			case 1:
				System.out.printf("Digite o nome: ");
				nome = sc.nextLine();
				naFila = normal.existe(nome) || prioridade.existe(nome);
				if (naFila)
					System.out.printf("Esta pessoa já está na fila!\n");
				else {
					normal.enqueue(nome);
					System.out.printf("Nome cadastrado com sucesso!\n");
				}
				break;
			case 2:
				System.out.printf("Digite o nome: ");
				nome = sc.nextLine();
				naFila = normal.existe(nome) || prioridade.existe(nome);
				if (naFila)
					System.out.printf("Esta pessoa já está na fila!\n");
				else {
					prioridade.enqueue(nome);
					System.out.printf("Nome cadastrado com sucesso!\n");
				}
				break;
			case 3:
				if (normal.isEmpty() && prioridade.isEmpty()) {
					System.out.printf("As filas estão vazias!\n");
				} else {
					if (prioridade.isEmpty())
						System.out.printf("Atendido: %s\n", normal.dequeue());
					else
						System.out.printf("Atendido: %s\n", prioridade.dequeue());
				}
				break;
			case 4:
				if (normal.isEmpty() && prioridade.isEmpty()) {
					System.out.printf("As filas estão vazias!\n");
				} else {
				System.out.printf("Ordem de atendimento:\n");
				System.out.print(prioridade);
				System.out.print(normal);
				}
				break;
			case 5:
				if (!normal.isEmpty() && !prioridade.isEmpty()) {
					System.out.printf("Tamanho da fila normal: %d (%.2f%%)\n"
							+ "Tamanho da fila prioritária: %d (%.2f%%)\n", normal.size(),
							(100.0 * normal.size())/(normal.size() + prioridade.size()),
							prioridade.size(),
							(100.0 * prioridade.size())/(normal.size() + prioridade.size()));
				} else if (normal.isEmpty() && !prioridade.isEmpty()){
					System.out.printf("A fila normal está vazia!\n");
					System.out.printf("Tamanho da fila prioritária: %d (%.2f%%)\n", prioridade.size(),
							(100.0 * prioridade.size())/(normal.size() + prioridade.size()));
				} else if (!normal.isEmpty() && prioridade.isEmpty()) {
					System.out.printf("A fila prioritária está vazia!\n");
					System.out.printf("Tamanho da fila normal: %d (%.2f%%)\n", normal.size(),
							(100.0 * normal.size())/(normal.size() + prioridade.size()));
				} else if (normal.isEmpty() && prioridade.isEmpty()) {
					System.out.printf("As filas estão vazias!\n");
				}
				break;
			case 6: 
				if (normal.isEmpty() && prioridade.isEmpty()) {
					if (!normal.isEmpty() && !prioridade.isEmpty()) {
						System.out.printf("Estatísticas finais: ");
						System.out.printf("Tamanho da fila normal: %d (%.2f%%)\n"
								+ "Tamanho da fila prioritária: %d (%.2f%%)\n", normal.size(),
								(100.0 * normal.size())/(normal.size() + prioridade.size()),
								prioridade.size(),
								(100.0 * prioridade.size())/(normal.size() + prioridade.size()));
					} else if (normal.isEmpty() && !prioridade.isEmpty()){
						System.out.printf("Estatísticas finais: ");
						System.out.printf("A fila normal está vazia!\n");
						System.out.printf("Tamanho da fila prioritária: %d (%.2f%%)\n", prioridade.size(),
								(100.0 * prioridade.size())/(normal.size() + prioridade.size()));
					} else if (!normal.isEmpty() && prioridade.isEmpty()) {
						System.out.printf("Estatísticas finais: ");
						System.out.printf("A fila prioritária está vazia!\n");
						System.out.printf("Tamanho da fila normal: %d (%.2f%%)\n", normal.size(),
								(100.0 * normal.size())/(normal.size() + prioridade.size()));
					}
					System.out.printf("Programa encerrado.\n");
					on = false;
				} else {
					System.out.printf("O programa só poderá ser encerrado quando as filas estiverem vazias\n");
				}
				break;
			}
		
		}
		sc.close();
	}
}
