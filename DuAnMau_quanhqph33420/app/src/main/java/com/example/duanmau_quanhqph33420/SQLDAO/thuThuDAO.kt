package com.example.duanmau_quanhqph33420.SQLDAO

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.widget.Toast
import com.example.duanmau_quanhqph33420.Main.mainActivity
import com.example.duanmau_quanhqph33420.Object.thuThu
import com.example.duanmau_quanhqph33420.SQL_Help.sql_helper
import com.example.duanmau_quanhqph33420.variable_pnlib

class thuThuDAO(var context: Context?) {
    val va = variable_pnlib()
    val sql = sql_helper(context)

    fun check_login(taikhoan: String, matkhau: String): Boolean {
        val db = sql.readableDatabase
        if (taikhoan.equals("") || matkhau.equals("")) {
            Toast.makeText(context, "Tài khoản hoặc mật khẩu bị trống!", Toast.LENGTH_SHORT).show()
        } else {
            val cursor = db.rawQuery(
                "select * from ${va.table_thuThu} " +
                        "where ${va.taikhoan_thuThu}='$taikhoan' and ${va.matKhau_thuThu}='$matkhau'",
                null
            )
            return (cursor.count > 0)
        }
        return false
    }
}