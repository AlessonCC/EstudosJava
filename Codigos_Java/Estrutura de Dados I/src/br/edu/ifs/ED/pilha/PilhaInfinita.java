package br.edu.ifs.ED.pilha;

public class PilhaInfinita<T> implements IPilha<T>{
    private T[] elementos;
    private int qtd;

    public PilhaInfinita(Class<T> dataType){
        qtd = -1;
        elementos = (T[]) java.lang.reflect.Array.newInstance(dataType, 10);
    }

    @Override
    public void empilhar(T valor) throws PilhaCheiaException {
        if (qtd < elementos.length - 1) {
            qtd++;
            elementos[qtd] = valor;
        }else {
            aumentarCapacidade();
            qtd++;
            elementos[qtd] = valor;
            //throw new PilhaCheiaException();
        }

    }

    @Override
    public T desempilhar() throws PilhaVaziaException {
        if (!estahVazia()){
            T aux =  elementos[qtd];
            qtd--;
            return aux;
        }else {
            throw new PilhaVaziaException();
        }
    }

    @Override
    public T getTopo() throws PilhaVaziaException {
        if (estahVazia()){
            throw new PilhaVaziaException();
        }
        return elementos[qtd];
    }

    @Override
    public int getQtd() {
        return this.qtd + 1;
    }

    @Override
    public boolean estahVazia() {
        if (qtd == -1){
            return true;
        }else {
            return false;
        }

    }

    public void aumentarCapacidade(){
        if (getQtd() >= elementos.length){
            T[] newVetor = (T[]) new Object[elementos.length + 5];

            int aux = 0;
            while (aux < elementos.length - 1){
                newVetor[aux] = elementos[aux];
                aux++;
            }
            this.elementos = newVetor;
        }
    }
}
