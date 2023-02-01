package com.example.conecta4

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.conecta4.databinding.ActivityMainBinding
import com.example.conecta4.dialogfragment.DialogFragmentAWinner
import com.example.conecta4.dialogfragment.DialogFragmentNewGameMenu
import com.example.conecta4.viewmodel.StateManagerViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var lastFragmentLoadedTag:String

    private val viewModel:StateManagerViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        showMainMenu()

    }

    fun showNewGameMenu(){

        val onPlayClick: () -> Unit = {
            val secondFragmentInstance = SecondFragment.newInstance(

            )

            supportFragmentManager
                .beginTransaction().remove(
                    supportFragmentManager.findFragmentByTag(FragmentTags.DIALOG_FRAGMENT_NEW_GAME_MENU)!!
                ).commit()

            supportFragmentManager
                .beginTransaction().replace(R.id.container,secondFragmentInstance,FragmentTags.TABLE_BOARD_FRAGMENT).commit()

            lastFragmentLoadedTag = FragmentTags.TABLE_BOARD_FRAGMENT

        }

        val onCancelClick: () -> Unit = {
            supportFragmentManager
                .beginTransaction().remove(
                    supportFragmentManager.findFragmentByTag(FragmentTags.DIALOG_FRAGMENT_NEW_GAME_MENU)!!
                ).commit()
            lastFragmentLoadedTag = FragmentTags.MAIN_MENU_FRAGMENT
        }

        val newGameMenu = DialogFragmentNewGameMenu.newInstance()
        newGameMenu.onCancelClick = onCancelClick
        newGameMenu.onPlayClick = onPlayClick

        newGameMenu.show(supportFragmentManager,FragmentTags.DIALOG_FRAGMENT_NEW_GAME_MENU)
        lastFragmentLoadedTag = FragmentTags.DIALOG_FRAGMENT_NEW_GAME_MENU
    }

    fun showAWinnerDialog(winnerNickName:String,
                          nickNamePlayer1:String,
                          nickNamePlayer2:String,
                          victoryNumPlayer1:Int,
                          victoryNumPlayer2: Int){

        val winnerDialogInstance = DialogFragmentAWinner.newInstance(winnerNickName, nickNamePlayer1, nickNamePlayer2, victoryNumPlayer1, victoryNumPlayer2)

        winnerDialogInstance.onCancelClick = {

            supportFragmentManager.beginTransaction().remove(
                supportFragmentManager.findFragmentByTag(FragmentTags.DIALOG_FRAGMENT_A_WINNER)!!
            ).commit()



        }

    }

    fun showMainMenu(){
        val firstFragment = FirstFragment.newInstance()
        supportFragmentManager.beginTransaction().replace(R.id.container,firstFragment,FragmentTags.MAIN_MENU_FRAGMENT)
            .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


}