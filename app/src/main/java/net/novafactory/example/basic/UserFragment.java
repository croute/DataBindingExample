package net.novafactory.example.basic;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.novafactory.example.R;
import net.novafactory.example.databinding.UserBinding;

/**
 *
 * @author nova
 */
public class UserFragment extends Fragment {

    private User user;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = new User(ContextCompat.getDrawable(getActivity(), R.drawable.iu), "IU", null);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        UserBinding binding = DataBindingUtil.bind(view);
        binding.setUser(user);
    }
}
