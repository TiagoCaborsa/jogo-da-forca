package servidor.servico

import servidor.ServidorConfig
import servidor.controle.ServidorControle
import java.net.ServerSocket

object Servidor {

    private val servidorConfig = ServidorConfig()

    @JvmStatic
    fun iniciarServidor() {
        try {

            val servidor = ServerSocket(servidorConfig.porta)
//            val servidorConfig = ServidorConfig(ip = servidor.localSocketAddress.toString(), porta = servidor.localPort)

            println("Servidor iniciado com sucesso na porta: ${servidorConfig.porta}")

            while (true) {
                ServidorControle(servidor.accept())
            }

        } catch (e: Exception) {
            System.err.println("Erro ao iniciar servidor: ${e.message}")
            e.printStackTrace()
        }

    }
}

fun main(args: Array<String>) {
    Servidor.iniciarServidor()
}

