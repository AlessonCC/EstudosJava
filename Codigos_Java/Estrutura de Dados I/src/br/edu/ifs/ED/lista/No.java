package br.edu.ifs.ED.lista;

public class No<T> {
    public T dado;
    public No prox;

    public No(T dado){
        this.dado = dado;
        prox = null;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
}
