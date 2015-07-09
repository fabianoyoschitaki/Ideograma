package com.example.ideograma.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.ideograma.R;

public class TelaInicialActivity extends Activity {

	private Button iniciarButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela_inicial_activity);
		inicializaVariaveis();
	}
	
	private void inicializaVariaveis() {
		iniciarButton = (Button)findViewById(R.id.iniciar_button);
		//iniciarButton.setOnClickListener(new IniciaJogoListener(this));
		iniciarButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				chamaTelaPergunta();
			}
		});
	}
	
	public void chamaTelaPergunta(){
		Intent chamaTelaIntent = new Intent(this, PerguntaActivity.class);
		//animação de transição entre chamadas de intent
		//chamaTelaIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		this.startActivity(chamaTelaIntent);
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
	}
}
