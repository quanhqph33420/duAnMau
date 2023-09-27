package com.example.duanmau_quanhqph33420.SQLManager

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.database.Cursor
import android.util.Log
import android.widget.Toast
import com.example.duanmau_quanhqph33420.Navigation.mainActivity
import com.example.duanmau_quanhqph33420.Object.thongtin_login_obj
import com.example.duanmau_quanhqph33420.SQL_.sql_helper
import com.example.duanmau_quanhqph33420.variable_pnlib

class thongTin_login_fun(var context: Context?) {
    val va = variable_pnlib()
    val sql = sql_helper(context, va.name_app, va.version_app)
    val list_Thongtin = arrayListOf<thongtin_login_obj>()
    var welcome_ = ""

    fun check_login(taikhoan: String, matkhau: String){
        val db = sql.readableDatabase

        if (taikhoan.equals("") || matkhau.equals("")) {
            Toast.makeText(context, "Tài khoản hoặc mật khẩu bị trống!", Toast.LENGTH_SHORT).show()
        } else {
            val cursor = db.rawQuery(
                "select * from ${va.table_thongTin_TKMK} " +
                        "where ${va.taiKhoan}='$taikhoan' and ${va.matKhau}='$matkhau'", null
            )
            if (cursor.count > 0) {
                Toast.makeText(context, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show()
                kiemTra_Tk_admin(list_Thongtin, cursor)
                val intent = Intent(context, mainActivity::class.java)
                intent.putExtra("wel", welcome_)
                context?.startActivity(intent)
            } else {
                Toast.makeText(context, "Tài khoản mật khẩu không chính xác!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun kiemTra_Tk_admin(arrayList: ArrayList<thongtin_login_obj>, cursor: Cursor) {
        arrayList.clear()
        cursor.moveToFirst()
        arrayList.add(
            thongtin_login_obj(
                cursor.getString(1),
                cursor.getString(2)
            )
        )

        if (arrayList.get(0).taikhoan == "admin") {
            welcome_ = "Welcome admin"
            Toast.makeText(context, welcome_, Toast.LENGTH_SHORT).show()
        } else {
            welcome_ = "Welcome user"
            Toast.makeText(context, welcome_, Toast.LENGTH_SHORT).show()
        }
    }
}