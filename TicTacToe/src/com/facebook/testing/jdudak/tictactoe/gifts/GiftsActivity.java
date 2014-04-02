package com.facebook.testing.jdudak.tictactoe.gifts;

import com.facebook.testing.jdudak.tictactoe.SingleFragmentActivity;

import android.support.v4.app.Fragment;


public class GiftsActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new GiftsFragment();
	}

	@Override
	public void onSignInFailed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSignInSucceeded() {
		// TODO Auto-generated method stub
		
	}
    
}
