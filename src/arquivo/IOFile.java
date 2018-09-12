package arquivo;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class IOFile {

    public static byte[] receiveFile(Socket socket, int fileSize) throws IOException {
        byte[] file = new byte[5120];
        PrintStream ps = new PrintStream(socket.getOutputStream());
        java.util.Scanner s = new java.util.Scanner(socket.getInputStream());
        byte[] b = new byte[5120];
        java.io.BufferedInputStream bf = new java.io.BufferedInputStream(socket.getInputStream());
        bf.read(file);
        while (file.length <= fileSize - 6000) {
            ps.println("pedaço enviado");
            bf = new java.io.BufferedInputStream(socket.getInputStream());
            bf.read(b);
            file = Arquivo.binding(file, b);
        }
        ps.println("última parte recebida");
        b = new byte[6000];
        bf.read(b);
        file = Arquivo.binding(file, b);
        file = Arquivo.adjustBytes(file, fileSize);
        //bf.close();
        //s.close();
        return file;
    }

    public static void sendFile(Socket socket, byte[] file) throws IOException {
        PrintStream ps = new PrintStream(socket.getOutputStream());
        java.util.Scanner s = new java.util.Scanner(socket.getInputStream());
        java.io.BufferedOutputStream bf = new java.io.BufferedOutputStream(socket.getOutputStream());
        byte[] b;
        while (file.length > 6000) {
            try {
                b = Arquivo.copyByte(file);//pega os primeiros 5120 bytes do arquivo = 5kb
                file = Arquivo.removeBytes(file);//remove os primeiros 5120 bytes do arquivo = 5kb
                bf.write(b);
                bf.flush();
                s.nextLine();
            } catch (java.util.NoSuchElementException nse) {
            }
        }
        bf.write(file);
        bf.flush();
    }
}
