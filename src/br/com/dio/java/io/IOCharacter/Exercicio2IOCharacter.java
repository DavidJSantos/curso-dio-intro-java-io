package br.com.dio.java.io.IOCharacter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

//Abra o teclado para escrever 3 filmes que você recomendaria e armazene em "recomendações.txt".
public class Exercicio2IOCharacter {

    public static void lerTecladoEscreverDocumento() throws IOException {

        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Digite 3 recomendações de filmes: ");
        pw.flush();

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        File f = new File("recomendacoes.txt");

        BufferedWriter bw = new BufferedWriter(new FileWriter(f.getName()));

        do {
            bw.write(line);
            bw.newLine();
            bw.flush();
            line = sc.nextLine();
        }while (!(line.equalsIgnoreCase("fim")));

        pw.printf("Arquivo \"%s\" criado com sucesso!", f.getName());

        pw.close();
        sc.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        lerTecladoEscreverDocumento();
    }
}
