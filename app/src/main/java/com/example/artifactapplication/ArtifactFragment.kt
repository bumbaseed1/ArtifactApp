package com.example.artifactapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate

class ArtifactFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_artifact, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve data from arguments
        val title = arguments?.getString("ARTIFACT_TITLE") ?: "No Title"
        val description = arguments?.getString("ARTIFACT_DESCRIPTION") ?: "No Description"
        val imageId = arguments?.getInt("ARTIFACT_IMAGE_ID")

        // Update ImageView with the image
        val imageView: ImageView = view.findViewById(R.id.artifactImageView)
        imageId?.let {
            imageView.setImageResource(it)
        }

        // Check and adjust for "Artifact 2"
        if (title == "Artifact Description") {
            val params: ViewGroup.LayoutParams = imageView.layoutParams
            val sizeInPixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 400f, resources.displayMetrics).toInt()
            params.width = sizeInPixels
            params.height = sizeInPixels
            imageView.layoutParams = params
            imageView.scaleType = ImageView.ScaleType.FIT_CENTER // Adjust scale type as needed
        } else if (title == "Artifact Description extended"){
            val params: ViewGroup.LayoutParams = imageView.layoutParams
            val sizeInPixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 400f, resources.displayMetrics).toInt()
            params.width = sizeInPixels
            params.height = sizeInPixels
            imageView.layoutParams = params
            imageView.scaleType = ImageView.ScaleType.FIT_CENTER // Adjust scale type as needed
        }

        // Update TextView with the title and description
        val titleTextView: TextView = view.findViewById(R.id.artifactTitleTextView) // Assuming you have a TextView for the title
        val descriptionTextView: TextView = view.findViewById(R.id.artifactInfoTextView) // Your TextView for the description
        titleTextView.text = title
        descriptionTextView.text = description

        val darkModeButton: Button = view.findViewById(R.id.dark_mode_btn)

        // Set an OnClickListener on the button
        darkModeButton.setOnClickListener {
            // Check the current night mode state
            val nightModeFlags = resources.configuration.uiMode and
                    android.content.res.Configuration.UI_MODE_NIGHT_MASK

            // Toggle the night mode state
            when (nightModeFlags) {
                android.content.res.Configuration.UI_MODE_NIGHT_YES ->
                    // If it's currently dark mode, switch to light mode
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

                android.content.res.Configuration.UI_MODE_NIGHT_NO ->
                    // If it's currently light mode, switch to dark mode
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

                // Optionally handle other states if necessary
            }

            // Note: This will recreate the activity to apply the theme change, so ensure this behavior is what you desire.
            // In some cases, you might want to save a preference and only apply the theme change when the app restarts.
        }
    }




}
