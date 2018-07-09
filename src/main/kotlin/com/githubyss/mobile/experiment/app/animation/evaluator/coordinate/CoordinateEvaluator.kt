package com.githubyss.mobile.experiment.app.animation.evaluator.coordinate

import android.animation.TypeEvaluator

class CoordinateEvaluator : TypeEvaluator<Coordinate> {
    override fun evaluate(fraction: Float, startValue: Coordinate, endValue: Coordinate): Coordinate {
        val x = startValue.x + fraction * (endValue.x - startValue.x)
        val y = startValue.y + fraction * (endValue.y - startValue.y)

        return Coordinate(x, y)
    }
}
