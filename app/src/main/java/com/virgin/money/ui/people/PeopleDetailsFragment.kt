package com.virgin.money.ui.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.virgin.money.databinding.FragmentPeopleDetailsBinding
import javax.inject.Inject

class PeopleDetailsFragment @Inject constructor(private val viewModelFactory: ViewModelProvider.Factory) : Fragment() {

    private val peopleViewModel: PeopleViewModel by viewModels { viewModelFactory }
    private var _binding: FragmentPeopleDetailsBinding? = null
    private val args: PeopleDetailsFragmentArgs by navArgs()
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPeopleDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = peopleViewModel
        peopleViewModel.setPeople(args.people)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
