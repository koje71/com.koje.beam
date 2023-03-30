package com.koje.beam

import com.koje.framework.graphics.ImageComponent
import com.koje.framework.graphics.Surface
import kotlin.random.Random

object Playground : Surface() {

    val background = createImageDrawer(R.drawable.background)
    val picmap = createImageDrawer(R.drawable.picmap)

    init {
        addComponent(ImageComponent(this)) {
            image = background
            index = 0
            count = 1

            addProcedure {
                scale(ratio, ratio)
            }
        }

        createMonster()
        createRandomAsteroid(0f,0f)
    }

    private fun createMonster() {
        addComponent(Monster()) {
            position.set(0.2f, 0f)
        }
    }

    fun createRandomAsteroid(posX:Float, posY:Float) {
        addComponent(Asteroid()) {
            position.set(posX, posY)
            when(posX<0){
                true -> vector.x = Random.nextFloat() * 0.05f
                else -> vector.x = Random.nextFloat() * -0.05f
            }
            when(posY<0){
                true -> vector.y = Random.nextFloat() * 0.05f
                else -> vector.y = Random.nextFloat() * -0.05f
            }
        }
    }
}