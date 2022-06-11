import java.util.ArrayList;
public class Vetor {
    private int soma = 0;
    ArrayList<Integer> subSet1;
    ArrayList<Integer> subSet2;
    ArrayList<Integer> subSet3;
    private boolean S1, S2, S3;

    public Vetor() {
        subSet1 = new ArrayList<>();
        subSet2 = new ArrayList<>();
        subSet3 = new ArrayList<>();
    }
    public boolean checkSum(int[] valores) {
        if (valores.length < 3) return false;

        for (Integer n : valores) {
            soma += n.intValue();
        }
        if (soma % 3 != 0) {
            System.out.println("Numeros não podem ser divididos em 3 particoes!");
            return false;
        }
        solve(valores, valores.length - 1, soma / 3, soma / 3, soma / 3);
        return true;
    }

    public boolean solve(int[] valores, int target, int subset1, int subset2, int subset3) {
        if (subset1 == 0 && subset2 == 0 && subset3 == 0) {
            return true;
        } else {
            S1 = false;
            if (subset1 - valores[target] >= 0 && target >= 0) {
                subSet1.add(valores[target]);
                S1 = solve(valores, target - 1, subset1 - valores[target], subset2, subset3);
            }
            S2 = false;
            if (!S1 && (subset2 - valores[target] >= 0 && target >= 0)) {
                subSet2.add(valores[target]);
                S2 = solve(valores, target - 1, subset1, subset2 - valores[target], subset3);
            }
            S3 = false;
            if ((!S1 && !S2) && (subset3 - valores[target] >= 0 && target >= 0)) {
                subSet3.add(valores[target]);
                S3 = solve(valores, target - 1, subset1, subset2, subset3 - valores[target]);
            }
        }

        return S1 || S2 || S3;
    }

    public void printar() {
        int n = subSet1.size();
        System.out.print("Particao 1: |");
        for (int i = 0; i < n; i++) {
            System.out.print(subSet1.get(i) + "|");
        }
        n = subSet2.size();
        System.out.print("\nParticao 2: |");
        for (int i = 0; i < n; i++) {
            System.out.print(subSet2.get(i) + "|");
        }
        n = subSet3.size();
        System.out.print("\nParticao 3: |");
        for (int i = 0; i < n; i++) {
            System.out.print(subSet3.get(i) + "|");
        }
        System.out.println("\nTem um erro nos Arrays, descubra se for bom!");
    }
}