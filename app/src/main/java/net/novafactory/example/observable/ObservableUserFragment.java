package net.novafactory.example.observable;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.novafactory.example.R;
import net.novafactory.example.databinding.ObservableUserBinding;

/**
 * @author nova
 */
public class ObservableUserFragment extends Fragment {

    private ObservableUser user;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = new ObservableUser(ContextCompat.getDrawable(getActivity(), R.drawable.iu), "IU", "아이유");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.observable_user, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ObservableUserBinding binding = DataBindingUtil.bind(view);
        binding.setUser(user);
        binding.observableUserBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setProfile(ContextCompat.getDrawable(getActivity(), R.drawable.iu_producer));
                user.setFirstName("Producer IU");
                user.setLastName("씐디");
            }
        });
        binding.observableUserBtnChangeAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setProfile(ContextCompat.getDrawable(getActivity(), R.drawable.iu_album));
                user.setFirstName("IU");
                user.setLastName("마음");
            }
        });
    }
}
