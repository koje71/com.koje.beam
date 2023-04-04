package com.koje.beam

import com.koje.framework.graphics.ComponentGroup
import com.koje.framework.graphics.Position
import kotlin.math.abs
import kotlin.random.Random

class Asteroid : ComponentGroup(Playground) {

    val position = Position()
    val vector = Position()
    var angle = 0f
    var rotation = Random.nextFloat() * 0.8f

    init {
        addImageComponent {
            image = Playground.picmap
            count = 64
            index = listOf(0,8,9,10).random()

            addProcedure {
                update()
                move(position)
                rotate(angle)
                scale(0.12f)
            }
        }

        createDetectorX()
        createDetectorY()
    }

    private fun update() {
        val speed = 0.003f

        position.x += speed * vector.x * Playground.loopTime
        val xBorder = 0.5f + 0.2f
        if (position.x > xBorder) {
            position.x = xBorder
            if (vector.x > 0f) {
                vector.x *= -1f
                Playground.createRandomAsteroid(position.x, position.y)
            }
        }

        if (position.x < xBorder * -1f) {
            position.x = xBorder * -1f
            if (vector.x < 0f) {
                vector.x *= -1f
                Playground.createRandomAsteroid(position.x, position.y)
            }
        }


        position.y += speed * vector.y * Playground.loopTime

        val yBorder = Playground.ratio / 2f + 0.2f
        if (position.y > yBorder) {
            position.y = yBorder
            if (vector.y > 0f) {
                vector.y *= -1f
                Playground.createRandomAsteroid(position.x, position.y)
            }
        }

        if (position.y < yBorder * -1f) {
            position.y = yBorder * -1f
            if (vector.y < 0f) {
                vector.y *= -1f
                Playground.createRandomAsteroid(position.x, position.y)
            }
        }

        angle += 0.15f * rotation * Playground.loopTime
        if (angle > 360f) {
            angle -= 360f
        }
        if (angle < 0f) {
            angle += 360f
        }
    }

    private fun createDetectorX() {
        addImageComponent {
            image = Playground.picmap
            index = 4
            count = 64

            addProcedure {
                val posY = when (position.y < 0f) {
                    true -> Playground.ratio * -0.5f
                    else -> Playground.ratio * 0.5f
                }
                move(position.x, posY)
                rotate(90f)
                scale(0.1f)
            }
        }
    }

    private fun createDetectorY() {
        addImageComponent {
            image = Playground.picmap
            index = 4
            count = 64

            addProcedure {
                val posX = when (position.x < 0f) {
                    true -> -0.5f
                    else -> 0.5f
                }
                move(posX, position.y)
                scale(0.1f)
            }
        }
    }
}