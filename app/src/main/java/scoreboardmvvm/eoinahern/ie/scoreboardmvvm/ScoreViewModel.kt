package scoreboardmvvm.eoinahern.ie.scoreboardmvvm

import android.app.Application

class ScoreViewModel(app : Application) : ObservableViewModel(app) {

	var scoreTeamA: Int = 0
	var scoreTeamB: Int = 0

	fun addTwoTeamA() {
		scoreTeamA += 2
		notifyChange()
	}

	fun addTwoTeamB() {
		scoreTeamB += 2
		notifyChange()
	}

	fun resetScores() {
		scoreTeamA = 0
		scoreTeamB = 0
		notifyChange()
	}
}