package com.ewapps.receitasfavoritas.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ewapps.receitasfavoritas.R
import com.ewapps.receitasfavoritas.application.FavDishApplication
import com.ewapps.receitasfavoritas.databinding.FragmentAllDishesBinding
import com.ewapps.receitasfavoritas.databinding.FragmentFavoriteDishesBinding
import com.ewapps.receitasfavoritas.model.entities.FavDish
import com.ewapps.receitasfavoritas.view.activities.MainActivity
import com.ewapps.receitasfavoritas.view.adapters.FavDishAdapter
import com.ewapps.receitasfavoritas.viewmodel.DashboardViewModel
import com.ewapps.receitasfavoritas.viewmodel.FavDishViewModel
import com.ewapps.receitasfavoritas.viewmodel.FavDishViewModelFactory

class FavoriteDishesFragment : Fragment() {

    private var mBinding: FragmentFavoriteDishesBinding? = null

    private lateinit var dashboardViewModel: DashboardViewModel
    private val mFavDishViewModel: FavDishViewModel by viewModels {
        FavDishViewModelFactory((requireActivity().application as FavDishApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentFavoriteDishesBinding.inflate(inflater, container, false)
        return mBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        mFavDishViewModel.favoriteDishes.observe(viewLifecycleOwner) {
            dishes ->
            dishes.let{

                mBinding!!.rvFavoriteDishesList.layoutManager = GridLayoutManager(requireActivity(), 2)
                val favDishAdapter= FavDishAdapter(this@FavoriteDishesFragment)
                mBinding!!.rvFavoriteDishesList.adapter = favDishAdapter

                if(it.isNotEmpty()){
                    mBinding!!.rvFavoriteDishesList.visibility = View.VISIBLE
                    mBinding!!.tvNoFavoriteDishesAddedYet.visibility = View.GONE

                    favDishAdapter.dishesList(it)
                }else{
                    mBinding!!.rvFavoriteDishesList.visibility = View.GONE
                    mBinding!!.tvNoFavoriteDishesAddedYet.visibility = View.VISIBLE
                }
            }
        }
    }
    fun dishDetails(favDish: FavDish){
        findNavController().navigate(FavoriteDishesFragmentDirections.actionNavigationFavoriteDishesToDishDetailsFragment(
            favDish
        ))
        if(requireActivity() is MainActivity){
            (activity as MainActivity?)?.hideBottomNavigationView()
        }
    }

    override fun onResume() {
        super.onResume()
        if(requireActivity() is MainActivity){
            (activity as MainActivity?)?.showBottomNavigationView()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}