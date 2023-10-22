public class ListaEncadeada {
	private class Node {
        String info;
        Node prox;

        public Node(String info) {
            this.info = info;
            this.prox = null;
        }
    }

    private Node inicio;
    private int tam;

    public void Lista() {
        this.inicio = null;
        this.tam = 0;
    }
    
    // Tamanho da lista
    
    public int tamanho() {
    	return this.tam;
    }

    // Inserir no início da lista

    public void pushInicio(String info) {
        Node novoNode = new Node(info);
        novoNode.prox = this.inicio;
        this.inicio = novoNode;
        this.tam++;
    }

    // Inserir no final da lista

    public void pushFim(String info) {
        Node novoNode = new Node(info);
        if (this.inicio == null) {
            this.inicio = novoNode;
        } else {
            Node aux = this.inicio;
            while (aux.prox != null) {
                aux = aux.prox;
            }
            aux.prox = novoNode;
        }
        this.tam++;
    }

    // Verificar se um determinado elemento existe na lista

    public boolean existe(String info) {
        Node aux = this.inicio;
        while (aux != null) {
            if (aux.info.equalsIgnoreCase(info)) {
                return true;
            }
            aux = aux.prox;
        }
        return false;
    }

    // Excluir um determinado elemento da lista

    public void remove(String info) {
        Node aux = this.inicio;
        Node ante = null;
        while (aux != null) {
            if (aux.info.equalsIgnoreCase(info)) {
                if (ante == null) {
                    this.inicio = aux.prox;
                } else {
                    ante.prox = aux.prox;
                }
                this.tam--;
                return;
            }
            ante = aux;
            aux = aux.prox;
        }
    }

    // Mostrar todos os elementos e dizer a quantidade de elementos na lista

    public String mostrar() {
        StringBuilder resultado = new StringBuilder();
        Node aux = this.inicio;
        while (aux != null) {
            resultado.append(aux.info).append("\n");
            aux = aux.prox;
        }
        return resultado.toString();
    }

    //inserir em ordem alfabética
    
    public void ordemAlfabetica(String info) {
    	String nome = info;
        Node novoNode = new Node(info);
        if (this.inicio == null) {
            this.inicio = novoNode;
        } else {
            Node aux = this.inicio;
            Node ante = null;
            while (aux != null && nome.compareToIgnoreCase(aux.info) > 0) {
                ante = aux;
                aux = aux.prox;
            }
            if (ante == null) {
                novoNode.prox = this.inicio;
                this.inicio = novoNode;
            } else {
                novoNode.prox = ante.prox;
                ante.prox = novoNode;
            }
        }
        this.tam++;
    }
}
