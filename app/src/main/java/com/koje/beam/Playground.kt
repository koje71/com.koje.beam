package com.koje.beam

import com.koje.framework.graphics.ImageComponent
import com.koje.framework.graphics.Surface

object Playground:Surface() {

    val background = createImageDrawer(R.drawable.background)
    val picmap = createImageDrawer(R.drawable.picmap)

    init{
        addComponent(ImageComponent(this)){
            image = background
            index = 0
            count = 1

            addProcedure {
                scale(ratio, ratio)
            }
        }

        addComponent(Asteroid()){

            addProcedure {
                move(-0.2f,-0.2f)
                scale(0.1f)
            }
        }
     }
}