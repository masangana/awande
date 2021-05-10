package com.pthat.awande.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.pthat.awande.EtablissementModel
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
        val EtablissementList = arrayListOf<EtablissementModel>();

        // création de la premier etablissement de la liste
        EtablissementList.add(EtablissementModel(

                "hoberge",
                "lieu de repos avec espace sur jardin et terrasse",
                "mont-ngafula",
                "+243820943937",
                "https://cdn.pixabay.com/photo/2012/11/21/10/24/building-66789_1280.jpg",
                true

        ))

        // création de la premier etablissement de la liste
        EtablissementList.add(EtablissementModel(

                "Makambo",
                "lieu de repos avec espace, Restaurant",
                "mont-ngafula",
                "+243820943937",
                "https://cdn.pixabay.com/photo/2014/07/21/19/20/lobby-398845_1280.jpg",
                false

        ))

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