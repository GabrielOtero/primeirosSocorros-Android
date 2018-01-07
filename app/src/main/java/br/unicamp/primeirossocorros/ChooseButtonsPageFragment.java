package br.unicamp.primeirossocorros;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class ChooseButtonsPageFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(
                R.layout.fragment_choose_button, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.choose_button)
    public void choose_buttom(){
        Log.d("CHOOSE", "BUTTON");
        Intent storyIntent = new Intent(getActivity(), QuizzActivity.class);
        startActivity(storyIntent);
    }
}
