package com.facebook.testing.jdudak.tictactoe.multiplayer;

import com.facebook.testing.jdudak.tictactoe.SingleFragmentActivity;

import android.support.v4.app.Fragment;


public class MultiplayerActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new MultiplayerFragment();
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
