package com.pthat.awande

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.pthat.awande.EtablissementRepository.Singleton.EtablissementList
import com.pthat.awande.EtablissementRepository.Singleton.databaseRef

class EtablissementRepository {

    object Singleton {
        //creation de la connexion à la reference etablissement
        val databaseRef = FirebaseDatabase.getInstance().getReference("Eta")

        //creation de la liste qui va contenir les établissements

        val EtablissementList = arrayListOf<EtablissementModel>()

    }

    fun updateDate(callback:() -> Unit){
        databaseRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                //nettoyage de la liste avant sont enrichissement
                EtablissementList.clear()

                //recolter  la liste d'element de la bdd
                for (ds in snapshot.children){
                    //construction d'un objet etablissement
                    val etablissement = ds.getValue(EtablissementModel::class.java)

                    //verifier que l'etablissement n'est pas null
                    if (etablissement != null){
                        //ajout de l'etablissement dans la liste

                        EtablissementList.add(etablissement)
                    }
                }

                //appel du callback
                callback()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }


    //mise à jour de l'objet etablissement en bdd

    fun updateEtablissement(etablissement: EtablissementModel){
        databaseRef.child(etablissement.id.toString()).setValue(etablissement)
    }
}