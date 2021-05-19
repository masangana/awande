package com.pthat.awande.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.pthat.awande.EtablissementModel
import com.pthat.awande.EtablissementRepository.Singleton.EtablissementList
import com.pthat.awande.MainActivity
import com.pthat.awande.R
import com.pthat.awande.adapter.EtablissementAdaptater
import com.pthat.awande.adapter.EtablissementAdaptaterVertical
import com.pthat.awande.adapter.EtablissementItemDecoration

class HomeFragment(
    private val context : MainActivity
) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)

         //creer une liste pour stocker les etablissements


        //Appel de la vue horizontal de la section derniers leiux
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = EtablissementAdaptater(context, EtablissementList, R.layout.item_horizontal_etablissement)

        //Appel de la vue verticale de la section Nos lieux
        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter = EtablissementAdaptater(context, EtablissementList, R.layout.item_vertical_etablissment)
        verticalRecyclerView.addItemDecoration(EtablissementItemDecoration())

        return view
    }
}