package arquivo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

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

    public static int compareImage(File original, File comparando) throws IOException {
        BufferedImage file1 = ImageIO.read(original);
        BufferedImage file2 = ImageIO.read(comparando);

        JOptionPane.showMessageDialog(null, original.toString());
        JOptionPane.showMessageDialog(null, comparando.toString());

        int cont, cont2, total, porcen = 0, originalWidth, originalHeight, vintePCentoAltura;
        if (file1.getHeight() % 2 == 1) {
            originalHeight = (file1.getHeight() / 2) + 1;
        } else {
            originalHeight = (file1.getHeight() / 2);
        }
        if (file1.getWidth() % 2 == 1) {
            originalWidth = ((file1.getWidth() / 2) + 1);
        } else {
            originalWidth = ((file1.getWidth() / 2));
        }
        vintePCentoAltura = (int) (0.2 * originalHeight);
        for (int i = 0; i < file2.getWidth(); i++) {
            for (int j = 0; j < file2.getHeight(); j++) {
                cont = 0;
                cont2 = 0;
                for (int k = 0; k < originalWidth; k++) {
                    if (i + k >= file2.getWidth()) {
                        break;
                    }
                    if (k == vintePCentoAltura) {
                        if ((cont * 100) / (cont + cont2) <= 10) {
                            break;
                        }
                    }
                    for (int l = 0; l < originalHeight; l++) {
                        if (j + l >= file2.getHeight()) {
                            break;
                        }
                        if (file1.getRGB(k, l) == file2.getRGB(i + k, j + l)) {
                            cont = cont + 1;
                        } else {
                            cont2 = cont2 + 1;
                        }
                    }
                }
                total = cont + cont2;
                porcen = (cont * 100) / total;
                if (porcen >= 90) {
                    return porcen;
                }
            }
        }
        return porcen;
    }
}
