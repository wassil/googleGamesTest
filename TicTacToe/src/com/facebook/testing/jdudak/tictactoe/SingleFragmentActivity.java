package com.facebook.testing.jdudak.tictactoe;

import com.facebook.testing.jdudak.tictactoe.R;
import com.google.example.games.basegameutils.BaseGameActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public abstract class SingleFragmentActivity extends BaseGameActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment);
		
		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.fragment_container);
		
		if (fragment == null) {
			fragment = createFragment();
			fm.beginTransaction()
				.add(R.id.fragment_container,  fragment)
				.commit();
		}
	}
	
	protected abstract Fragment createFragment();

}
