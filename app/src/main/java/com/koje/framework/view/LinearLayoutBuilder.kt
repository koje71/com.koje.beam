package com.koje.framework.view

import android.view.Gravity
import android.widget.LinearLayout

class LinearLayoutBuilder(override val view: LinearLayout) :
    ViewGroupBuilder(view) {

    interface Editor : ViewEditor<LinearLayoutBuilder>

    fun addFiller() {
        addFrameLayout {
            setLayoutWeight(1f)
        }
    }

    fun setGravityCenterVertical() {
        view.gravity = Gravity.CENTER_VERTICAL
    }

    fun setOrientationHorizontal() {
        view.setOrientation(LinearLayout.HORIZONTAL)
    }

    fun setOrientationVertical() {
        view.setOrientation(LinearLayout.VERTICAL)
    }
}