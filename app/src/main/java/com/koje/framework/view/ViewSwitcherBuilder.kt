package com.koje.framework.view

import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.FrameLayout
import androidx.core.view.get


class ViewSwitcherBuilder(override val view: FrameLayout) :
    ViewBuilder(view) {

    interface Editor : ViewEditor<ViewSwitcherBuilder>

    var animationDuration = 300L

    fun load(animation: Anim, action: FrameLayoutBuilder.() -> Unit) {
        val result = FrameLayout(view.context)
        view.addView(result)
        FrameLayoutBuilder(result).action()

        if (view.childCount > 2) {
            view.removeViewAt(0)
        }

        if (view.childCount > 1) {
            animate(animation)
        } else {
            Receivers.register(result)
        }
    }

    private fun animate(animation: Anim) {
        when (animation) {
            Anim.none -> {
                view.get(0).visibility = View.GONE
                Receivers.register(view.get(1))
                Receivers.release(view.get(0))
            }
            Anim.fade -> {
                show(AlphaAnimation(0f, 1f))
                hide(AlphaAnimation(1f, 0f))
            }
            Anim.fromRight -> {
                show(TranslateAnimation(view.width.toFloat(), 0f, 0f, 0f))
                hide(TranslateAnimation(0f, -1 * view.width.toFloat(), 0f, 0f))
            }
            Anim.fromLeft -> {
                show(TranslateAnimation(-1 * view.width.toFloat(), 0f, 0f, 0f))
                hide(TranslateAnimation(0f, view.width.toFloat(), 0f, 0f))
            }
        }
    }

    private fun show(animation: Animation) {
        val target = view.get(1)
        with(animation) {
            duration = animationDuration
            fillAfter = true
            setAnimationListener(object : BaseAnimationListener() {
                override fun onAnimationStart(anim: Animation?) {
                    Receivers.register(target)
                }
            })
            target.startAnimation(this)
        }
    }

    private fun hide(animation: Animation) {
        val target = view.get(0)
        with(animation) {
            duration = animationDuration
            fillAfter = true
            setAnimationListener(object : BaseAnimationListener() {
                override fun onAnimationEnd(anim: Animation?) {
                    Receivers.release(target)
                    view.removeViewAt(0)
                }
            })
            target.startAnimation(this)
        }
    }

}


