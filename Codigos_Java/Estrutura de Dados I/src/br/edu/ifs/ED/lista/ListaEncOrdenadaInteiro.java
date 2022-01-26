package br.edu.ifs.ED.lista;

public class ListaEncOrdenadaInteiro extends ListaEncOrdenada<Integer>{

    // Construtor

    public ListaEncOrdenadaInteiro(){
        this.inicio = null;
        this.fim = null;
        this.qtdLista = 0;
    }

    @Override
    public void incluir(Integer elemento) throws Exception {

        No<Integer> novo = new No(elemento);
        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            No<Integer> tempAnterior = null;
            No<Integer> temp = inicio;
            while (temp != null && novo.getDado() > temp.getDado()) {
                tempAnterior = temp;
                temp = temp.getProx();
            }
            if (tempAnterior == null) incluirInicio(elemento);
            else if (temp == null) {
                fim.setProx(novo);
                fim = novo;
            } else {
                tempAnterior.setProx(novo);
                novo.setProx(temp);
            }
        }
        qtdLista++;
    }


    @Override
    public void incluirInicio(Integer elemento) throws Exception {
        if (inicio == null) incluir(elemento);
        if (elemento < inicio.getDado()) {
                No<Integer> novo = new No(elemento);
                novo.setProx(inicio);
                inicio = novo;
                qtdLista++;

        } else throw new Exception("O valor " + elemento + " não pode ser inserido no inicio.");
    }


    @Override
    public void incluir(Integer elemento, int posicao) throws Exception {
        if (posicao > qtdLista) throw new Exception("O valor " + elemento + " não pode ser inserido na posição informada.");
        if (inicio == null) incluir(elemento);
        else if (posicao == 0) incluirInicio(elemento);
        else {
            No<Integer> tempAnterior = null;
            No<Integer> temp = inicio;
            while (posicao > 0) {
                tempAnterior = temp;
                temp = temp.getProx();
                posicao--;
            }if (temp == null) incluir(elemento);
            else if (elemento > tempAnterior.getDado() && elemento < temp.getDado()) {
                No<Integer> novo = new No(elemento);
                tempAnterior.setProx(novo);
                novo.setProx(temp);
                qtdLista++;
            } else throw new Exception("O valor " + elemento + " não pode ser inserido na posição informada.");
        }
    }

    @Override
    public Integer get(int posicao) throws Exception {
        return super.get(posicao);
    }

    @Override
    public int getPosElemento(Integer elemento) throws Exception {
        return super.getPosElemento(elemento);
    }

    @Override
    public void remover(int posicao) throws Exception {
        super.remover(posicao);
    }

    @Override
    public void limpar() {
        super.limpar();
    }

    @Override
    public int getTamanho() {
        return super.getTamanho();
    }

    @Override
    public boolean contem(Integer elemento) throws Exception {
        return super.contem(elemento);
    }
}