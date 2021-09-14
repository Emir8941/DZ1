package com.example.dz1.ui.fragments.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dz1.databinding.FragmentDetailBinding;
import com.example.dz1.model.Model;
import com.example.dz1.ui.fragments.book.BookViewModel;

import org.jetbrains.annotations.NotNull;


public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;
    private BookViewModel viewModel;
    private Model model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
        initialize();
    }

    private void getData() {
        getParentFragmentManager().setFragmentResultListener("key", getViewLifecycleOwner(), (requestKey, result) -> {
            model = (Model) result.getSerializable("model");
            binding.imgDt.setImageResource(model.getImg());
            binding.textDt.setText(model.getTitle());
            binding.descriptionDt.setText(model.getDescription());

        });
    }

    private void initialize() {
        viewModel = new ViewModelProvider(requireActivity()).get(BookViewModel.class);

    }
}