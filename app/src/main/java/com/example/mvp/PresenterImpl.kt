package com.example.mvp

import android.text.TextUtils

class PresenterImp(private val view: ActivityView): Presenter {
    private val HASIL = mutableListOf<Hasil>()
    override fun tambahHasil(number1: String, number2: String) {
        if (TextUtils.isEmpty(number1) || TextUtils.isEmpty(number2)){
            view.showMessage("Data harus diisi")
        } else {
            val jumlah = number1.toInt() + number2.toInt()
            HASIL.run {
                add(Hasil(jumlah))
            }
            view.showMessage("Hasil : $jumlah")
            view.clearField()
        }
    }

    override fun clearHasil() {
        if(HASIL.size != 0){
            HASIL.clear()
            view.showMessage("Data Berhasil Dihapus")
        } else {
            view.showMessage("Belum ada perhitungan")
        }
    }


    override fun loadHasil() {
        if(HASIL.size == 0){
            view.showMessage("Belum ada riwayat")
        } else {
            var allData = ""

            for(i in 0 until HASIL.size){
                allData += "Hasil : " + HASIL[i].hasilHitung + "\n\n"
            }

            allData += "Total : " + HASIL.size

            view.showData(allData)
        }
    }
}