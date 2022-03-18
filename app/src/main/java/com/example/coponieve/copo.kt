package com.example.coponieve

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.random.Random

class copo(l:Lienzo,inte:Int) {
    val l = l
    var x = 0f
    var y = 0f
    var caida = 0f
    var tam = 0f
    var color = Color.WHITE
    var densidad = 255
    var i=-1
    var inte = inte
    var bo=false

    init {
        x = random(1080)
        caida = random(10)
        tam = caida*3
        if(inte>=2000) {
            i = random(inte).toInt() + 1000
        } else {
            i = random(inte).toInt()
        }
    }


    fun caer():Boolean{
        i-=1
        if (i==0 ){
            bo=true
        }
        return bo
    }

    fun mover(){
            y += caida

            if(densidad>=10) {
                densidad-=1
            }
            if (caida.toInt()==3 && y >= 900) {
                y=0f
                x = random(1080)
                densidad = 255
            }else
                if (caida.toInt()==3 && y >= 800) {
                    y=0f
                    x = random(1080)
                    densidad = 255
                }else
                    if (caida.toInt()==1 && y >= 700) {
                        y=0f
                        x = random(1080)
                        densidad = 255
                    }else
            if (y >= l.height) {
                y=0f
                x = random(1080)
                densidad = 255
            }

    }

    fun pintar(c:Canvas){
        var p = Paint()

        color = Color.argb(densidad, 255, 255, 255)
        p.color = color
        c.drawCircle(x, y, tam, p)
    }


    private fun random(hasta:Int): Float{
        return Random.nextInt(hasta).toFloat()
    }
}