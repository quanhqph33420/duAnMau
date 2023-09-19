package com.example.duanmau_quanhqph33420.SQL

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.duanmau_quanhqph33420.variable_pnlib

class sql_helper(context: Context, db_name: String, db_version: Int) :
    SQLiteOpenHelper(context, db_name, null, db_version) {
    val va = variable_pnlib()
    override fun onCreate(p0: SQLiteDatabase?) {
        val table_phieuMuon = "create table ${va.table_phieuMuon}(" +
                "${va.ma_phieuMuon} integer primary key autoincrement," +
                "${va.maTv_phieuMuon} integer references ${va.table_thanhVien}(${va.maTv_thanhVien})," +
                "${va.maSach_phieuMuon} integer references ${va.table_sach}(${va.maSach_sach})," +
                "${va.maThuthu_phieuMuon} integer references ${va.table_thuThu}(${va.maThuThu_thuThu})," +
                "${va.ngay_phieuMuon} text," +
                "${va.tienThue_phieuMuong} text," +
                "${va.traSach_phieuMuon} int)"

        val table_thuThu = "create table ${va.table_thuThu}(" +
                "${va.maThuThu_thuThu} integer primary key autoincrement," +
                "${va.hoTen_thuThu} text," +
                "${va.matKhau_thuThu} text)"

        val table_sach = "create table ${va.table_sach}(" +
                "${va.maSach_sach} integer primary key autoincrement," +
                "${va.maLoai_sach} integer references ${va.table_loaiSach}(${va.maLoai_loaiSach})," +
                "${va.tenSach_sach} text," +
                "${va.giaThue_sach} int)"

        val table_loaiSach = "create table ${va.table_loaiSach}(" +
                "${va.maLoai_loaiSach} integer primary key autoincrement," +
                "${va.tenLoai_loaiSach} text)"

        val table_thanhVien = "create table ${va.table_thanhVien}(" +
                "${va.maTv_thanhVien} integer primary key autoincrement," +
                "${va.hoTen_thanhVien} text," +
                "${va.namSinh_thanhVien} text)"

        p0?.execSQL(table_phieuMuon)
        p0?.execSQL(table_thuThu)
        p0?.execSQL(table_sach)
        p0?.execSQL(table_loaiSach)
        p0?.execSQL(table_thanhVien)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        if (p1 != p2) {
            p0?.execSQL("drop table ${va.table_phieuMuon}")
            p0?.execSQL("drop table ${va.table_thuThu}")
            p0?.execSQL("drop table ${va.table_sach}")
            p0?.execSQL("drop table ${va.table_loaiSach}")
            p0?.execSQL("drop table ${va.table_thanhVien}")
        }
        onCreate(p0)
    }
}
