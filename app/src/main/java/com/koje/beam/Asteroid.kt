package com.koje.beam

import com.koje.framework.graphics.ComponentGroup

class Asteroid:ComponentGroup(Playground) {

    init{
        addImageComponent {
            image = Playground.picmap
            count = 64
            index = 0
        }
    }
}