package com.example.jetpackcompose.ui.screenexamples.widgetthree

import kotlin.random.Random

// Generate a random quote
fun getRandomQuote(): Phrase {
    val quotes = listOf(

        Phrase(
            quoteEs = "Dios ayuda a quien se ayuda.",
            quoteEn = "God helps those who help themselves."
        ),
        Phrase(
            quoteEs = "Vive y deja vivir; nadie te pertenece.",
            quoteEn = "Live and let live; no one belongs to you."
        ),
        Phrase(
            quoteEs = "La felicidad se encuentra en uno mismo.",
            quoteEn = "Happiness is found within oneself."
        ),
        Phrase(
            quoteEs = "Cambios paulatinos.",
            quoteEn = "Gradual changes."
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
            quoteEs = "La vida es un 10% lo que me ocurre y un 90% cómo reacciono a ello.",
            quoteEn = "Life is 10% what happens to me and 90% how I react to it."
        ),
        Phrase(
            quoteEs = "Supérate a ti mismo, no a los demás.",
            quoteEn = "Surpass yourself, not others."
        ),
        Phrase(
            quoteEs = "No importa qué tan lento vayas, mientras no te detengas.",
            quoteEn = "It doesn't matter how slow you go, as long as you don't stop."
        ),
        Phrase(
            quoteEs = "Las opiniones de otros no definen tu realidad.",
            quoteEn = "Other people's opinions do not define your reality."
        ),
        Phrase(
            quoteEs = "El miedo es temporal, el arrepentimiento es para siempre.",
            quoteEn = "Fear is temporary, regret is forever."
        ),
        Phrase(
            quoteEs = "No hay peor ejercicio que el que no se hace.",
            quoteEn = "The worst exercise is the one that isn't done."
        ),
        Phrase(
            quoteEs = "Nunca estarás 100% listo, solo hazlo.",
            quoteEn = "You'll never be ready, just do it."
        ),
        Phrase(
            quoteEs = "Perdonarse y perdonar.",
            quoteEn = "Forgive yourself and forgive others."
        ),

        Phrase(
            quoteEs = "Pide ayuda si lo necesitas.",
            quoteEn = "Ask for help if you need it."
        ),
        Phrase(
            quoteEs = "Ninguna cantidad de ansiedad hace ninguna diferencia.",
            quoteEn = "No amount of anxiety makes any difference."
        ),
        Phrase(
            quoteEs = "Todo trabajo físico moderado sirve para la recuperación.",
            quoteEn = "Any moderate physical work aids recovery."
        ),
        Phrase(
            quoteEs = "Nuestra tranquilidad emocional no debe depender de nadie.",
            quoteEn = "Our emotional peace should depend on no one."
        ),
        Phrase(
            quoteEs = "La motivación sigue a la acción, no la precede.",
            quoteEn = "Motivation follows action, not the other way around."
        ),
        Phrase(
            quoteEs = "Los muertos reciben más flores que los vivos porque el arrepentimiento es más fuerte que la gratitud.",
            quoteEn = "The dead receive more flowers than the living because regret is stronger than gratitude."
        ),
        Phrase(
            quoteEs = "¿Tu yo del mañana qué preferiría que hubieses hecho?",
            quoteEn = "What would your future self prefer you had done?"
        ),
        Phrase(
            quoteEs = "La amabilidad te convierte en la persona más bella del mundo sin importar cómo luzcas.",
            quoteEn = "Kindness makes you the most beautiful person in the world, no matter how you look."
        ),
        Phrase(
            quoteEs = "Nunca esperes, nunca exijas, nunca asumas.",
            quoteEn = "Never wait, never demand, never assume."
        ),
        Phrase(
            quoteEs = "Ansiedad, se origina en mí y no en las cosas externas.",
            quoteEn = "Anxiety, it originates in me, not in external things."
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
            quoteEs = "Pérdida de tiempo y energía: quejarse de todo, repetir los mismos errores.",
            quoteEn = "Waste of time and energy: complaining about everything, repeating the same mistakes."
        ),
        Phrase(
            quoteEs = "Las sonrisas son contagiosas.",
            quoteEn = "Smiles are contagious."
        ),
        Phrase(
            quoteEs = "Aguantar más que nadie más es la clave, jamás se den por vencidos.",
            quoteEn = "Enduring more than anyone else is the key, never give up."
        ),
        Phrase(
            quoteEs = "Cuida tus pensamientos, ni tus peores enemigos pueden hacerte tanto daño como tus pensamientos.",
            quoteEn = "Guard your thoughts, for even your worst enemies can't harm you as much as your own thoughts can."
        ),
        Phrase(
            quoteEs = "Practica la gratitud para con todas las personas y cosas; verás que la vida te devuelve a manos llenas.",
            quoteEn = "Practice gratitude toward all people and things; you’ll see that life gives back to you abundantly."
        ),
        Phrase(
            quoteEs = "Siéntete agradecido como si ya lo hubieras conseguido.",
            quoteEn = "Feel grateful as if you had already achieved it."
        ),
        Phrase(
            quoteEs = "Imagina tu éxito con todos los detalles.",
            quoteEn = "Imagine your success in every detail."
        ),
        Phrase(
            quoteEs = "Disfruta de la vida porque es corta.",
            quoteEn = "Enjoy life because it's short."
        ),
        Phrase(
            quoteEs = "Las emociones no toman decisiones por mí.",
            quoteEn = "Emotions don't make decisions for me."
        ),
        Phrase(
            quoteEs = "No eres tus pensamientos; eres el observador de ellos.",
            quoteEn = "You are not your thoughts; you are the observer of them."
        ),
        Phrase(
            quoteEs = "Dividir las tareas en pasos simples, uno tras otro.",
            quoteEn = "Break tasks into simple steps, one after another."
        ),
        Phrase(
            quoteEs = "Vestirme bien todos los días, dentro de mis posibilidades, aunque no me vea nadie.",
            quoteEn = "Dress well every day, within your means, even if no one sees you."
        ),
        Phrase(
            quoteEs = "Ten un propósito elevado en la vida.",
            quoteEn = "Have a higher purpose in life."
        ),
        Phrase(
            quoteEs = "Sociabiliza más, sé popular.",
            quoteEn = "Socialize more, be popular."
        ),
        Phrase(
            quoteEs = "Manifiesta interés S. de forma indirecta.",
            quoteEn = "Show S. interest indirectly."
        ),
        Phrase(
            quoteEs = "Siempre asume que les caes bien y no lo tomes personal.",
            quoteEn = "Always assume they like you and don’t take it personally."
        ),
        Phrase(
            quoteEs = "Demuestra aprecio genuino por los demás, encuentra lo bueno de cada quien.",
            quoteEn = "Show genuine appreciation for others; find the good in everyone."
        ),

       /* Phrase(
            quoteEs = "Controla tus emociones; generalmente no son razones válidas para hacer cosas, ya que eventualmente desaparecen.",
            quoteEn = "Control your emotions; they are usually not valid reasons for actions, as they eventually disappear."
        ),
        Phrase(
            quoteEs = "Focus en tu meta.",
            quoteEn = "Focus on your goal."
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
            quoteEs = "¿Cuánto puedes resistir y seguir adelante?",
            quoteEn = "How much can you withstand and keep going?"
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
            quoteEs = "La gratitud no solo es la mayor de las virtudes, sino la madre de todas las demás.",
            quoteEn = "Gratitude is not only the greatest of virtues, but the parent of all the others."
        ),

        Phrase(
            quoteEs = "Si tienes ira, reconócela, pero no actúes en base a ella.",
            quoteEn = "If you feel anger, acknowledge it, but don’t act on it."
        ),
        Phrase(
            quoteEs = "El pensamiento condiciona la acción, la acción determina el comportamiento, el comportamiento repetitivo crea hábitos, los hábitos estructuran el carácter y el carácter marca el destino.",
            quoteEn = "Thought shapes action, action determines behavior, repetitive behavior creates habits, habits structure character, and character defines destiny."
        ),
        Phrase(
            quoteEs = "La persistencia es la medida de la creencia en sí mismo.",
            quoteEn = "Persistence is the measure of self-belief."
        ),
        Phrase(
            quoteEs = "La paciencia es calma, es relajación, haz lo mejor que puedes y luego relájate.",
            quoteEn = "Patience is calmness, it’s relaxation; do your best and then relax."
        ),
        Phrase(
            quoteEs = "Darse a los demás ayuda a que te vaya mejor en múltiples áreas.",
            quoteEn = "Giving to others helps you thrive in multiple areas."
        ),
        Phrase(
            quoteEs = "Transforma la adversidad.",
            quoteEn = "Transform adversity."
        ),
        Phrase(
            quoteEs = "La mejor forma de acabar algo es no reaccionar, no alimentarlo; la energía fluye donde está la atención, dale indiferencia.",
            quoteEn = "The best way to end something is not to react, not to feed it; energy flows where attention goes, give it indifference."
        ),
        Phrase(
            quoteEs = "Toda opinión es una visión cargada de historia personal, todo juicio es una confesión; los ataques y críticas dicen más de quien lo dice que de ti.",
            quoteEn = "Every opinion is a view loaded with personal history, every judgment is a confession; attacks and criticism say more about the speaker than about you."
        ),
        Phrase(
            quoteEs = "Hazlo (solo/con miedo/triste/motivado/a tu ritmo), pero hazlo.",
            quoteEn = "Do it (alone/afraid/sad/motivated/at your own pace), but do it."
        ),
        Phrase(
            quoteEs = "Repite creencias positivas cada día.",
            quoteEn = "Repeat positive beliefs every day."
        ),

        Phrase(
            quoteEs = "La disciplina es lo que te va a separar de todos.",
            quoteEn = "Discipline is what will set you apart from everyone else."
        ),
        Phrase(
            quoteEs = "Si la idea es buena, ¡oblígate a hacerla!",
            quoteEn = "If the idea is good, force yourself to do it!"
        ),
        Phrase(
            quoteEs = "No le des a nadie poder sobre tu estado de ánimo.",
            quoteEn = "Don't give anyone power over your mood."
        ),
        Phrase(
            quoteEs = "La doctrina es enemiga de la reflexión.",
            quoteEn = "Doctrine is the enemy of reflection."
        ),
        Phrase(
            quoteEs = "El optimismo es la fe que conduce al logro; nada puede hacerse sin esperanza y confianza.",
            quoteEn = "Optimism is the faith that leads to achievement; nothing can be done without hope and confidence."
        ),
        Phrase(
            quoteEs = "Cuando sabes lo que quieres (tienes metas), tienes un plan para conseguirlo y haces el trabajo con constancia, nada te detendrá.",
            quoteEn = "When you know what you want (have goals), have a plan to achieve it, and work with consistency, nothing will stop you."
        ),
        Phrase(
            quoteEs = "Trata a los demás como te gustaría que te traten.",
            quoteEn = "Treat others as you would like to be treated."
        ),
        Phrase(
            quoteEs = "Solo fracasas cuando te das por vencido.",
            quoteEn = "You only fail when you give up."
        )*/
    )
    return quotes[Random.nextInt(quotes.size)]
}
