package com.example.sakura.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.sakura.R
import com.example.sakura.adapters.FirstAdapter
import com.example.sakura.databinding.FragmentHomeBinding
import com.example.sakura.feel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val data=listOf(
            feel("Спокойным",R.drawable.lotos),
            feel("Расслабленным",R.drawable.lotos),
            feel("Сосредоточеным",R.drawable.lotos),
            feel("Взволнованным",R.drawable.lotos),
            feel("Спокойным",R.drawable.lotos),
            feel("Расслабленным",R.drawable.lotos),
            feel("Сосредоточеным",R.drawable.lotos),
            feel("Взволнованным",R.drawable.lotos)
        )

        val recyclerView:RecyclerView = root.findViewById(R.id.feel_recycler)
        recyclerView.adapter = FirstAdapter(requireContext(),data)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}