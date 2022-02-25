package br.com.ifs.arvorebiniaria;


public class Arvore {

	private No raiz;

	private No getRaiz() {
		return raiz;
	}

	public void inserir(Integer info) {
		No no = new No();
		no.setInfo(info);
		if (vazia()) {
			raiz = no;
		} else {
			inserirInterno(raiz, no);
		}
	}
	
	private void inserirInterno(No pai, No novoNo) {
		if (novoNo.getInfo() < pai.getInfo()) {
			if (pai.getEsq() == null) {
				pai.setEsq(novoNo);
			} else {
				inserirInterno(pai.getEsq(), novoNo);
			}
		} else {
			if (pai.getDir() == null) {
				pai.setDir(novoNo);
			} else {
				inserirInterno(pai.getDir(), novoNo);
			}
		}
		pai = balance(pai);
	}
	
	public void imprimirEmOrdem() {
		if (vazia()) {
			System.out.println("Arvore vazia!");
		} else {
			imprimirOrdem(raiz);
		}
	}

	public void imprimirPosOrdem() {
		if (vazia()) {
			System.out.println("Arvore vazia!");
		} else {
			imprimirPosOrdem(raiz);
		}
	}

	public void imprimirNLR() {
		if (vazia()) {
			System.out.println("Arvore vazia!");
		} else {
			imprimirNLR(raiz);
		}
	}
	
	private void imprimirOrdem(No no) {
		if (no != null) {
			imprimirOrdem(no.getEsq());
			System.out.print(no.getInfo());
			imprimirOrdem(no.getDir());
		}
		//System.out.println("");
	}

	private void imprimirPosOrdem(No no) {
		if (no != null) {
			imprimirPosOrdem(no.getDir());
			System.out.println(no.getInfo());
			imprimirPosOrdem(no.getEsq());
		}
	}

	private void imprimirNLR(No no) {
		if (no != null) {
			System.out.println(no.getInfo());
			imprimirNLR(no.getEsq());
			imprimirNLR(no.getDir());
		}
	}
	
	public boolean vazia() {
		return raiz == null;
	}
	
	private void setRaiz(No raiz) {
		this.raiz = raiz;
	}
	//  Altura de um NO
	public int height(No temp){
		return temp == null ? -1 : heigthRoot(temp);
	}

	// Altura da Arvore
	public int heigthRoot(){
		if(!vazia()){
			return heigthRoot(raiz);
		}
		return -1;
	}
	private int heigthRoot(No temp){
		if(temp != null) {
			int lRoot = heigthRoot(temp.getEsq());
			int rRoot = heigthRoot(temp.getDir());
			if (lRoot > rRoot) return lRoot + 1;
			else return rRoot + 1;
		}
		return -1;
	}
	//  Verificar valor para o tipo de balanceamento
	public int balanceValue(No temp){
		return heigthRoot(temp.getEsq()) - heigthRoot(temp.getDir());
	}

	//  Maior valor
	public int maxHeight(int ladoEsquerdo, int ladoDireito){
		return Math.max(ladoEsquerdo, ladoDireito);
	}


	//  Balanceamento
	public No balance(No temp){
		if (balanceValue(temp) == 2){
			if (balanceValue(temp.getEsq()) > 0) {
				System.out.println("DESBALANCEADA!\nROTAÇÃO SIMPLES À DIREITA");
				temp = simpleRightRotation(temp);
			} else {
				System.out.println("DESBALANCEADA!\nROTAÇÃO DUPLA ESQUERDA-DIREITA");
				temp = doubleLeftRightRotation(temp);
			}
		} else if (balanceValue(temp) == -2) {
			if (balanceValue(temp.getDir()) < 0) {
				System.out.println("DESBALANCEADA!\nROTAÇÃO SIMPLES À ESQUERDA");
				temp = simpleLeftRotation(temp);
			} else {
				System.out.println("DESBALANCEADA!\nROTAÇÃO DUPLA DIREITA-ESQUERDA");
				temp = doubleRightLeftRotation(temp);
			}
		}
		temp.setAltura( maxHeight(height(temp.getEsq()), height(temp.getDir())) +1);
		return temp;
	}

	//  Rotação Simples Direita
	private No simpleRightRotation(No temp){
		No auxiliar = temp.getEsq();
		temp.setEsq(auxiliar.getDir());
		auxiliar.setDir(temp);

		temp.setAltura(maxHeight(height(temp.getEsq()), height(temp.getDir()))+1);
		auxiliar.setAltura(maxHeight(height(auxiliar.getEsq()), temp.getAltura())+1);

		if (temp == raiz) {
			setRaiz(auxiliar);
			return raiz;
		}
		return auxiliar;
	}

	//  Rotação Simples Esquerda
	private No simpleLeftRotation(No temp){
		No auxiliar = temp.getDir();
		temp.setDir(auxiliar.getEsq());
		auxiliar.setEsq(temp);

		temp.setAltura(maxHeight(height(temp.getEsq()), height(temp.getDir()))+1);
		auxiliar.setAltura(maxHeight(height(auxiliar.getEsq()), temp.getAltura())+1);

		if (temp == raiz) {
			setRaiz(auxiliar);
			return raiz;
		}
		return auxiliar;
	}

	//  Rotação Dupla Esquerda-Direita
	private No doubleLeftRightRotation(No temp){
		temp.setEsq(simpleLeftRotation(temp.getEsq()));
		return simpleRightRotation(temp);
	}

	//  Rotação Dupla Direita-Esquerda
	private No doubleRightLeftRotation(No temp){
		temp.setDir(simpleRightRotation(temp.getDir()));
		return  simpleLeftRotation(temp);
	}


}
