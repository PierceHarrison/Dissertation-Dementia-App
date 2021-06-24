package com.example.dissertation_dementia_app

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class sosSettings : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}