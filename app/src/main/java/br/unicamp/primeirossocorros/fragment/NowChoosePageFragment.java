package br.unicamp.primeirossocorros.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.unicamp.primeirossocorros.R;
import br.unicamp.primeirossocorros.activity.QuizzActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class NowChoosePageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(
                R.layout.fragment_choose_button, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.now_respond)
    public void nowRespond() {
        Intent storyIntent = new Intent(getActivity(), QuizzActivity.class);
        startActivity(storyIntent);
    }

    @OnClick(R.id.back_to_menu)
    public void backToMenu() {
        getActivity().onBackPressed();
    }
}
