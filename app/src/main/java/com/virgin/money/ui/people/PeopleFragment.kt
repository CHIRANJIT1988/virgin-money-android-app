package com.virgin.money.ui.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.virgin.money.ui.adapter.PeopleAdapter
import com.virgin.money.databinding.FragmentPeopleBinding
import javax.inject.Inject

class PeopleFragment @Inject constructor(private val viewModelFactory: ViewModelProvider.Factory): Fragment() {

    private val peopleViewModel: PeopleViewModel by viewModels { viewModelFactory }
    private var _binding: FragmentPeopleBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: PeopleAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPeopleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPeopleAdapter()
        binding.viewModel = peopleViewModel
        peopleViewModel.getPeoples()
        observePeopleLiveData()
    }

    private fun initPeopleAdapter() {
        // this creates a vertical layout Manager
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        // This will pass the ArrayList to our Adapter
        adapter = PeopleAdapter(onPeopleClickListener = {
            val action = PeopleFragmentDirections.actionNavigationPeopleToNavigationPeopleDetails(people = it)
            navigate(action)
        })
        // Setting the Adapter with the recyclerview
        binding.recyclerview.adapter = adapter
    }

    private fun observePeopleLiveData() {
        peopleViewModel.peoples.observe(requireActivity()) { result ->
            if(result.isSuccess()) {
                result.data?.let { adapter.setPeoples(it) }
            }
        }
        peopleViewModel.loadingVisibility.observe(requireActivity()) { result ->
            when {
                result == View.GONE -> binding.progress.visibility = View.GONE
                result == View.VISIBLE -> binding.progress.visibility = View.VISIBLE
            }
        }
        peopleViewModel.error.observe(requireActivity()) { result ->
            if(result) {
                Toast.makeText(requireContext(), "Failed to Load", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }
}
