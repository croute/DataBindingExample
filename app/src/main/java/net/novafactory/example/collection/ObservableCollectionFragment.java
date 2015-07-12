package net.novafactory.example.collection;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayMap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.novafactory.example.R;
import net.novafactory.example.databinding.ObservableCollectionBinding;

/**
 * @author nova
 */
public class ObservableCollectionFragment extends Fragment {

    public final ObservableArrayMap<String, Object> user = new ObservableArrayMap<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user.put("profile", ContextCompat.getDrawable(getActivity(), R.drawable.iu));
        user.put("firstName", "IU");
        user.put("lastName", "아이유");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.observable_collection, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ObservableCollectionBinding binding = DataBindingUtil.bind(view);

        binding.setUser(user);
        binding.observableCollectionBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.put("profile", ContextCompat.getDrawable(getActivity(), R.drawable.iu_producer));
                user.put("firstName", "Producer IU");
                user.put("lastName", "씐디");
            }
        });
        binding.observableCollectionBtnChangeAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.put("profile", ContextCompat.getDrawable(getActivity(), R.drawable.iu_album));
                user.put("firstName", "IU");
                user.put("lastName", "마음");
            }
        });
    }
}
