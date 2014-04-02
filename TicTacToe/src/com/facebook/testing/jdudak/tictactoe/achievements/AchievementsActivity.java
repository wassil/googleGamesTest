package com.facebook.testing.jdudak.tictactoe.achievements;

import com.facebook.testing.jdudak.tictactoe.SingleFragmentActivity;

import android.support.v4.app.Fragment;


public class AchievementsActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new AchievementsFragment();
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
