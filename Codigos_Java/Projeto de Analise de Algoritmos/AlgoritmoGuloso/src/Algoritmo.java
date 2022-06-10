import java.util.ArrayList;

public class Algoritmo {

    /* Algoritmo guloso: Considere um problema onde é necessário alocar atividades,
    em um mesmo dia, em uma única sala de conferência Considere o conjunto de
    atividades ordenadas abaixo:*/

    //Para verificar a sequencia de numeros e mostrar qual melhor tempo de utilização da sala

    private int[] s = {1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
    private int[] f = {4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
    ArrayList<Integer> posicoes;
    private int n, k;

    public Algoritmo(){
        posicoes = new ArrayList<>();
    }

    public void selector(){
        n = s.length;
        posicoes.add(0);
        k = 0;
        for (int m = 2; m < n; m++) {
            if(s[m] >= f[k]){
                posicoes.add(m);
                k = m;
            }
        }
    }
    public void printar(){
        int tamanho = posicoes.size();
        for (int i = 0; i < tamanho; i++) {
            System.out.println("a" + (posicoes.get(i)+1) + " => " + "s: " + s[posicoes.get(i)]+ ", f: " + f[posicoes.get(i)]);
        }
    }
}