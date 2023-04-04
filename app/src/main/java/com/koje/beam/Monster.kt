package com.koje.beam

import com.koje.framework.graphics.ComponentGroup
import com.koje.framework.graphics.Position

class Monster : ComponentGroup(Playground) {

    val position = Position()

    init {
        addImageComponent {
            image = Playground.picmap
            index = 1
            count = 64

            addProcedure {
                move(position)
                scale(0.2f)
            }
        }
    }

}