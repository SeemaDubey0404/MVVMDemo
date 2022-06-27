package view.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.mvvmdemo.databinding.ActivityCatFactBinding
import dagger.hilt.android.AndroidEntryPoint
import model.CatFact
import view.viewmodel.CatFactViewModel

@AndroidEntryPoint
class CatFactActivity : AppCompatActivity() {

    private val catFactViewModel: CatFactViewModel by viewModels()

    private lateinit var binding: ActivityCatFactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatFactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup load new fact button
        binding.btnCatFactLoadNew.setOnClickListener {
            catFactViewModel.loadCatFact()
        }

        // Setup view model cat fact observer
        val catFactObserver = Observer<CatFact> { newCatFact ->
            // New cat fact received from API
            binding.txtViewCatFact.text = newCatFact.fact
        }
        catFactViewModel.catFact.observe(this, catFactObserver)

        // Load data at start
        catFactViewModel.loadCatFact()
    }
}