package com.facebook.testing.jdudak.tictactoe.achievements;

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


public class AchievementsFragment extends Fragment {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		setHasOptionsMenu(true);
		super.onCreate(savedInstanceState);
	}
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_achievements, container, false);
		
		getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);;
		
		final GoogleApiClient client = ((BaseGameActivity)getActivity()).getApiClient();
		
		Button buttonAchievement = (Button)v.findViewById(R.id.buttonClickAchievement);
		buttonAchievement.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				Games.Achievements.unlock(client, getResources().getString(R.string.achievement_click_button_once));
				Games.Achievements.increment(client, getResources().getString(R.string.achievement_clicked_button_10_times), 1);
				Games.Achievements.increment(client, getResources().getString(R.string.achievement_clicked_button_20_times), 1);
				Games.Achievements.increment(client, getResources().getString(R.string.achievement_clicked_button_30_times), 1);
				Games.Achievements.increment(client, getResources().getString(R.string.achievement_clicked_button_40_times), 1);
				Games.Achievements.increment(client, getResources().getString(R.string.achievement_clicked_button_50_times), 1);
			}
		});
		Button buttonShowAchievements = (Button)v.findViewById(R.id.buttonShowAchievements);
		buttonShowAchievements.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				startActivityForResult(
					Games.Achievements.getAchievementsIntent(client), 
					Const.REQUEST_ACHIEVEMENTS
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