package scoreboardmvvm.eoinahern.ie.scoreboardmvvm

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import scoreboardmvvm.eoinahern.ie.scoreboardmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	private val atwoButton: Button by lazy { findViewById<Button>(R.id.a_two_points) }
	private val btwoButton: Button by lazy { findViewById<Button>(R.id.b_two_points) }
	private val reset: Button by lazy { findViewById<Button>(R.id.reset) }

	lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
		binding.viewmodel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)

		atwoButton.setOnClickListener {
			binding.viewmodel?.addTwoTeamA()
		}

		btwoButton.setOnClickListener {
			binding.viewmodel?.addTwoTeamB()
		}

		reset.setOnClickListener {
			binding.viewmodel?.resetScores()
		}
	}
}
