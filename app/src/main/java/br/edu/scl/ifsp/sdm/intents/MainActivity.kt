package br.edu.scl.ifsp.sdm.intents

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResultLauncher
import br.edu.scl.ifsp.sdm.intents.Constants.PARAMETRO_EXTRA
import br.edu.scl.ifsp.sdm.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var parl: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)
        setSupportActionBar(amb.toolbarIn.toolbar)
        supportActionBar?.subtitle = localClassName

        amb.parameterBt.setOnClickListener {
            Intent(this, ParameterActivity::class.java).also {
                it.putExtra(PARAMETRO_EXTRA, amb.parameterTv.text.toString())
                parl.launch(it)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.openActivityMi -> {
                true
            }
            R.id.viewMi -> {
                val url: Uri = Uri.parse(amb.parameterTv.text.toString())
                val navegadorIntent: Intent = Intent(ACTION_VIEW, url)
                startActivity(navegadorIntent)
                true
            }

            R.id.callMi -> {
                true
            }

            R.id.dialMi -> {
                true
            }

            R.id.pickMi -> {
                true
            }

            R.id.chooserMi -> {
                true
            }

            else -> {
                false
            }
        }
    }
}