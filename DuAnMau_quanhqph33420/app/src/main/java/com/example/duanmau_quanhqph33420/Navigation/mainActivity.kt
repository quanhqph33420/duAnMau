package com.example.duanmau_quanhqph33420.Navigation

import android.content.DialogInterface
import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.duanmau_quanhqph33420.Login.dangNhap
import com.example.duanmau_quanhqph33420.R
import com.example.duanmau_quanhqph33420.SQLManager.thongTin_login_fun
import com.google.android.material.navigation.NavigationView

class mainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawer = findViewById<DrawerLayout>(R.id.drawer_app)
        val navi = findViewById<NavigationView>(R.id.nav_main_app)
        val nav_icon = findViewById<ImageView>(R.id.imgBtn_Nav)

        val header = navi.getHeaderView(0)
        val text_header = header.findViewById<TextView>(R.id.txt_header)
        val intent = intent
        text_header.text = intent.getStringExtra("wel")

        if (text_header.text.equals("Welcome user")) {
            val menu = navi.menu
            val menu_item = menu.findItem(R.id.them_nv_menu)
            menu_item.setVisible(false)
        }
        nav_icon.setOnClickListener {
            drawer.openDrawer(GravityCompat.START)
        }
        navi.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.ql_phieuMuon_menu -> {
                    Toast.makeText(this, "1", Toast.LENGTH_SHORT).show()
                }

                R.id.ql_loaiSach_menu -> {
                    Toast.makeText(this, "2", Toast.LENGTH_SHORT).show()

                }

                R.id.ql_sach_menu -> {

                }

                R.id.ql_thanhVien_menu -> {

                }

                R.id.top10_sach_menu -> {

                }

                R.id.doanh_thu_menu -> {

                }

                R.id.them_nv_menu -> {

                }

                R.id.doi_mk_menu -> {

                }


                R.id.dang_xuat_menu -> {
                    val dialog = AlertDialog.Builder(this)
                    with(dialog) {
                        setTitle("Bạn có chắc chắn muốn đăng xuất")
                        setIcon(R.drawable.baseline_error_24)
                        setPositiveButton("Có") { dialogInterface, i ->
                            startActivity(Intent(this@mainActivity, dangNhap::class.java))
                        }
                        setNegativeButton("Không") { dialogInterface, i1 -> }
                        create()
                        show()
                    }
                }
            }
            true
        }
    }
}