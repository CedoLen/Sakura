package com.example.sakura.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.sakura.Network.MyInterface
import com.example.sakura.Network.MyRetrofit
import com.example.sakura.Network.feelings
import com.example.sakura.R
import com.example.sakura.adapters.FirstAdapter
import com.example.sakura.databinding.FragmentHomeBinding
import com.example.sakura.feel
import retrofit2.Call
import retrofit2.Response

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

        val recyclerView: RecyclerView = root.findViewById(R.id.feel_recycler)
        val ret = MyRetrofit().getRetrofit()
        val inter = ret.create(MyInterface::class.java)
        val call = inter.getFeelings()
            .enqueue(object : retrofit2.Callback<feelings> {
                override fun onResponse(call: Call<feelings>, response: Response<feelings>) {
                    recyclerView.adapter = FirstAdapter(requireContext(), response.body()!!)
                }

                override fun onFailure(call: Call<feelings>, t: Throwable) {
                    Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

            })

        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}