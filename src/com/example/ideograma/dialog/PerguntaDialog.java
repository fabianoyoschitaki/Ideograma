package com.example.ideograma.dialog;

import com.example.ideograma.activity.PerguntaActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class PerguntaDialog implements OnClickListener{
	
	private PerguntaActivity activity;
	
	public PerguntaDialog(PerguntaActivity activity) {
		this.activity = activity;
	}

	@Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which){
	        case DialogInterface.BUTTON_POSITIVE:
	            //activity.verificaResposta();
	            break;
	
	        case DialogInterface.BUTTON_NEGATIVE:
	            //No button clicked
	            break;
        }
    }
		

}
