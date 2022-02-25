package br.com.ifs;

import br.com.ifs.arvorebiniaria.Arvore;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Arvore arvore = new Arvore();
		arvore.inserir(10);
		arvore.inserir(5);
		arvore.inserir(50);
		arvore.inserir(70);
		arvore.inserir(100);
		arvore.inserir(7);
		arvore.imprimirEmOrdem();
		System.out.println("__________");
		arvore.imprimirPosOrdem();
		System.out.println("__________");
		arvore.imprimirNLR();
		System.out.println("__________");
		System.out.println(arvore.heigthRoot());
		System.out.println("Fim");
	}
}
