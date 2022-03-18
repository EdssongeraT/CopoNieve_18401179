package com.example.coponieve

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class Lienzo (este:MainActivity):View(este){
    val este = este
    //primer arreglo, establece primera nevada
    val copos = Array<copo>((30),{copo(this,200)})
    //segundo arreglo aumenta la intensidad de la nevada
    val coposIntensidad = Array<copo>((20)*intensidad(),{copo(this,2000)})

    val corutina = GlobalScope.launch {
        while (true){
            este.runOnUiThread {
                invalidate()
            }
            delay(20L)
        }

    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        c.drawColor(Color.rgb(0,0,51))
        //rojo 153,0,0
        //amarillo 255,255,0
        //64,64,64 ,192,192,192 0,102,51
        //pavimento 32,32,32
        //luna 160.160.160
        //ventana 0,102,204
        var p= Paint()
        //luna
        p.color = Color.rgb(160,160,160)
        c.drawCircle(800f,250f,175f,p)
        p.color = Color.rgb(0,0,51)
        c.drawCircle(700f,185f,175f,p)

        //carretera
        p.color = Color.rgb(32,32,32)
        c.drawRect(0f,1200f,this.width.toFloat(),1800f,p)
        p.color = Color.rgb(255,255,0)
        c.drawRect(0f,1480f,200f,1520f,p)
        c.drawRect(300f,1480f,500f,1520f,p)
        c.drawRect(600f,1480f,800f,1520f,p)
        c.drawRect(900f,1480f,1100f,1520f,p)

        //pasto
        p.color = Color.rgb(0,102,51)
        c.drawRect(0f,1099f,this.width.toFloat(),1199f,p)
        c.drawRect(0f,1801f,this.width.toFloat(),this.height.toFloat(),p)

        //carro
        p.color = Color.rgb(153,0,0)
        c.drawRect(300f,1200f,900f,1400f,p)
        c.drawRect(400f,1100f,700f,1200f,p)
        p.color = Color.rgb(0,102,204)
        c.drawRect(450f,1125f,575f,1200f,p)
        c.drawRect(600f,1125f,650f,1200f,p)
        p.color = Color.rgb( 255,255,0)
        c.drawRect(300f,1250f,350f,1300f,p)
        p.color = Color.rgb( 100,0,0)
        c.drawRect(850f,1250f,900f,1350f,p)
        p.color = Color.rgb( 0,0,0)
        c.drawCircle(450f,1400f,75f,p)
        c.drawCircle(750f,1400f,75f,p)
        p.color = Color.rgb( 64,64,64)
        c.drawCircle(450f,1400f,40f,p)
        c.drawCircle(750f,1400f,40f,p)

        for (co in copos){
            if(co.caer()){
                co.pintar(c)
                co.mover()
            }
        }
        //agregamos el array y poco a poco la intensidad va en aumento
        for (cop in coposIntensidad){
            if(cop.caer()){
                cop.pintar(c)
                cop.mover()
            }
        }
    }

    //controla la cantidad de nieve a caer
    fun intensidad(): Int{
        var inten = random(15).toInt()
        return inten
    }

    private fun random(hasta:Int): Float{
        return Random.nextInt(hasta).toFloat()
    }
}