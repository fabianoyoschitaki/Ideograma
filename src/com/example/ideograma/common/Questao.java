package com.example.ideograma.common;

public class Questao {
	private String [] respostas = new String[4];
	private String respostaCerta;
	private String nomeImagem;
	
	public String[] getRespostas() {
		return respostas;
	}
	public void setRespostas(String[] respostas) {
		this.respostas = respostas;
	}
	public String getRespostaCerta() {
		return respostaCerta;
	}
	public void setRespostaCerta(String respostaCerta) {
		this.respostaCerta = respostaCerta;
	}
	public String getNomeImagem() {
		return nomeImagem;
	}
	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}
}
