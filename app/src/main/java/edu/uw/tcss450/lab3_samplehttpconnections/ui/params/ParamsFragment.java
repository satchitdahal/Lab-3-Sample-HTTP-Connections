package edu.uw.tcss450.lab3_samplehttpconnections.ui.params;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.uw.tcss450.lab3_samplehttpconnections.databinding.ParamsFragmentBinding;

public class ParamsFragment extends Fragment {

    private ParamsFragmentBinding binding;

    private ParamsViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(getActivity()).get(ParamsViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = ParamsFragmentBinding.inflate(inflater);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel.addResponseObserver(getViewLifecycleOwner(), response ->
                binding.textResponseOutput.setText(response.toString()));

        binding.buttonGet.setOnClickListener(button ->
                mViewModel.connectGet(binding.editMessage.getText().toString()));

        binding.buttonPost.setOnClickListener(button ->
                mViewModel.connectPost(binding.editMessage.getText().toString()));
    }

}
