package com.pthat.awande.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pthat.awande.EtablissementModel
import com.pthat.awande.MainActivity
import com.pthat.awande.R

class EtablissementAdaptater(
        private val context : MainActivity,
        private  val EtablissementList : List<EtablissementModel>,
        private val layoutId : Int

        ) : RecyclerView.Adapter<EtablissementAdaptater.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val EtablissementImage = view.findViewById<ImageView>(R.id.image_item)
        val EtablissementName:TextView? = view.findViewById(R.id.name_item)
        val EtablissementDescription:TextView? = view.findViewById(R.id.description_item)
        val StarIcon = view.findViewById<ImageView>(R.id.star_icon)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId ,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Recuperation info de la place
        val currentEtablissement = EtablissementList[position]

        //utilisation de glide pour recuperer une image depuis son lien
        Glide.with(context).load(Uri.parse(currentEtablissement.imageUrl)).into(holder.EtablissementImage)

        //Mise à jour du nom de la plante

        holder.EtablissementName?.text = currentEtablissement.name
        // update etablissement description

        holder.EtablissementDescription?.text = currentEtablissement.description

        //verifie if the etablissement were liked

        if (currentEtablissement.liked){

        }else{

        }

    }

    override fun getItemCount(): Int {
        return EtablissementList.size
    }


}