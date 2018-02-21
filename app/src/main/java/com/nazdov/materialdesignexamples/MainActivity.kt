package com.nazdov.materialdesignexamples

import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.AnticipateOvershootInterpolator
import kotlinx.android.synthetic.main.circuit.*

class MainActivity : AppCompatActivity() {

    private var show = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.circuit)

        backgroundImage.setOnClickListener {
            if(show)
                hideComponents() // if the animation is shown, we hide back the views
            else
                showComponents() // if the animation is NOT shown, we animate the views
        }
    }

    private fun showComponents(){
        show = true

        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.circuit_detail)

        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.duration = 1200

        TransitionManager.beginDelayedTransition(constraint, transition)
        constraintSet.applyTo(constraint)
    }

    private fun hideComponents(){
        show = false

        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.circuit)

        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.duration = 1200

        TransitionManager.beginDelayedTransition(constraint, transition)
        constraintSet.applyTo(constraint)
    }
}
