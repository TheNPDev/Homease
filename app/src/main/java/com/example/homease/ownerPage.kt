package com.example.homease


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage


class ownerPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owner_page)

        var storageRef = Firebase.storage.reference

        var imagePickerActivityResult: ActivityResultLauncher<Intent> =
        // lambda expression to receive a result back, here we
            // receive single item(photo) on selection
            registerForActivityResult( ActivityResultContracts.StartActivityForResult()) { result ->
                if (result != null) {
                    // getting URI of selected Image
                    val imageUri: Uri? = result.data?.data

                    // val fileName = imageUri?.pathSegments?.last()

                    // extract the file name with extension
                    val sd = getFileName(applicationContext, imageUri!!)

                    // Upload Task with upload to directory 'file'
                    // and name of the file remains same
                    val uploadTask = storageRef.child("file/$sd").putFile(imageUri)


                    // On success, download the file URL and display it
                    uploadTask.addOnSuccessListener {
                        // using glide library to display the image
                        storageRef.child("file/$sd").downloadUrl.addOnSuccessListener {
                            var imageView = findViewById<ImageView>(R.id.home_image)
                            Glide.with(this@ownerPage)
                                .load(it)
                                .into(imageView)

                            Log.e("Firebase", "download passed")
                        }.addOnFailureListener {
                            Log.e("Firebase", "Failed in downloading")
                        }
                    }.addOnFailureListener {
                        Log.e("Firebase", "Image Upload fail")
                    }
                }
            }


                val select_img = findViewById<Button>(R.id.home_image_btn)
        select_img.setOnClickListener {
            // PICK INTENT picks item from data
            // and returned selected item
            val galleryIntent = Intent(Intent.ACTION_PICK)
            // here item is type of image
            galleryIntent.type = "image/*"
            // ActivityResultLauncher callback

            imagePickerActivityResult.launch(galleryIntent)
        }

        var imagePickerActivityResult1: ActivityResultLauncher<Intent> =
        // lambda expression to receive a result back, here we
            // receive single item(photo) on selection
            registerForActivityResult( ActivityResultContracts.StartActivityForResult()) { result ->
                if (result != null) {
                    val correct = findViewById<ImageView>(R.id.check)
                    correct.visibility = View.VISIBLE
                    val dimage = findViewById<ImageView>(R.id.dimage)
                    dimage.visibility = View.INVISIBLE
                }
            }

        val d = findViewById<Button>(R.id.d_btn)
        d.setOnClickListener {
            // PICK INTENT picks item from data
            // and returned selected item
            val galleryIntent = Intent(Intent.ACTION_PICK)
            // here item is type of image
            galleryIntent.type = "image/*"
            // ActivityResultLauncher callback

            imagePickerActivityResult1.launch(galleryIntent)
        }
        val upload = findViewById<Button>(R.id.upload)
        upload.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }
    @SuppressLint("Range")
    private fun getFileName(context: Context, uri: Uri): String? {
        if (uri.scheme == "content") {
            val cursor = context.contentResolver.query(uri, null, null, null, null)
            cursor.use {
                if (cursor != null) {
                    if(cursor.moveToFirst()) {
                        return cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                    }
                }
            }
        }
        return uri.path?.lastIndexOf('/')?.let { uri.path?.substring(it) }
    }


}