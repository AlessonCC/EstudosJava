package br.edu.ifs.ED.fila;

public class FilaSequencial<T> implements IFila<T> {
    private int max;
    protected T[] dados;
    protected int qtd;
    public FilaSequencial(Class<T> dataType){
        this.max = 10;
        this.dados = (T[]) java.lang.reflect.Array.newInstance(dataType, this.max);
        this.qtd = -1;

    }
    public void incluir(T valor) throws FilaCheiaException {
        if(qtd == 9)
            throw new FilaCheiaException();
        else{
            qtd++;
            dados[qtd] = valor;
        }

    }
    public T remover() throws FilaVaziaException{
        if (estaVazia()) {
            throw new FilaVaziaException();
        }else{
            T temp = dados[0];
           dados[0] = null;
            for (int i = 0; i < qtd; i++) {
                dados[i] = dados[i + 1];
            }
           qtd--;
            return temp;
        }
    }
    public int getQtd() {
        return  this.qtd+1;
    }

    @Override
    public int getQtdMaxSuportada() {
        return this.max;
    }

    public boolean estaVazia() {
        if (qtd == -1)
            return true;
        else
            return false;
    }
    public void limpar(){
        this.qtd = -1;
        for (int i = 0; i < dados.length; i++) {
            dados[i] = null;
        }

    }

    public T visualizarProximo() throws FilaVaziaException{
        if (!estaVazia() )
            return dados[0];
        else
            throw new FilaVaziaException();
    }
    public void aumentarCapacidade(){
        if (getQtd() >= dados.length){
            T[] newVetor = (T[]) java.lang.reflect.Array.newInstance(Integer.class, this.dados.length + 5);
            this.max = this.dados.length + 5;
            int aux = 0;
            while (aux < this.dados.length){
                newVetor[aux] = this.dados[aux];
                aux++;
            }
            this.dados = newVetor;
        }
    }

}
