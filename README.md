
Markdown
# SplashControl_MK 🚀

**SplashControl_MK** é uma biblioteca ultra-leve para Android projetada para gerenciar a retenção da **Splash Screen nativa**. Ela garante que seu aplicativo só renderize a interface quando tudo estiver pronto, evitando "pulos" de tela e proporcionando uma experiência de usuário (UX) premium.

---

## 📦 Tutorial de Instalação (Passo a Passo)

Siga estas etapas simples para integrar a biblioteca ao seu projeto em menos de 2 minutos:

### 1. Preparando as pastas
Navegue até a pasta do seu projeto no seu computador ou celular e siga o caminho:
`SeuProjeto/app/src/main/java/`

### 2. Importando a Lib
Copie a pasta `libsktmk` que você baixou e cole dentro da pasta `java` mencionada acima. 

**A estrutura de pastas deve ficar exatamente assim:**
```text
app/
 └── src/
      └── main/
           └── java/
                └── libsktmk/           <-- Pasta da Lib
                     └── splash_control/
                          └── SplashControl.kt
```
---
## 🛠️ Como Usar no Projeto

### 1. Importe a Classe
No topo do seu arquivo `MainActivity.kt` (ou `AtividadePrincipal.kt`), adicione o seguinte import:

Kotlin
`import libsktmk.splash_control.SplashControl`

### 2. Chame o Configurar
Dentro da função `onCreate`, você deve chamar o `SplashControl.configurar`.

#### ⚠️ IMPORTANTE: Esta linha deve vir ANTES do 
`super.onCreate(savedInstanceState)` para que a trava da tela funcione corretamente.
Kotlin
class MainActivity : ` ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {`
    ```
    ```
        
        // 1. Configura a Splash (Exemplo: segura por 2.5 segundos)
        SplashControl.configurar(this, tempoEspera = 2500)

        // 2. Continua a inicialização padrão
        super.onCreate(savedInstanceState)
        
        setContent {
            // Seu tema e conteúdo aqui...
        }
    }
}

### 💡 Funções Extras
Liberação Manual
Se você estiver carregando dados de um banco de dados ou API e quiser fechar a Splash assim que terminar (independente do tempo definido), use:
Kotlin
`SplashControl.liberar()`

### ✨ Por que usar esta Lib?
Sincronização Nativa: Usa o `OnPreDrawListener` do Android, o método oficial para controlar frames de desenho.

Performance: Zero impacto no tamanho do APK final.

Compatibilidade: Funciona perfeitamente com Jetpack Compose e o sistema de View tradicional (XML).

### 📄 Licença
Distribuído sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

## Desenvolvido por MKJJR © 2026


---
