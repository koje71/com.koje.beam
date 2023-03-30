package com.koje.beam

import com.koje.framework.graphics.ComponentGroup
import com.koje.framework.graphics.Position
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
            index = 0
        }

        addProcedure {
            update()
            move(position)
            rotate(angle)
            scale(0.12f)
        }
    }

    private fun update() {
        val speed = 0.003f

        position.x += speed * vector.x * Playground.loopTime
        val xBorder = 0.5f + 0.2f
        if (position.x > xBorder) {
            position.x = xBorder
            if (vector.x > 0f){
                vector.x *= -1f
                Playground.createRandomAsteroid(position.x,position.y)
            }
        }

        if (position.x < xBorder * -1f) {
            position.x = xBorder * -1f
            if (vector.x < 0f){
                vector.x *= -1f
                Playground.createRandomAsteroid(position.x,position.y)
            }
        }


        position.y += speed * vector.y * Playground.loopTime

        val yBorder = Playground.ratio / 2f + 0.2f
        if (position.y > yBorder) {
            position.y = yBorder
            if (vector.y > 0f){
                vector.y *= -1f
                Playground.createRandomAsteroid(position.x,position.y)
            }
        }

        if (position.y < yBorder * -1f) {
            position.y = yBorder * -1f
            if (vector.y < 0f){
                vector.y *= -1f
                Playground.createRandomAsteroid(position.x,position.y)
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
}