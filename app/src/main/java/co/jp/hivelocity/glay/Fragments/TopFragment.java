package co.jp.hivelocity.glay.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.jp.hivelocity.R;
import co.jp.hivelocity.databinding.FragmentTopBinding;

public class TopFragment extends Fragment {

    private FragmentTopBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTopBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }
}