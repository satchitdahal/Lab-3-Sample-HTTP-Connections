package edu.uw.tcss450.lab3_samplehttpconnections.ui.hello;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.uw.tcss450.lab3_samplehttpconnections.databinding.HelloFragmentBinding;

public class HelloFragment extends Fragment {

    private HelloViewModel mViewModel;

    private HelloFragmentBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(getActivity()).get(HelloViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = HelloFragmentBinding.inflate(inflater);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel.addResponseObserver(getViewLifecycleOwner(), result ->
                binding.textResponseOutput.setText(result.toString()));

        binding.buttonGet.setOnClickListener(button -> mViewModel.connectGet());
        binding.buttonPost.setOnClickListener(button -> mViewModel.connectPost());
    }

}
