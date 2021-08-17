package com.example.kotlindemoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kotlindemoapp.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding

    lateinit var myModel : MyVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val button1 = view.findViewById<Button>(R.id.btn_1)
        binding.btn1.setOnClickListener(View.OnClickListener {
            var fm = activity?.supportFragmentManager
            var ft = fm?.beginTransaction()
            ft?.replace(R.id.demo_fragment_container,SecondFragment())
            ft?.commit()
        })

        myModel = ViewModelProvider(requireActivity()).get(MyVM::class.java)

        binding.vmSaveBtn.setOnClickListener(View.OnClickListener {
            var name = binding.vmNameEt.text.toString()
            myModel.setData(name)
        })
    }
}