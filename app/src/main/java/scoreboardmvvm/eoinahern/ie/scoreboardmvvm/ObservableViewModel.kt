package scoreboardmvvm.eoinahern.ie.scoreboardmvvm

import android.arch.lifecycle.ViewModel
import android.databinding.Observable
import android.databinding.PropertyChangeRegistry

open class ObservableViewModel : ViewModel(), Observable {

	@delegate : Transient
	private val mCallbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }

	override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
		mCallbacks.add(callback)
	}

	override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
		mCallbacks.remove(callback)
	}

	fun notifyChange() {
		mCallbacks.notifyChange(this, BR._all)
	}
}