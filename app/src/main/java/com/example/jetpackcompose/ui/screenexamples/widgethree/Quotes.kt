package com.example.jetpackcompose.ui.screenexamples.widgethree

import kotlin.random.Random

// Generate a random quote
fun getRandomQuote(): Phrase {
    val quotes = listOf(

        Phrase(
            esQuote = "Cambios paulatinos.",
            enQuote = "Gradual changes."
        ),
        Phrase(
            esQuote = "Vive y deja vivir; nadie te pertenece.",
            enQuote = "Live and let live; no one belongs to you."
        ),
        Phrase(
            esQuote = "La perfección no existe.",
            enQuote = "Perfection doesn't exist."
        ),
        Phrase(
            esQuote = "Entiende que nadie te ofendió.",
            enQuote = "Understand that no one offended you."
        ),
        Phrase(
            esQuote = "Las sonrisas son contagiosas.",
            enQuote = "Smiles are contagious."
        ),
        Phrase(
            esQuote = "La felicidad se encuentra en uno mismo.",
            enQuote = "Happiness is found within oneself."
        ),
        Phrase(
            esQuote = "Trata a los demás como te gustaría que te traten.",
            enQuote = "Treat others as you would like to be treated."
        ),
        Phrase(
            esQuote = "No importa qué tan lento vayas, mientras no te detengas.",
            enQuote = "It doesn't matter how slow you go, as long as you don't stop."
        ),
        Phrase(
            esQuote = "La vida es un 10% lo que me ocurre y un 90% cómo reacciono a ello.",
            enQuote = "Life is 10% what happens to me and 90% how I react to it."
        ),
        Phrase(
            esQuote = "Las opiniones de otros no definen tu realidad.",
            enQuote = "Other people's opinions do not define your reality."
        ),
        Phrase(
            esQuote = "Ninguna cantidad de ansiedad hace ninguna diferencia.",
            enQuote = "No amount of anxiety makes any difference."
        ),
        Phrase(
            esQuote = "No hay peor ejercicio que el que no se hace.",
            enQuote = "The worst exercise is the one that isn't done."
        ),
        Phrase(
            esQuote = "Solo fracasas cuando te das por vencido.",
            enQuote = "You only fail when you give up."
        ),
        Phrase(
            esQuote = "La doctrina es enemiga de la reflexión.",
            enQuote = "Doctrine is the enemy of reflection."
        ),
        Phrase(
            esQuote = "Soñar no te hará ningún bien si olvidas vivir.",
            enQuote = "Dreaming does you no good if you forget to live."
        ),
        Phrase(
            esQuote = "El éxito es la suma de pequeños esfuerzos, repetidos día tras día.",
            enQuote = "Success is the sum of small efforts, repeated day after day."
        ),
        Phrase(
            esQuote = "Pide ayuda si lo necesitas.",
            enQuote = "Ask for help if you need it."
        ),
        Phrase(
            esQuote = "Ansiedad, se origina en mí y no en las cosas externas.",
            enQuote = "Anxiety, it originates in me, not in external things."
        ),
        Phrase(
            esQuote = "Pérdida de tiempo y energía: quejarse de todo, repetir los mismos errores.",
            enQuote = "Waste of time and energy: complaining about everything, repeating the same mistakes."
        ),
        Phrase(
            esQuote = "¿Cuánto puedes resistir y seguir adelante?",
            enQuote = "How much can you withstand and keep going?"
        ),
        Phrase(
            esQuote = "Todo trabajo físico moderado sirve para la recuperación.",
            enQuote = "Any moderate physical work aids recovery."
        ),
        Phrase(
            esQuote = "Si la idea es buena, ¡oblígate a hacerla!",
            enQuote = "If the idea is good, force yourself to do it!"
        ),
        Phrase(
            esQuote = "Juzgar a otros es juzgarse a uno mismo.",
            enQuote = "Judging others is judging yourself."
        ),
        Phrase(
            esQuote = "El fracaso es la oportunidad de comenzar de nuevo, con más sabiduría.",
            enQuote = "Failure is the opportunity to start again, with more wisdom."
        ),
        Phrase(
            esQuote = "El único modo de hacer un gran trabajo es amar lo que haces.",
            enQuote = "The only way to do great work is to love what you do."
        ),
        Phrase(
            esQuote = "Hazlo (solo/con miedo/triste/motivado/a tu ritmo), pero hazlo.",
            enQuote = "Do it (alone/afraid/sad/motivated/at your own pace), but do it."
        ),
        Phrase(
            esQuote = "La motivación sigue a la acción, no la precede.",
            enQuote = "Motivation follows action, not the other way around."
        ),
        Phrase(
            esQuote = "Hay que creernos capaces de todo; si no, no vamos a lograr nada.",
            enQuote = "We must believe we are capable of anything; otherwise, we won't achieve anything."
        ),
        Phrase(
            esQuote = "Vamos a salir de esta como salimos de todas.",
            enQuote = "We'll get through this as we always have."
        ),
        Phrase(
            esQuote = "No le des a nadie poder sobre tu estado de ánimo.",
            enQuote = "Don't give anyone power over your mood."
        ),
        Phrase(
            esQuote = "Nuestra tranquilidad emocional no debe depender de nadie.",
            enQuote = "Our emotional peace should depend on no one."
        ),
        Phrase(
            esQuote = "Dios ayuda a quien se ayuda.",
            enQuote = "God helps those who help themselves."
        ),
        Phrase(
            esQuote = "Supérate a ti mismo, no a los demás.",
            enQuote = "Surpass yourself, not others."
        ),
        Phrase(
            esQuote = "Los muertos reciben más flores que los vivos porque el arrepentimiento es más fuerte que la gratitud.",
            enQuote = "The dead receive more flowers than the living because regret is stronger than gratitude."
        ),
        Phrase(
            esQuote = "Controla tus emociones; generalmente no son razones válidas para hacer cosas, ya que eventualmente desaparecen.",
            enQuote = "Control your emotions; they are usually not valid reasons for actions, as they eventually disappear."
        ),
        Phrase(
            esQuote = "El optimismo es la fe que conduce al logro; nada puede hacerse sin esperanza y confianza.",
            enQuote = "Optimism is the faith that leads to achievement; nothing can be done without hope and confidence."
        ),
        Phrase(
            esQuote = "Cuida tus pensamientos, ni tus peores enemigos pueden hacerte tanto daño como tus pensamientos.",
            enQuote = "Guard your thoughts, for even your worst enemies can't harm you as much as your own thoughts can."
        ),
        Phrase(
            esQuote = "Cuando sabes lo que quieres (tienes metas), tienes un plan para conseguirlo y haces el trabajo con constancia, nada te detendrá.",
            enQuote = "When you know what you want (have goals), have a plan to achieve it, and work with consistency, nothing will stop you."
        ),
        Phrase(
            esQuote = "La gratitud no solo es la mayor de las virtudes, sino la madre de todas las demás.",
            enQuote = "Gratitude is not only the greatest of virtues, but the parent of all the others."
        ),
        Phrase(
            esQuote = "Practica la gratitud para con todas las personas y cosas; verás que la vida te devuelve a manos llenas.",
            enQuote = "Practice gratitude toward all people and things; you’ll see that life gives back to you abundantly."
        )
    )
    return quotes[Random.nextInt(quotes.size)]
}