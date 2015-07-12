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
import net.novafactory.example.databinding.ObservableFieldsUserBinding;

/**
 * @author nova
 */
public class ObservableFieldsUserFragment extends Fragment {

    private ObservableFieldsUser user;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = new ObservableFieldsUser();
        user.profile.set(ContextCompat.getDrawable(getActivity(), R.drawable.iu));
        user.firstName.set("IU");
        user.lastName.set("아이유");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.observable_fields_user, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ObservableFieldsUserBinding binding = DataBindingUtil.bind(view);
        binding.setUser(user);


        binding.observableFieldsUserBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.profile.set(ContextCompat.getDrawable(getActivity(), R.drawable.iu_producer));
                user.firstName.set("Producer IU");
                user.lastName.set("씐디");
            }
        });
        binding.observableFieldsUserBtnChangeAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.profile.set(ContextCompat.getDrawable(getActivity(), R.drawable.iu_album));
                user.firstName.set("IU");
                user.lastName.set("마음");
            }
        });
    }
}
