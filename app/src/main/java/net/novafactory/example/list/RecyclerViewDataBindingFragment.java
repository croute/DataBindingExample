package net.novafactory.example.list;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.novafactory.example.R;
import net.novafactory.example.databinding.ObservableUserBinding;
import net.novafactory.example.observable.ObservableUser;

import java.util.Collections;

/**
 * @author nova
 */
public class RecyclerViewDataBindingFragment extends Fragment {

    private ObservableArrayList<ObservableUser> list;
    private RecyclerViewAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ObservableArrayList<>();
        list.add(new ObservableUser(ContextCompat.getDrawable(getActivity(), R.drawable.iu), "IU", "아이유"));
        list.add(new ObservableUser(ContextCompat.getDrawable(getActivity(), R.drawable.iu_album), "IU", "마음"));
        list.add(new ObservableUser(ContextCompat.getDrawable(getActivity(), R.drawable.iu_album), null, "마음"));
        list.add(new ObservableUser(ContextCompat.getDrawable(getActivity(), R.drawable.iu_producer), "IU Producer", "씐디"));
        list.add(new ObservableUser(ContextCompat.getDrawable(getActivity(), R.drawable.iu_producer), "IU Producer", null));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycler_view_data_binding, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);

        adapter = new RecyclerViewAdapter(list);

        // recyclerview
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_data_binding_rv_user);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        // shuffle button
        view.findViewById(R.id.recycler_view_data_binding_btn_shuffle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.shuffle(list);
                adapter.notifyDataSetChanged();
            }
        });
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<BindingHolder> {

        private ObservableArrayList<ObservableUser> list;

        public RecyclerViewAdapter(ObservableArrayList<ObservableUser> list) {
            this.list = list;
        }

        @Override
        public BindingHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.observable_user, viewGroup, false);
            return new BindingHolder(view);
        }

        @Override
        public void onBindViewHolder(BindingHolder holder, int position) {
            ObservableUser user = list.get(position);
            holder.getBinding().setUser(user);

            // Immediate Binding
            // holder.getBinding().executePendingBindings();
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public class BindingHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ObservableUserBinding binding;

        public BindingHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            binding.observableUserBtnChange.setOnClickListener(this);
            binding.observableUserBtnChangeAgain.setOnClickListener(this);
        }

        public ObservableUserBinding getBinding() {
            return binding;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.observable_user_btn_change:
                    binding.getUser().setProfile(ContextCompat.getDrawable(getActivity(), R.drawable.iu_producer));
                    binding.getUser().setFirstName("Producer IU");
                    binding.getUser().setLastName("씐디");
                    break;
                case R.id.observable_user_btn_change_again:
                    binding.getUser().setProfile(ContextCompat.getDrawable(getActivity(), R.drawable.iu_album));
                    binding.getUser().setFirstName("IU");
                    binding.getUser().setLastName("마음");
                    break;
            }
        }
    }
}
