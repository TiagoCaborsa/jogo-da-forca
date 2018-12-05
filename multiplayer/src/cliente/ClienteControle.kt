package cliente

import servidor.ServidorConfig
import java.io.ObjectOutputStream
import java.net.Socket
import java.util.*

class ClienteControle(private val servidorConfig: ServidorConfig) {

    fun iniciarCliente() {
        try {

            val socket = Socket(servidorConfig.ip, servidorConfig.porta)
            println("Conectado ao servidor.")
            val outputStream = ObjectOutputStream(socket.getOutputStream())

            val scanner = Scanner(System.`in`)

            while (true) {
                println("Digite a msg!")
                outputStream.writeObject(scanner.nextLine())
                outputStream.flush()
            }

        } catch (e: Exception) {
            e.printStackTrace()
            System.err.println("Erro ao iniciar cliente: ${e.message}")
        }

    }

}

fun main(args: Array<String>) {
    ClienteControle(ServidorConfig()).iniciarCliente()
}