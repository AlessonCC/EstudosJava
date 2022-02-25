package br.com.ifs.arvorebiniaria;

public class No  {

	private Integer info;
	private No esq, dir;

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	private int altura;
	
	public Integer getInfo() {
		return info;
	}
	public void setInfo(Integer info) {
		this.info = info;
	}
	public No getEsq() {
		return esq;
	}
	public void setEsq(No esq) {
		this.esq = esq;
	}
	public No getDir() {
		return dir;
	}
	public void setDir(No dir) {
		this.dir = dir;
	}
}
