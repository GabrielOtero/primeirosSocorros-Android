package br.unicamp.primeirossocorros.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.unicamp.primeirossocorros.R;
import br.unicamp.primeirossocorros.util.LocaleHelper;
import br.unicamp.primeirossocorros.util.StoryType;
import butterknife.BindView;
import butterknife.ButterKnife;


public class SlidePageFragment extends Fragment {

    private StoryType storyType;
    private int position;

    @BindView(R.id.text)
    TextView textView;

    @BindView(R.id.storyImage)
    ImageView storyImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);

        ButterKnife.bind(this, view);


        String locale = LocaleHelper.getLanguage(getActivity());

        String imageResource = storyType.getDescription() + String.valueOf(position) + locale;
        int id = getResources().getIdentifier(imageResource, "drawable",
                getActivity().getPackageName());

        storyImage.setImageResource(id);

        return view;
    }

    public void setStoryType(StoryType storyType) {
        this.storyType = storyType;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
