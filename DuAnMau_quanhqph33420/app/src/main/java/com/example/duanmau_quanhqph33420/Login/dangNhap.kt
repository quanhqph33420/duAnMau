package com.example.duanmau_quanhqph33420.Login

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.duanmau_quanhqph33420.R
import com.example.duanmau_quanhqph33420.SQLManager.thongTin_login_fun
import com.example.duanmau_quanhqph33420.variable_pnlib
import com.google.android.material.textfield.TextInputEditText

class dangNhap() : AppCompatActivity() {
    lateinit var chckRemem: CheckBox
    lateinit var inputEdt_taiKhoan: TextInputEditText
    lateinit var inputEdt_matKhau: TextInputEditText
    val va = variable_pnlib()
    //var checkRemem = false
  //  val sharedPreferences = getSharedPreferences(va.table_thongTin_TKMK, Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dang_nhap)

        inputEdt_taiKhoan = findViewById(R.id.input_edt_taikhoan)
        inputEdt_matKhau = findViewById(R.id.input_edt_matkhau)
        val btn_login: Button = findViewById(R.id.btn_login)
        val btn_quit: Button = findViewById(R.id.btn_quit)
        chckRemem = findViewById(R.id.chck_remember)
        val thongtin_log = thongTin_login_fun(this)
        onCheckBox()

        btn_login.setOnClickListener {
            var tk = inputEdt_taiKhoan.text.toString().trim()
            var mk = inputEdt_matKhau.text.toString().trim()
            thongtin_log.check_login(tk, mk)
        }

        btn_quit.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            with(dialog) {
                setTitle("Bạn có chắc chắn muốn thoát")
                setIcon(R.drawable.baseline_error_24)
                setPositiveButton("Có") { dialogInterface, i ->
                    System.exit(0)
                }
                setNegativeButton("Không") { dialogInterface, i -> }
                create()
                show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        onCheckBox()
    }

    fun onCheckBox() {

    }
}