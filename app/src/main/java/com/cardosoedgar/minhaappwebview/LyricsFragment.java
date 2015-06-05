package com.cardosoedgar.minhaappwebview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class LyricsFragment extends Fragment {

    Boolean isVideoPlaying;
    Button controlButton;

    public LyricsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_lyrics, container, false);

        isVideoPlaying = true;
        controlButton = (Button) fragmentView.findViewById(R.id.control_button);
        controlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePlayer();
            }
        });

        return fragmentView;
    }

    private void togglePlayer() {
        WebViewFragment webViewFragment = ((MainActivity)getActivity()).getWebViewFragment();
        if(isVideoPlaying) {
            controlButton.setBackgroundResource(R.drawable.ic_pause_white_48dp);
            isVideoPlaying = false;
            webViewFragment.play();
        } else {
            controlButton.setBackgroundResource(R.drawable.ic_play_arrow_white_48dp);
            isVideoPlaying = true;
            webViewFragment.pause();
        }
    }
}
