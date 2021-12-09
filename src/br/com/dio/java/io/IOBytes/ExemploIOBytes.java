package br.com.dio.java.io.IOBytes;

import java.io.*;

// Faça uma cópia do arquivo "recomendacoes-copy.txt".
public class ExemploIOBytes {

    public static void copiarArquivo() throws IOException {
        File f = new File("/home/david/Projeto_Java/curso-dio-intro-java-io/recomendacoes-copy.txt");
        String nomeArquivo = f.getName();

        // Criando o fluxo de entrada do arquivo
        /*InputStream is = new FileInputStream(f.getName());
        BufferedInputStream bis = new BufferedInputStream(is);*/
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f.getName()));

        // Preparando o nome do documento a ser criado
        String nmArquivoCopia = nomeArquivo.substring(0 ,nomeArquivo.indexOf(".")).concat("2.txt");

        // Recebendo o documento
        File fCopy = new File(nmArquivoCopia);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(nmArquivoCopia));

        // Carregando a cópia do documento (O valor -1 em line indica o final do documento)
        int line = 0;
        while ((line = bis.read()) != -1){
            bos.write((char) line);
            bos.flush();
        }
        bis.close();
        bos.close();

        PrintStream ps = new PrintStream(System.out);
        ps.printf("Arquivo \"%s\" criado com sucesso! (%d bytes)%n", nmArquivoCopia, fCopy.length());
        ps.printf("Local do arquivo: %s", fCopy.getAbsolutePath());

    }

    public static void main(String[] args) throws IOException {
        copiarArquivo();
    }

}
