package br.edu.ifs.ED.lista;

public class ListaEncOrdenada <T extends Comparable<T>> extends ListaEnc<T>{

    // Construtor

    public ListaEncOrdenada(){
        this.inicio = null;
        this.fim = null;
        this.qtdLista = 0;
    }
    @Override
    public void incluir(T elemento) throws Exception {

    }
    @Override
    public void incluirInicio(T elemento) throws Exception {

    }

    @Override
    public void incluir(T elemento, int posicao) throws Exception {

    }

    @Override
    public T get(int posicao) throws Exception {
        return super.get(posicao);
    }

    @Override
    public int getPosElemento(T elemento) throws Exception {
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
    public boolean contem(T elemento) throws Exception {
        return super.contem(elemento);
    }

}
