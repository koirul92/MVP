package com.example.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.mvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),ActivityView {
    private lateinit var presenterImp: PresenterImp
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenterImp = PresenterImp(this)

        binding.btnSubmit.setOnClickListener {
            presenterImp.tambahHasil(
                binding.etNumber1.text.toString(),
                binding.etNumber2.text.toString()
            )
        }

        binding.btnRiwayat.setOnClickListener {
            presenterImp.loadHasil()
        }

    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showData(data: String) {
        AlertDialog
            .Builder(this)
            .setNegativeButton("Tutup"){dialog, _ ->
                dialog.dismiss()
            }
            .setNeutralButton("Hapus"){dialog, _ ->
                //confirm
                AlertDialog.Builder(this)
                    .setPositiveButton("Iya"){dialog, _ ->
                        presenterImp.clearHasil()
                        dialog.dismiss()
                    }
                    .setNegativeButton("Tidak"){dialog, _ ->
                        dialog.dismiss()
                    }
                    .setTitle("Konfirmasi")
                    .setMessage("Yakin ingin Hapus Riwayat?")
                    .create()
                    .show()

                dialog.dismiss()
            }
            .setTitle("History")
            .setMessage(data)
            .create()
            .show()
    }

    override fun clearField() {
        binding.etNumber1.text!!.clear()
        binding.etNumber2.text!!.clear()
    }
}