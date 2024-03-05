package com.example.artifactapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ArtifactPageAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val artifacts = listOf(
        Artifact("The Amphora Pot", "This is an ancient pot found in the World Museum.", R.drawable.artifact),
        Artifact("Artifact 2", "This is the description of Artifact 2", R.drawable.artifact2)
        // Add more artifacts as needed
    )

    override fun getItemCount(): Int {
        return artifacts.size;
    }


    override fun createFragment(position: Int): Fragment {
        val fragment = ArtifactFragment()
        val args = Bundle().apply {
            putString("ARTIFACT_TITLE", artifacts[position].title)
            putString("ARTIFACT_DESCRIPTION", artifacts[position].description)
            putInt("ARTIFACT_IMAGE_ID", artifacts[position].imageResourceId)
        }
        Log.d("Adapter", "Passing data: Title: ${artifacts[position].title}, ID: ${artifacts[position].imageResourceId}")
        fragment.arguments = args
        return fragment
    }


}

