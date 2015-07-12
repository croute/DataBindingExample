package net.novafactory.example.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.novafactory.example.R;
import net.novafactory.example.basic.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author nova
 */
public class RecyclerViewFragment extends Fragment {

    private List<User> list;
    private RecyclerViewAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
        list.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.iu), "IU", "아이유"));
        list.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.iu_album), "IU", "마음"));
        list.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.iu_producer), "IU Producer", "씐디"));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycler_view, container, false);
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
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_rv_user);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        // shuffle button
        view.findViewById(R.id.recycler_view_btn_shuffle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.shuffle(list);
                adapter.notifyDataSetChanged();
            }
        });
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

        private List<User> list;

        public RecyclerViewAdapter(List<User> list) {
            this.list = list;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user, viewGroup, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            User user = list.get(position);
            holder.ivProfile.setImageDrawable(user.getProfile());
            holder.tvFirstName.setText(user.getFirstName());
            holder.tvLastName.setText(user.getLastName());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivProfile;
        TextView tvFirstName;
        TextView tvLastName;

        public ViewHolder(View itemView) {
            super(itemView);

            ivProfile = (ImageView) itemView.findViewById(R.id.user_iv_profile);
            tvFirstName = (TextView) itemView.findViewById(R.id.user_tv_first_name);
            tvLastName = (TextView) itemView.findViewById(R.id.user_tv_last_name);
        }
    }
}
