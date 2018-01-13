package br.unicamp.primeirossocorros.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.unicamp.primeirossocorros.R;
import br.unicamp.primeirossocorros.activity.MenuActivity;
import br.unicamp.primeirossocorros.activity.QuizzActivity;
import br.unicamp.primeirossocorros.util.Constants;
import br.unicamp.primeirossocorros.util.StoryType;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class NowChoosePageFragment extends Fragment {

    private StoryType storyType;

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
        storyIntent.putExtra(Constants.STORY_TYPE, storyType);
        startActivity(storyIntent);
    }


    @OnClick(R.id.back_to_menu)
    public void backToMenu() {
        Intent intent = new Intent(getActivity(), MenuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void setStoryType(StoryType storyType) {
        this.storyType = storyType;
    }
}
