/**
 * Biblioteca: SplashControl_MK
 * Versão: 1.0.0
 * Funcionalidade: Gerencia a retenção da tela de carregamento (Splash) 
 * de forma síncrona com a inicialização do app.
 */
package libsktmk.splash_control

import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewTreeObserver

object SplashControl {

    private var prontoParaExibir = false

    /**
     * Inicia o monitoramento da Splash Screen.
     * @param atividade Contexto da Activity principal
     * @param tempoEspera Tempo em milissegundos para segurar a Splash
     */
    fun configurar(atividade: Activity, tempoEspera: Long = 2000) {
        val conteudoRef: View = atividade.findViewById(android.R.id.content)
        
        // Timer interno para liberar a tela
        Handler(Looper.getMainLooper()).postDelayed({
            prontoParaExibir = true
        }, tempoEspera)

        // Trava o desenho da interface até que 'prontoParaExibir' seja true
        conteudoRef.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    return if (prontoParaExibir) {
                        conteudoRef.viewTreeObserver.removeOnPreDrawListener(this)
                        true
                    } else {
                        false
                    }
                }
            }
        )
    }

    /**
     * Liberação manual caso o carregamento de dados termine antes do tempo.
     */
    fun liberar() {
        prontoParaExibir = true
    }
}