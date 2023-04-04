package com.koje.beam

import com.koje.framework.graphics.ImageComponent
import com.koje.framework.graphics.Surface
import com.koje.framework.utils.Logger
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
        createRandomAsteroid(0f, 0f)
        createScala()
    }

    private fun createMonster() {
        addComponent(Monster()) {
            position.set(0.2f, 0f)
        }
    }

    fun createRandomAsteroid(posX: Float, posY: Float) {
        var counter = 0
        content.components.forEach {
            if(it is Asteroid){
                counter++
                if(counter>20){
                    return
                }
            }
        }

        addComponent(Asteroid()) {
            position.set(posX, posY)
            when (posX < 0) {
                true -> vector.x = Random.nextFloat() * 0.05f
                else -> vector.x = Random.nextFloat() * -0.05f
            }
            when (posY < 0) {
                true -> vector.y = Random.nextFloat() * 0.05f
                else -> vector.y = Random.nextFloat() * -0.05f
            }
        }
    }

    private fun createScala() {
        for (i in 0..14) {

            // top
            addComponent(createScalaLine()) {
                addProcedure {
                    move(-0.35f + i * 0.05f, ratio / 2f - 0.04f)
                    scale(0.1f)
                    rotate(90f)
                    Logger.info(this, "count: $count")
                }
            }

            // bottom
            addComponent(createScalaLine()) {
                addProcedure {
                    move(-0.35f + i * 0.05f, -ratio / 2f + 0.04f)
                    scale(0.1f)
                    rotate(270f)
                    Logger.info(this, "count: $count")
                }
            }

            // left
            addComponent(createScalaLine()) {
                addProcedure {
                    move(-0.46f, -0.345f + i * 0.05f)
                    scale(0.1f)
                    rotate(0f)
                    Logger.info(this, "count: $count")
                }
            }

            // right
            addComponent(createScalaLine()) {
                addProcedure {
                    move(+0.46f, -0.345f + i * 0.05f)
                    scale(0.1f)
                    rotate(180f)
                    Logger.info(this, "count: $count")
                }
            }

        }

        createSignalLamp()
    }

    private fun createSignalLamp() {
        addComponent(ImageComponent(this)) {
            image = picmap
            index = 3
            count = 64
            plane = 2

            addProcedure {
                move(-0.52f, ratio / 2f + 0.087f)
                scale(0.3f)
            }
        }

        addComponent(ImageComponent(this)) {
            image = picmap
            index = 3
            count = 64
            plane = 2

            addProcedure {
                move(+0.52f, ratio / -2f - 0.087f)
                scale(0.3f)
            }
        }
    }

    private fun createScalaLine(): ImageComponent {
        with(ImageComponent(this)) {
            image = picmap
            index = 2
            count = 64
            plane = 2
            return this
        }
    }
}