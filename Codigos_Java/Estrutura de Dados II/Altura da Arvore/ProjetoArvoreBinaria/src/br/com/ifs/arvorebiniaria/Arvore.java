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

}
