package com.example.ideograma.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.ideograma.R;

public class PerdeuActivity extends Activity {

	private Button voltarTelaInicial;
	private Button jogarNovamente;
	private TextView pontosTextView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela_perdeu_activity);
		inicializaVariaveis();
	}

	private void inicializaVariaveis() {
		voltarTelaInicial = (Button) findViewById(R.id.voltar_tela_inicial);
		jogarNovamente = (Button) findViewById(R.id.jogar_novamente);
		pontosTextView = (TextView) findViewById(R.id.pontos);
		
		Intent intent = getIntent();
		int pontos = intent.getIntExtra("pontos", 0);
		
		pontosTextView.setText(String.valueOf(pontos));
		voltarTelaInicial.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				PerdeuActivity.this.startActivity(new Intent(PerdeuActivity.this, TelaInicialActivity.class));
				overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
				PerdeuActivity.this.finish();
			}
		});
		
		jogarNovamente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				PerdeuActivity.this.startActivity(new Intent(PerdeuActivity.this, PerguntaActivity.class));
				overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
				PerdeuActivity.this.finish();
			}
		});
	}
}
