import javax.swing.JOptionPane;

public class AppLista {

	public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();
		String menu = "1 - Inserir\n2 - Verificar\n3 - Excluir\n4 - Mostrar\n5 - Sair";
		int resp=-1;
		while(resp!=5){
		do {
			resp = Integer.parseInt(JOptionPane.showInputDialog(menu));
		}while (resp > 5 || resp<1);
		
		switch (resp) {
		case 1:
			Object[] options = {"Início", "Final", "Ordem alfabética"};
			int escolha = JOptionPane.showOptionDialog(null, "Escolha a posição pra inserir:",
					null , JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			String nome = JOptionPane.showInputDialog("Digite o nome:");
			if (escolha == 0) {
					if (lista.existe(nome)) {
						JOptionPane.showMessageDialog(null, "Nome já cadastrado", "Erro", JOptionPane.WARNING_MESSAGE);
					}
					else {
						lista.pushInicio(nome);
					}
			}
			else if (escolha ==1) {
				if (lista.existe(nome)) {
					JOptionPane.showMessageDialog(null, "Nome já cadastrado", "Erro", JOptionPane.WARNING_MESSAGE);
				}
				else 
					lista.pushFim(nome);	
			} else if (escolha ==2) {
				if (lista.existe(nome)) {
					JOptionPane.showMessageDialog(null, "Nome já cadastrado", "Erro", JOptionPane.WARNING_MESSAGE);
				}
				else 
					lista.ordemAlfabetica(nome);	
			}
			break;
		case 2:
			String nome2 = JOptionPane.showInputDialog("Digite o nome:");
			if (lista.existe(nome2)) {
				JOptionPane.showMessageDialog(null, "Nome já cadastrado");
			} else 
				JOptionPane.showMessageDialog(null, "Não cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);			
			break;
		case 3:
			String nome3 = JOptionPane.showInputDialog("Digite o nome:");
			if (lista.existe(nome3)) {
				lista.remove(nome3);
			} else 
				JOptionPane.showMessageDialog(null, "Não cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
			break;
		case 4:
			if (lista.tamanho() == 0)
				JOptionPane.showMessageDialog(null, "A lista está vazia.");
			else
			JOptionPane.showMessageDialog(null,"Tamanho da lista: "+ lista.tamanho()+"\n" + "Elementos da lista:\n" 
		+ lista.mostrar());
			break;
		case 5:
			break;
		}
		}
	}

}