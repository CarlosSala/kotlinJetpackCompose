package com.example.jetpackcompose.ui.screenexamples.widgethree

import kotlin.random.Random

// Generate a random quote
fun getRandomQuote(): String {
    val quotes = listOf(

        "Cambios paulatinos.",
        "Vive y deja vivir; nadie te pertenece.",
        "La perfección no existe.",
        "Entiende que nadie te ofendió.",
        "Las sonrisas son contagiosas.",
        "La felicidad se encuentra en uno mismo.",
        "Trata a los demás como te gustaría que te traten.",
        "No importa qué tan lento vayas, mientras no te detengas.",
        "La vida es un 10% lo que me ocurre y un 90% cómo reacciono a ello.",
        "Las opiniones de otros no definen tu realidad.",
        "Ninguna cantidad de ansiedad hace ninguna diferencia.",
        "No hay peor ejercicio que el que no se hace.",
        "Solo fracasas cuando te das por vencido.",
        "La doctrina es enemiga de la reflexión.",
        "Soñar no te hará ningún bien si olvidas vivir.",
        "El éxito es la suma de pequeños esfuerzos, repetidos día tras día.",

        "Pide ayuda si lo necesitas.",
        "Ansiedad: preocupación por el futuro, hiperactividad; se origina en mí y no en las cosas externas.",
        "Depresión: preocupación por el pasado que no se puede cambiar, falta de energía.",
        "Pérdida de tiempo y energía: incluye preocuparse por opiniones ajenas, quejarse de todo, repetir los mismos errores, intentar hacer todo perfecto y temer al fracaso.",
        "¿Por qué enfermamos? Por adoptar problemas ajenos, reprimir emociones, trabajar en algo que no te gusta, guardar rencores, renunciar a nuestros sueños y dejar que el miedo nos paralice. Si me viera desde afuera, ¿qué diría?",
        "¿Cuánto puedes resistir y seguir adelante?",
        "Todo trabajo físico moderado sirve para la recuperación.",
        "Si la idea es buena, ¡oblígate a hacerla!",
        "Controla tus emociones; generalmente no son razones válidas para hacer cosas, ya que eventualmente desaparecen.",
        "Juzgar a otros es juzgarse a uno mismo.",
        "El fracaso es simplemente la oportunidad de comenzar de nuevo, con más sabiduría.",
        "El único modo de hacer un gran trabajo es amar lo que haces.",
        "El optimismo es la fe que conduce al logro; nada puede hacerse sin esperanza y confianza."
    )
    return quotes[Random.nextInt(quotes.size)]
}