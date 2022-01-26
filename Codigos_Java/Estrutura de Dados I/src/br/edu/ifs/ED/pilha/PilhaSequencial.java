package br.edu.ifs.ED.pilha;

public class PilhaSequencial<T> implements IPilha<T>{
    protected int qtd;
    T[] dados;
    int max;
    public PilhaSequencial(Class<T> dataType){
        this.max = 10;
        this.dados = (T[]) java.lang.reflect.Array.newInstance(dataType, this.max);
        this.qtd = -1;
    }

    @Override
    public void empilhar(T valor) throws PilhaCheiaException {
        if (qtd == 9)
            throw new PilhaCheiaException();
        else{
            qtd++;
            dados[qtd] = valor;
        }

    }

    @Override
    public T desempilhar() throws PilhaVaziaException {
        if (estahVazia())
            throw new PilhaVaziaException();
        else {
            T aux = dados[qtd];
            dados[qtd] = null;
            qtd--;
            return aux;
        }
    }

    @Override
    public T getTopo() throws PilhaVaziaException{
        if (estahVazia())
            throw new PilhaVaziaException();
        else
            return dados[qtd];

    }

    @Override
    public int getQtd() {
        return this.qtd+1;
    }

    @Override
    public boolean estahVazia() {
        if (qtd == -1){
            return true;
        }else {
            return false;
        }
    }
}
