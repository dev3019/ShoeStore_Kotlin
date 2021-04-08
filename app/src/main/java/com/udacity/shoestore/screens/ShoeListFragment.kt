package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.SharedViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListFragment : Fragment() {

    private lateinit var viewModel: SharedViewModel
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        binding.addDetailButton.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)

//        displayList()
//        if (!(viewModel.shoeList.value.isNullOrEmpty())){
//            viewModel.shoeList.observe(this, Observer {
//                it.forEach(
////                    DataBindingUtil.inflate(inflater,R.layout.item_layout,container,false)/
//                )
//            })
//            binding.shoeListLayout.addView()

//        }

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.mi_logout, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            view!!.findNavController()
        ) || super.onOptionsItemSelected(item)
    }


//    fun displayList(){
//
//        if (!(viewModel.shoeList.value.isNullOrEmpty())){
//            viewModel.shoeList.observe(this, Observer {
//                it.forEach(
//                    DataBindingUtil.inflate(layoutInflater,R.layout.item_layout,binding)
//                )
//            })
////            binding.shoeListLayout.addView()
//
//        }
//    }

}