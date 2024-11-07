package com.example.jetpackcompose.ui.screenexamples.widgetthree

import kotlin.random.Random

// Generate a random quote
fun getRandomQuote(): Phrase {
    val quotes = listOf(

        Phrase(
            quoteEs = "Cambios paulatinos.",
            quoteEn = "Gradual changes."
        ),
        Phrase(
            quoteEs = "Vive y deja vivir; nadie te pertenece.",
            quoteEn = "Live and let live; no one belongs to you."
        ),
        Phrase(
            quoteEs = "La perfección no existe.",
            quoteEn = "Perfection doesn't exist."
        ),
        Phrase(
            quoteEs = "Entiende que nadie te ofendió.",
            quoteEn = "Understand that no one offended you."
        ),
        Phrase(
            quoteEs = "Las sonrisas son contagiosas.",
            quoteEn = "Smiles are contagious."
        ),
        Phrase(
            quoteEs = "La felicidad se encuentra en uno mismo.",
            quoteEn = "Happiness is found within oneself."
        ),
        Phrase(
            quoteEs = "Trata a los demás como te gustaría que te traten.",
            quoteEn = "Treat others as you would like to be treated."
        ),
        Phrase(
            quoteEs = "No importa qué tan lento vayas, mientras no te detengas.",
            quoteEn = "It doesn't matter how slow you go, as long as you don't stop."
        ),
        Phrase(
            quoteEs = "La vida es un 10% lo que me ocurre y un 90% cómo reacciono a ello.",
            quoteEn = "Life is 10% what happens to me and 90% how I react to it."
        ),
        Phrase(
            quoteEs = "Las opiniones de otros no definen tu realidad.",
            quoteEn = "Other people's opinions do not define your reality."
        ),
        Phrase(
            quoteEs = "Ninguna cantidad de ansiedad hace ninguna diferencia.",
            quoteEn = "No amount of anxiety makes any difference."
        ),
        Phrase(
            quoteEs = "No hay peor ejercicio que el que no se hace.",
            quoteEn = "The worst exercise is the one that isn't done."
        ),
        Phrase(
            quoteEs = "Solo fracasas cuando te das por vencido.",
            quoteEn = "You only fail when you give up."
        ),
        Phrase(
            quoteEs = "La doctrina es enemiga de la reflexión.",
            quoteEn = "Doctrine is the enemy of reflection."
        ),
        Phrase(
            quoteEs = "Soñar no te hará ningún bien si olvidas vivir.",
            quoteEn = "Dreaming does you no good if you forget to live."
        ),
        Phrase(
            quoteEs = "El éxito es la suma de pequeños esfuerzos, repetidos día tras día.",
            quoteEn = "Success is the sum of small efforts, repeated day after day."
        ),
        Phrase(
            quoteEs = "Pide ayuda si lo necesitas.",
            quoteEn = "Ask for help if you need it."
        ),
        Phrase(
            quoteEs = "Ansiedad, se origina en mí y no en las cosas externas.",
            quoteEn = "Anxiety, it originates in me, not in external things."
        ),
        Phrase(
            quoteEs = "Pérdida de tiempo y energía: quejarse de todo, repetir los mismos errores.",
            quoteEn = "Waste of time and energy: complaining about everything, repeating the same mistakes."
        ),
        Phrase(
            quoteEs = "¿Cuánto puedes resistir y seguir adelante?",
            quoteEn = "How much can you withstand and keep going?"
        ),
        Phrase(
            quoteEs = "Todo trabajo físico moderado sirve para la recuperación.",
            quoteEn = "Any moderate physical work aids recovery."
        ),
        Phrase(
            quoteEs = "Si la idea es buena, ¡oblígate a hacerla!",
            quoteEn = "If the idea is good, force yourself to do it!"
        ),
        Phrase(
            quoteEs = "Juzgar a otros es juzgarse a uno mismo.",
            quoteEn = "Judging others is judging yourself."
        ),
        Phrase(
            quoteEs = "El fracaso es la oportunidad de comenzar de nuevo, con más sabiduría.",
            quoteEn = "Failure is the opportunity to start again, with more wisdom."
        ),
        Phrase(
            quoteEs = "El único modo de hacer un gran trabajo es amar lo que haces.",
            quoteEn = "The only way to do great work is to love what you do."
        ),
        Phrase(
            quoteEs = "Hazlo (solo/con miedo/triste/motivado/a tu ritmo), pero hazlo.",
            quoteEn = "Do it (alone/afraid/sad/motivated/at your own pace), but do it."
        ),
        Phrase(
            quoteEs = "La motivación sigue a la acción, no la precede.",
            quoteEn = "Motivation follows action, not the other way around."
        ),
        Phrase(
            quoteEs = "Hay que creernos capaces de todo; si no, no vamos a lograr nada.",
            quoteEn = "We must believe we are capable of anything; otherwise, we won't achieve anything."
        ),
        Phrase(
            quoteEs = "Vamos a salir de esta como salimos de todas.",
            quoteEn = "We'll get through this as we always have."
        ),
        Phrase(
            quoteEs = "No le des a nadie poder sobre tu estado de ánimo.",
            quoteEn = "Don't give anyone power over your mood."
        ),
        Phrase(
            quoteEs = "Nuestra tranquilidad emocional no debe depender de nadie.",
            quoteEn = "Our emotional peace should depend on no one."
        ),
        Phrase(
            quoteEs = "Dios ayuda a quien se ayuda.",
            quoteEn = "God helps those who help themselves."
        ),
        Phrase(
            quoteEs = "Supérate a ti mismo, no a los demás.",
            quoteEn = "Surpass yourself, not others."
        ),
        Phrase(
            quoteEs = "Los muertos reciben más flores que los vivos porque el arrepentimiento es más fuerte que la gratitud.",
            quoteEn = "The dead receive more flowers than the living because regret is stronger than gratitude."
        ),
        Phrase(
            quoteEs = "Controla tus emociones; generalmente no son razones válidas para hacer cosas, ya que eventualmente desaparecen.",
            quoteEn = "Control your emotions; they are usually not valid reasons for actions, as they eventually disappear."
        ),
        Phrase(
            quoteEs = "El optimismo es la fe que conduce al logro; nada puede hacerse sin esperanza y confianza.",
            quoteEn = "Optimism is the faith that leads to achievement; nothing can be done without hope and confidence."
        ),
        Phrase(
            quoteEs = "Cuida tus pensamientos, ni tus peores enemigos pueden hacerte tanto daño como tus pensamientos.",
            quoteEn = "Guard your thoughts, for even your worst enemies can't harm you as much as your own thoughts can."
        ),
        Phrase(
            quoteEs = "Cuando sabes lo que quieres (tienes metas), tienes un plan para conseguirlo y haces el trabajo con constancia, nada te detendrá.",
            quoteEn = "When you know what you want (have goals), have a plan to achieve it, and work with consistency, nothing will stop you."
        ),
        Phrase(
            quoteEs = "La gratitud no solo es la mayor de las virtudes, sino la madre de todas las demás.",
            quoteEn = "Gratitude is not only the greatest of virtues, but the parent of all the others."
        ),
        Phrase(
            quoteEs = "Practica la gratitud para con todas las personas y cosas; verás que la vida te devuelve a manos llenas.",
            quoteEn = "Practice gratitude toward all people and things; you’ll see that life gives back to you abundantly."
        )
    )
    return quotes[Random.nextInt(quotes.size)]
}