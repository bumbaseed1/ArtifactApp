package com.example.artifactapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class ArtifactPageAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val artifacts = listOf(
        Artifact("The Amphora Pot", "This is an Amphora pot, an ancient storage jar and one of the principle vessel shapes in ancient greece.", R.drawable.artifact),
        Artifact("Artifact Description", "This particular amphora pot is held within the Liverpool Museum, and is said to originate from around 500 - 500 BC.", R.drawable.artifact2),
        Artifact("Artifact Description extended", "This amphora, probably Attic,is  decorated in the black-figure technique and one of its two handles is missing. The ampora has a long oblong body, " +
                "a round disc shaped base, " +
                "a short and thick neck and a wide disc shape rim that has a recess in its interior. Both the exterior and interior side of the rim are in black, the neck has decoration of vertical " +
                "five petal flowers, positioned antithetically from the top to the botton of the neck and interrupted in the middle by a chain motif. The base of the neck has a band of think lines in panels." +
                " The lines alternate in brown and black . ", R.drawable.artifact2)
    )

    override fun getItemCount(): Int {
        return artifacts.size
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

