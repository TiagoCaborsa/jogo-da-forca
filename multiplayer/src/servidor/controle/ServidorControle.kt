package servidor.controle

import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.net.Socket

class ServidorControle(private val socket: Socket) {

    private var inputStream: ObjectInputStream? = null
    private var outputStream: ObjectOutputStream? = null

    init {
        escutar()
    }

    private fun escutar() {
        popularStreams()
        thread()
    }

    private fun popularStreams() {
        inputStream = ObjectInputStream(socket.getInputStream())
        outputStream = ObjectOutputStream(socket.getOutputStream())
    }

    private fun thread() {
        var thread: Thread? = null

        try {
            val run = {

                while (true)
                    try {
                        val message = inputStream?.readObject().toString()
                        println(message)
                        outputStream?.writeObject(message)
                        outputStream?.flush()

                    } catch (e: ClassNotFoundException) {
                        System.err.println("Erro ao pegar informacoes de entrada: ${e.message}")
                        e.printStackTrace()
                    } catch (e: IOException) {
                        System.err.println("Erro ao pegar informacoes de entrada: ${e.message}")
                        e.printStackTrace()
                    }

            }
            thread = Thread(run)
            thread.start()

        } catch (e: Exception) {
            System.err.println("Erro ao criar thread: ${e.message}")
            e.printStackTrace()
            thread?.interrupt()
        }

    }
}

