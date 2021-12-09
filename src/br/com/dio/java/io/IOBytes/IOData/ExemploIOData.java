package br.com.dio.java.io.IOBytes.IOData;

/*Crie um arquivo "peca-de-roupa.bin" e armazene:
1. Nome do produto, tamanho (P/M/G/U). quantidade e preço.
2. Leia este arquivo e imprima no console.*/

import java.io.*;
import java.util.Scanner;

public class ExemploIOData {
    public static void incluirProduto() throws IOException {
        File f = new File("/home/david/Documentos/peca-de-roupa.bin");

        PrintStream ps = new PrintStream(System.out);
        ps.flush();

        /*OutputStream os = new FileOutputStream(f.getPath());
        DataOutputStream dos = new DataOutputStream(os);*/
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(f.getPath()));

        Scanner sc = new Scanner(System.in);

        ps.print("Nome da peça: ");
        String nome = sc.nextLine();
        dos.writeUTF(nome);

        ps.print("Tamanho (P/M/G/U): ");
        char tamanho = sc.next().charAt(0);
        dos.writeChar(tamanho);

        ps.print("Quantidade: ");
        int quantidade = sc.nextInt();
        dos.writeInt(quantidade);

        ps.print("Preço da peça: ");
        double preco = sc.nextDouble();
        dos.writeDouble(preco);

        ps.printf("Arquivo \"%s\" criado com sucesso! (%d bytes) %n", f.getName(), f.length());
        ps.printf("Local do arquivo: %s%n", f.getAbsolutePath());

        lerProduto(f.getPath());

        ps.close();
        dos.close();
        sc.close();
    }

    public static void lerProduto(String caminhoArquivo) throws IOException {

        File f = new File(caminhoArquivo);

        /*InputStream is = new FileInputStream(f.getPath());
        DataInputStream dis = new DataInputStream(is);*/
        DataInputStream dis = new DataInputStream(new FileInputStream(f.getPath()));

        String nome = dis.readUTF();
        char tamanho = dis.readChar();
        int quantidade = dis.readInt();
        double preco = dis.readDouble();

        System.out.printf("Nome: %s%n", nome);
        System.out.printf("Tamanho: %s%n", tamanho);
        System.out.printf("Quantidade: %d%n", quantidade);
        System.out.printf("Preço: %.2f%n", preco);
        System.out.println();
        System.out.printf("Total do valor das peças: %.2f%n", (preco * quantidade));
        dis.close();

    }

    public static void main(String[] args) throws IOException {
        incluirProduto();
    }

}
