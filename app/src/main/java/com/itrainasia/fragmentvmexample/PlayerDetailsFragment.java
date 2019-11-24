package com.itrainasia.fragmentvmexample;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;


public class PlayerDetailsFragment extends Fragment {
    private PlayerViewModel viewModel;

    private TextView name;
    private TextView age;
    private TextView country;
    private TextView titles;
    private TextView rank;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this.getActivity()).get(PlayerViewModel.class);

        viewModel.getSelectedPlayer().observe(this, item -> {
            displayDetails(viewModel.getPlayerDetails(item));
        });
    }

    public void displayDetails(Player player){
        name.setText(player.getName());
        age.setText(""+player.getAge());
        country.setText(player.getCountry());
        titles.setText(""+player.getTitles());
        rank.setText(""+player.getRank());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_details,
                container, false);

        name = view.findViewById(R.id.name);
        age = view.findViewById(R.id.age);
        country = view.findViewById(R.id.country);
        titles = view.findViewById(R.id.titles);
        rank = view.findViewById(R.id.rank);

        return view;
    }
}