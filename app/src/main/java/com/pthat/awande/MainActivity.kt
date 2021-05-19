package com.pthat.awande

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pthat.awande.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //charger l'EtablissementRepository
        val EtablissementRepo = EtablissementRepository()

        // mise à jour de la liste d'etablissment

        EtablissementRepo.updateDate{
            //Injection du fragment dans la boite (fragment container)

            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, HomeFragment(this))
            transaction.addToBackStack(null)
            transaction.commit()
        }


    }
}