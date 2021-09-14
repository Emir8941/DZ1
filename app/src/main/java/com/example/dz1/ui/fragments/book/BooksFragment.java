package com.example.dz1.ui.fragments.book;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.dz1.R;
import com.example.dz1.databinding.FragmentBooksBinding;
import com.example.dz1.utils.interfaces.OnItemClickListener;
import com.example.dz1.model.Model;
import com.example.dz1.ui.adapter.Adapter;

import java.util.ArrayList;
import java.util.List;

public class BooksFragment extends Fragment implements OnItemClickListener {
    private FragmentBooksBinding binding;
    private BookViewModel viewModel;
    private OnItemClickListener mListener;
    private int pos;
    List<Model> list = new ArrayList<>();
    Adapter adapter = new Adapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBooksBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @org.jetbrains.annotations.NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecycler();
        initialize();
        initView();
        setItem(mListener);
    }

    public void setItem(OnItemClickListener listener) {
        mListener = listener;
        adapter.setOnClick(position -> {
            pos = position;
            Bundle bundle = new Bundle();
            Model model = new Model(
                    adapter.list.get(position).getTitle()
                    , adapter.list.get(position).getDescription()
                    , adapter.list.get(position).getImg());
            bundle.putSerializable("model", model);
            getParentFragmentManager().setFragmentResult("key", bundle);
            close();
        });
    }

    private void close() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        navController.navigate(R.id.action_booksFragment_to_detailFragment);
    }

    private void setupRecycler() {
        binding.rvTask.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvTask.setAdapter(adapter);
    }


    public void initView() {
        binding.btnFillIn.setOnClickListener(v -> {
            viewModel.fetch();
            viewModel.getBookList();
        });
    }

    private void initialize() {
        viewModel = new ViewModelProvider(requireActivity()).get(BookViewModel.class);
        viewModel.mutableLiveData.observe(getViewLifecycleOwner(), models -> {
            binding.btnFillIn.setVisibility(View.GONE);
            adapter.addList(models);
        });
    }

    @Override
    public void onClick(int position) {

    }
}