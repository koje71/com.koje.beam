package com.koje.beam.core

import com.koje.beam.R
import com.koje.framework.graphics.ImageComponent
import com.koje.framework.graphics.ImageDrawer
import com.koje.framework.graphics.Surface

object Playground:Surface() {

    val background = createImageDrawer(R.drawable.background)

    init{
        addComponent(ImageComponent(this)){
            image = background
            index = 0
            count = 1

            addProcedure {
                scale(ratio, ratio)
            }
        }
     }
}