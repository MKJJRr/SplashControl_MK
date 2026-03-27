# SplashControl_MK 🚀

Uma biblioteca leve para Android que gerencia a retenção da **Splash Screen** nativa de forma síncrona, garantindo que o app só apareça quando estiver pronto.

## 📦 Instalação Manual
Como esta é uma biblioteca de arquivo único, basta copiar a pasta `libsktmk` para dentro do seu projeto em:
`app/src/main/java/`

## 🛠️ Como Usar

No seu arquivo `MainActivity.kt`, chame o `configurar` antes do `super.onCreate`:

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    // Segura a Splash por 2.5 segundos (ou o tempo que desejar)
    SplashControl.configurar(this, tempoEspera = 2500)
    
    super.onCreate(savedInstanceState)
    setContent { 
        // Seu conteúdo Compose ou XML aqui
    }
}
