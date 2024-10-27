package com.example.jetpackcompose.ui.screenexamples.widgethree

import kotlin.random.Random

// Generate a random quote
fun getRandomQuote(): String {
    val quotes = listOf(

        "Ask for help if you need",
        "Ansiedad: preocupacion por el futuro, hiperactividad, esta en mi y no en las cosas externas",
        "Depresión: preocupacion por el pasado, hiperactivida, no se puede cambiar",
        "Perdida de tiempo y energia: preocuparte por opiniones Quejarse de todo, Repetir los mismos errores, Tratar de hacer todo perfecto, Miedo a fallar",
        "Porque enfermamos, por adoptar poblemas agenos, reprimir emociones, trabajar en algo que no te gusta, guardar rencores, renunciar a nuestros sueños, por miedo y no arriesgarse, si me viera de afuera que diria",
        "Cuanto puedes resistir y seguir adelante",
        "Soñar no te hará ningun bien si olvidas vivir",
        "La doctrina es enemiga de la reflexión",
        "No hay peor ejercicio que el que no se hace",
        "Todo trabajo fisico moderado siver para la recuperacion",
        "si la idea es buena obligate a hacerla",
        "controla tus emociones, en general no son razones para hacer cosas, ya que eventualmente desaparecen",
        "cambios paulatinos",
        "Entiende que nadie te ofendió",
        "Vive y deja vivir, nadie te pertenece",
        "La perfección no existe",
        "juzgar a otros es juzgarse a uno mismo",
        "las sonrisas son contagiosas",
        "solo fracasas cuando te das por vencido",
        "las opiniones de otros no definen tu realidad",
        "la felicidad se encuentra en uno mismo",
        "trata a los demas como te gustaria que te traten",
        "ninguna cantidad de ansiedad hace ninguna diferencia",
        "El éxito es la suma de pequeños esfuerzos, repetidos día tras día.",
        "La vida es un 10% lo que me ocurre y un 90% cómo reacciono a ello.",
        "El fracaso es simplemente la oportunidad de comenzar de nuevo, con más inteligencia.",
        "La única manera de hacer un gran trabajo es amar lo que haces.",
        "No importa qué tan lento vayas mientras no te detengas.",
        "El único modo de hacer un gran trabajo es amar lo que haces.",
        "El optimismo es la fe que conduce al logro; nada puede hacerse sin esperanza y confianza.",
    )
    return quotes[Random.nextInt(quotes.size)]
}