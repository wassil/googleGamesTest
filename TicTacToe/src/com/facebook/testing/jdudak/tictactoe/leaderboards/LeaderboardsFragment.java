package com.facebook.testing.jdudak.tictactoe.leaderboards;

import com.facebook.testing.jdudak.tictactoe.Const;
import com.facebook.testing.jdudak.tictactoe.R;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.BaseGameActivity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class LeaderboardsFragment extends Fragment {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		setHasOptionsMenu(true);
		super.onCreate(savedInstanceState);
	}
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_leaderboards, container, false);
		
		getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);;
		
		final GoogleApiClient client = ((BaseGameActivity)getActivity()).getApiClient();
		
		
		//Games.Leaderboards.submitScore(client, getResources().getString(R.string.leaderboard_score), 1337);
		Button buttonShowLeaderboards = (Button)v.findViewById(R.id.buttonShowLeaderboards);
		buttonShowLeaderboards.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				startActivityForResult(
					Games.Leaderboards.getLeaderboardIntent(client, getResources().getString(R.string.leaderboard_score)),
					Const.REQUEST_LEADERBOARDS
				);
			}
		});
		
		return v;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				Log.v(Const.TAG, "back button");
				getActivity().finish();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
}