package arquivo;

import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import javax.imageio.ImageIO;

public class Arquivo {

    public static byte[] emBytes(File file) throws IOException {
        int tamanho = (int) file.length();
        byte[] arquivo = new byte[tamanho];
        java.io.FileInputStream inFile = null;
        try {
            inFile = new java.io.FileInputStream(file);
            inFile.read(arquivo, 0, tamanho);
        } catch (FileNotFoundException fnfex) {
        } catch (IOException ioex) {
        }
        return arquivo;
    }

    public static void emArquivo(byte[] arqui, String nome, String extention) {
        try {
            OutputStream output = new FileOutputStream(System.getProperty("user.dir").replace('\\', '/') + "/src/" + nome + extention);
            output.write(arqui);
            output.close();
            System.out.println("Arquivo salvo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] removeBytes(byte[] array) {
        byte[] b;
        if (array.length > 5120) {
            b = new byte[array.length - 5120];
        } else {
            b = new byte[array.length];
        }
        int j = 0;
        for (int i = 5120; i < array.length; i++) {
            b[j] = array[i];
            j++;
        }
        return b;
    }

    public static byte[] copyByte(byte[] array) {
        byte[] b = new byte[5120];
        if (array.length < 5120) {
            b = new byte[array.length];
        }
        System.arraycopy(array, 0, b, 0, 5120);
        return b;
    }

    public static byte[] binding(byte[] first, byte[] last) {
        byte[] b = new byte[first.length + last.length];
        System.arraycopy(first, 0, b, 0, first.length);
        int j = 0;
        System.arraycopy(last, 0, b, first.length, last.length);
        return b;
    }

    public static byte[] adjustBytes(byte[] original, int size) {
        byte[] b = new byte[size];
        System.arraycopy(original, 0, b, 0, size);
        return b;
    }

    

    public static void copyFile(File source, File destination) throws IOException {
        if (destination.exists()) {
            destination.delete();
        }
        FileChannel sourceChannel = null;
        FileChannel destinationChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destinationChannel = new FileOutputStream(destination).getChannel();
            sourceChannel.transferTo(0, sourceChannel.size(),
                    destinationChannel);
        } finally {
            if (sourceChannel != null && sourceChannel.isOpen()) {
                sourceChannel.close();
            }
            if (destinationChannel != null && destinationChannel.isOpen()) {
                destinationChannel.close();
            }
        }
    }

    public static int compareImage(String acesso, String comparar) {
        
        int porcen = 0;
        try {
            BufferedImage bis1 = ImageIO.read(new File(acesso));
            BufferedImage bis2 = ImageIO.read(new File(comparar));

            int cont = 0;

            PixelGrabber grab1 = new PixelGrabber(bis1, 0, 0, -1, -1, false);
            PixelGrabber grab2 = new PixelGrabber(bis2, 0, 0, -1, -1, false);

            if (grab1.grabPixels() && grab2.grabPixels()) {
                int largura1 = grab1.getWidth();
                int altura1 = grab1.getHeight();
                int largura2 = grab2.getWidth();
                int altura2 = grab2.getHeight();

                int[][] imageColors1 = new int[largura1][altura1];
                int[] data1 = (int[]) grab1.getPixels();
                for (int y = 0; y < altura1; y++) {
                    for (int x = 0; x < largura1; x++) {
                        imageColors1[x][y] = data1[(y * largura1) + x];
                    }
                }

                int[][] imageColors2 = new int[largura2][altura2];
                int[] data2 = (int[]) grab2.getPixels();
                for (int y = 0; y < altura2; y++) {
                    for (int x = 0; x < largura2; x++) {
                        imageColors2[x][y] = data2[(y * largura2) + x];
                    }
                }
                if (largura1 >= largura2 && altura1 >= altura2) {
                    for (int i = 0; i < largura2; i++) {
                        for (int j = 0; j < altura2; j++) {

                            if (imageColors1[i][j] == imageColors2[i][j]) {
                                cont++;
                            }
                        }
                    }

                }
                if (largura1 < largura2 && altura1 < altura2) {
                    for (int i = 0; i < largura1; i++) {
                        for (int j = 0; j < altura1; j++) {

                            if (imageColors1[i][j] == imageColors2[i][j]) {
                                cont++;
                            }
                        }
                    }

                }
                if (largura1 < largura2 && altura1 > altura2) {
                    for (int i = 0; i < largura1; i++) {
                        for (int j = 0; j < altura2; j++) {

                            if (imageColors1[i][j] == imageColors2[i][j]) {
                                cont++;
                            }
                        }
                    }

                }
                if (largura1 > largura2 && altura1 < altura2) {
                    for (int i = 0; i < largura2; i++) {
                        for (int j = 0; j < altura1; j++) {

                            if (imageColors1[i][j] == imageColors2[i][j]) {
                                cont++;
                            }
                        }
                    }

                }

            }

            int total = bis1.getHeight() * bis1.getWidth();
            porcen = (cont * 100) / total;
             return porcen;
        } catch (Exception e) {
            e.printStackTrace();
        }
         return porcen;
    }
}
