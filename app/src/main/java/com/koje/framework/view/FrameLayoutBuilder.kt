package com.koje.framework.view

import android.widget.FrameLayout

open class FrameLayoutBuilder(override val view: FrameLayout) :
    ViewGroupBuilder(view) {

    interface Editor : ViewEditor<FrameLayoutBuilder>

}