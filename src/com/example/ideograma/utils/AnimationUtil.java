package com.example.ideograma.utils;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;

public class AnimationUtil {

	/**
	 * Método que inicia uma animação em uma view qualquer
	 * 
	 * @param v
	 * @param resId
	 * @param nextPuzzleOnEnd
	 */
//	private void startAnimation(View v, int resId, Boolean nextPuzzleOnEnd) {
//		Animation anim;
//
//		if (v != null) { // can be null, after change of orientation
//			anim = AnimationUtils.loadAnimation(this.getContext(), resId);
//			anim.setFillAfter(false);
//			v.setAnimation(anim);
//			if (nextPuzzleOnEnd) {
//				anim.setAnimationListener(new AnimationListener() {
//					public void onAnimationStart(Animation anim) {
//					};
//
//					public void onAnimationRepeat(Animation anim) {
//					};
//
//					public void onAnimationEnd(Animation anim) {
//						nextPuzzle();
//					};
//				});
//			}
//			v.startAnimation(anim);
//		}
//	}
}
