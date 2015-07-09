package com.example.ideograma.activity;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ideograma.R;
import com.example.ideograma.common.IdeogramaQuestionSorter;
import com.example.ideograma.common.Questao;

public class PerguntaActivity extends Activity implements OnClickListener{

	private Button opcao1;
	private Button opcao2;
	private Button opcao3;
	private Button opcao4;
	private ImageView imagem;
	private TextView pergunta;
	
	private String respostaEscolhida;
	private String respostaCerta;
	private int numeroQuestao = 0;
	private List<Questao> questoes;
	
	private int pontos = 0;
	
	Animation acertouPerguntaAnimation;
	Animation errouPerguntaAnimation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pergunta_activity);
		inicializaVariaveis();
		iniciaRodada();
	}

	/**
	 * Carregando as variáveis do jogo
	 * TODO verificar como fazer para não resetar ao deitar a tela
	 */
	private void inicializaVariaveis() {
		
		questoes = IdeogramaQuestionSorter.getQuestoes();
		
		pergunta = (TextView) findViewById(R.id.numeroPergunta);
		opcao1 = (Button) findViewById(R.id.opcao1);
		opcao2 = (Button) findViewById(R.id.opcao2);
		opcao3 = (Button) findViewById(R.id.opcao3);
		opcao4 = (Button) findViewById(R.id.opcao4);
		imagem = (ImageView) findViewById(R.id.ideograma);
		
		opcao1.setOnClickListener(this);
		opcao2.setOnClickListener(this);
		opcao3.setOnClickListener(this);
		opcao4.setOnClickListener(this);

		errouPerguntaAnimation = AnimationUtils.loadAnimation(PerguntaActivity.this,R.anim.errou_pergunta);
		errouPerguntaAnimation.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {}
			
			@Override
			public void onAnimationRepeat(Animation animation) {}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
			}
		});
		
		acertouPerguntaAnimation = AnimationUtils.loadAnimation(PerguntaActivity.this,R.anim.acertou_pergunta);
		acertouPerguntaAnimation.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
			}
			@Override
			public void onAnimationEnd(Animation animation) {
				iniciaRodada();
			}
		});
	}

	/**
	 * Método que configura a próxima rodada
	 */
	private void iniciaRodada() {
		if (numeroQuestao < questoes.size()){
			Questao questao = questoes.get(numeroQuestao);
			
			pergunta.setText("Pergunta " + (numeroQuestao + 1) + " de " + questoes.size());
			
			numeroQuestao++;
	
			respostaCerta = questao.getRespostaCerta();
			opcao1.setText(questao.getRespostas()[0]);
			opcao2.setText(questao.getRespostas()[1]);
			opcao3.setText(questao.getRespostas()[2]);
			opcao4.setText(questao.getRespostas()[3]);
			
			try {
				Resources resources = getApplicationContext().getResources();
				final int resourceId = resources.getIdentifier(
					questao.getNomeImagem(), 
					"drawable", 
					getApplicationContext().getPackageName());
					
				imagem.setImageDrawable(resources.getDrawable(resourceId));
			} catch (Exception e){
				Toast.makeText(getApplicationContext(), "Erro:" + e.getMessage(), Toast.LENGTH_SHORT).show();
			}
		} else {
			Toast.makeText(getApplicationContext(), "Perguntas acabaram!", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		respostaEscolhida = (String) ((Button) v).getText();
		
		/** 
		 * Diálogo questionando se está certo disso
		 
		PerguntaDialog perguntaDialog = new PerguntaDialog(this);
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Tem certeza disso? Opção: " + respostaEscolhida)
			.setPositiveButton("Sim", perguntaDialog)
		    .setNegativeButton("Não", perguntaDialog).show();
		
		**/
				
		verificaResposta(v);
	}

	/**
	 * Método que verifica se o botão 
	 * clicado está com a opção correta
	 * 
	 * @param botao
	 */
	private void verificaResposta(View botao) {
		if (respostaEscolhida.equals(respostaCerta)){
			pontos++;
			botao.startAnimation(acertouPerguntaAnimation);
		} else {
			botao.startAnimation(errouPerguntaAnimation);
			Intent perdeuIntent = new Intent(this, PerdeuActivity.class);
			perdeuIntent.putExtra("pontos", pontos);
			this.startActivity(perdeuIntent);
			overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
			this.finish();
		}
	}
	
	/**public void verificaResposta(){
		if (respostaEscolhida.equals(respostaCerta)){
			Toast.makeText(getApplicationContext(), "Certa resposta!", Toast.LENGTH_SHORT).show();
			iniciaRodada();
		} else {
			Toast.makeText(getApplicationContext(), "Você perdeu! Resposta certa era " + respostaCerta, Toast.LENGTH_SHORT).show();
		}
	}**/

}
