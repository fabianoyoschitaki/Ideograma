package com.example.ideograma.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class IdeogramaQuestionSorter {
	private static List<Questao> questoes;
	private static Map<String, String> todosIdeogramas;

	static {
		questoes = new ArrayList<Questao>();
		todosIdeogramas = new HashMap<String,String>();
		todosIdeogramas.put("Amizade", "amizade");
		todosIdeogramas.put("Amor","amor");
		todosIdeogramas.put("Apoio","apoio");
		todosIdeogramas.put("Autoridade","autoridade");
		todosIdeogramas.put("Beleza","beleza");
		todosIdeogramas.put("Coracao","coracao");
		todosIdeogramas.put("Desejo","desejo");
		todosIdeogramas.put("Destino","destino");
		todosIdeogramas.put("Deus","deus");
		todosIdeogramas.put("Fe","fe");
		todosIdeogramas.put("Felicidade","felicidade");
		todosIdeogramas.put("Forca","forca");
		todosIdeogramas.put("Fortuna","fortuna");
		
		Random rand = new Random();
		List<String> chaves = new ArrayList<String>(todosIdeogramas.keySet());
		for (String chave : chaves) {
			Questao questao = new Questao();
			questao.setRespostaCerta(chave);
			questao.setNomeImagem(todosIdeogramas.get(chave));
			int posicaoResposta = rand.nextInt(4);
			questao.getRespostas()[posicaoResposta] = chave;
			
			List<String> respostasErradas = new ArrayList<String>();
			for (int cont = 0; cont <= 3; cont++){
				if (cont != posicaoResposta){
					boolean achouRespostaErrada = false;
					while (!achouRespostaErrada){
						int qualquerRespostaErrada = rand.nextInt(chaves.size());
						if (!chaves.get(qualquerRespostaErrada).equals(chave)
						 && !respostasErradas.contains(chaves.get(qualquerRespostaErrada))){
							questao.getRespostas()[cont] = chaves.get(qualquerRespostaErrada);
							respostasErradas.add(chaves.get(qualquerRespostaErrada));
							achouRespostaErrada = true;
						}
					}
				}
			}
			questoes.add(questao);
		}
	}

	public static List<Questao> getQuestoes() {
		return questoes;
	}

	public static void setQuestoes(List<Questao> questoes) {
		IdeogramaQuestionSorter.questoes = questoes;
	}
}
