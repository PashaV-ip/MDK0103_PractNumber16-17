package com.example.practnumber16

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate


//############################################################################################//
//############################################################################################//
//###--------------------------------------------------------------------------------------###//
//###  Я не знаю почему, но у меня возникло множество проблем с меню, по этому у меня      ###//
//###  такая странная реализация.                                                          ###//
//###  Мне кажется это из-за способа смены темы, хотя сомневаюсь.                          ###//
//###--------------------------------------------------------------------------------------###//
//############################################################################################//
//###--------------------------------------------------------------------------------------###//
//###  Я надеюсь, что я правельно понял реализацию пункта "О программе"? и нужно было      ###//
//###  сделать, что-то вроде справки.                                                      ###//
//###--------------------------------------------------------------------------------------###//
//############################################################################################//
//############################################################################################//


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView : TextView = findViewById(R.id.textViewTheme)

        //________________________________________________________________________________________________________________
        //Изменение текста у TextView
        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) textView.text = "Ночная тема"
        else textView.text = "Дневная тема"
        //________________________________________________________________________________________________________________
    }
    //____________________________________________________________________________________________________________________
    //Метод для выбора темы (Не знаю зачем сделал, но думаю, если изменение темы делать на другие элементы,
    // то так лучше)
    private fun selectTheTheme(bool: Boolean){
        if(bool) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
    //____________________________________________________________________________________________________________________

    //____________________________________________________________________________________________________________________
    //Метод для изменения заголовка item в меню (Почему-то без него он меняет криво)
    private fun titleEdit() : String{

        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            return getString(R.string.off_theme_menu)
        }
        else{
            return getString(R.string.on_theme_menu)
        }
    }
    //____________________________________________________________________________________________________________________
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menu?.add(0, 1, 0, titleEdit())
        menu?.add(0, 2, 1, getString(R.string.about_the_program_menu))
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{

        when(item.itemId){
            1 -> selectTheTheme(item.title == getString(R.string.on_theme_menu))
            2 -> {
                val intent : Intent = Intent(this@MainActivity, InfoAboutTheProgramActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}