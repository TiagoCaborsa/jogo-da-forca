package cliente

import servidor.ServidorConfig
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.net.Socket
import java.util.*

class ClienteControle(private val servidorConfig: ServidorConfig) {

    fun iniciarCliente() {
        try {

            val socket = Socket(servidorConfig.ip, servidorConfig.porta)
            val outputStream = ObjectOutputStream(socket.getOutputStream())
            val inputStream = ObjectInputStream(socket.getInputStream())

            println("Conectado ao servidor.")

            val scanner = Scanner(System.`in`)

            while (true) {
                println("Digite a msg!")
                outputStream.writeObject(scanner.nextLine())
                outputStream.flush()
                val message = inputStream.readObject().toString()
                println(message)
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