package br.edu.ifs.ED.fila;

public class FilaInteirosInfinita  extends FilaSequencial<Integer> {
    public FilaInteirosInfinita() {
        super(Integer.class);

    }

    @Override
    public void incluir(Integer valor) {
        if(qtd == getQtdMaxSuportada()-1) {
            aumentarCapacidade();
            qtd++;
            dados[qtd] = valor;
        }else{
            qtd++;
            dados[qtd] = valor;
        }

    }

}
