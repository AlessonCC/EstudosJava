package br.edu.ifs.ED.lista;

public class ListaEnc<T extends Comparable<T>> extends Lista<T> {

    // Atributos

    protected No<T> inicio;
    protected No<T> fim;
    protected int qtdLista;

    // Construtor

    public ListaEnc(){
        this.inicio = null;
        this.fim = null;
        this.qtdLista = 0;
    }

    @Override
    public void incluir(T elemento) throws Exception {
        No<T> novo = new No<>(elemento);

        if (inicio == null){
            inicio = novo;
            fim = inicio;
        }else {
            fim.setProx(novo);
            fim = novo;
        }
        qtdLista++;
    }

    @Override
    public T get(int posicao)  throws Exception {

        if (posicao >= qtdLista || posicao < 0)
            throw new IllegalArgumentException("Posição solicitada não existe na lista");

        No<T> temp = inicio;

        for (int i = 0; i < posicao; i++)
            temp = temp.getProx();

        return temp.getDado();
    }


    @Override
    public int getPosElemento(T elemento)  throws Exception {

        No<T> temp = inicio;
        int posicao = 0;
        while (temp != null){
            if (temp.getDado().equals(elemento)){
                return posicao;
            }else {
                posicao++;
                temp = temp.getProx();
            }
        }
        throw new Exception("Elemento não localizado");
    }

    @Override
    public void incluirInicio(T elemento) throws Exception {
        No<T> novo = new No<>(elemento);

        if (qtdLista == 0){
            inicio = novo;
            fim = novo;
        }else {
            novo.setProx(inicio);
            inicio = novo;
        }
        qtdLista++;
    }

    @Override
    public void incluir(T elemento, int posicao) throws Exception {
        if (posicao < 0 || posicao > qtdLista )
            throw new Exception("Posição solicitada não existe na lista");
        No<T> novo = new No<>(elemento);
        if (qtdLista == 0){
            inicio = novo;
            fim = novo;
        }else {
            if (posicao == 0){
                No<T> temp = inicio;
                inicio = novo;
                inicio.setProx(temp);
            }else {
                No<T> temp = inicio;

                for (int i = 0; i < posicao-1; i++){
                    temp = temp.getProx();
                }
                novo.setProx(temp.getProx());
                temp.setProx(novo);
            }
        }
        qtdLista++;
    }

    @Override
    public void remover(int posicao) throws Exception {
        if (qtdLista == 0)
            throw new Exception("Lista de elementos vazia");

        if (posicao == 0){
            inicio = inicio.getProx();
            qtdLista--;
        }

        No<T> temp = inicio;
        No<T> aux = temp;

        for (int i = 0; i < posicao; i++) {
            temp = temp.getProx();
        }
        for (int i = 0; i < posicao - 1; i++) {
            aux = aux.getProx();
        }
        aux.setProx(temp.getProx());
        qtdLista--;

    }

    @Override
    public int getTamanho() {
        return qtdLista;
    }

    public void limpar() {
        this.inicio =  null;
        this.fim = null;
        this.qtdLista = 0;

    }

    @Override
    public boolean contem(T elemento) throws Exception {
        if (qtdLista == 0)
            throw new Exception("Erro ao buscar elemento, lista vazia");

        No<T> temp = inicio;

        while (temp != null){
            if (temp.getDado().equals(elemento))
                return true;

            temp = temp.getProx();
        }
        return false;
    }
}
