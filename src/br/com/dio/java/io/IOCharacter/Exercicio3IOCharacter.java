package br.com.dio.java.io.IOCharacter;

import java.io.*;

//Faça uma cópia do arquivo "recomendações.txt" e agora adicione 3 recomendações de livros.
public class Exercicio3IOCharacter {

    public static void copiarArquivo(File f) throws IOException {

        // Pegando o nome do arquivo e armazenando em uma String
        String nomeArquivo = f.getName();

        /*Reader r = new FileReader(nomeArquivo);
        BufferedReader br = new BufferedReader(r);*/

        // Lendo o arquivo utilizando o metodo "BufferedReader"
        BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
        String linha = br.readLine();

        // Criando o nome para o novo arquivo
        String nmArquivoCopia = nomeArquivo.substring(0, nomeArquivo.indexOf(".")).concat("-copy.txt");

        // Criando o novo arquivo com o metodo "File" passando como atributo o nome criado acima
        File fCopy = new File(nmArquivoCopia);

        // Instanciando o metodo "BufferedWriter" para iniciar a escrita do arquivo
        BufferedWriter bw = new BufferedWriter(new FileWriter(fCopy.getName()));

        // Percorrendo copiandoo cada linha do arquivo e escrevendo no novo arquivo até encontrar uma linha vazia (null)
        do {
            bw.write(linha);
            bw.newLine();
            bw.flush();
            linha = br.readLine();
        }while (!(linha == null));
        System.out.printf("Arquivo \"%s\" copiado com sucesso!%n", nomeArquivo);
        System.out.printf("Arquivo \"%s\" criado com sucesso! (%d bytes)%n", nmArquivoCopia, fCopy.length());

        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Recomende 3 livros: ");
        pw.flush();

        addInfoArquivo(fCopy.getName());

        pw.printf("Linhas adicionadas ao arquivo \"%s\" com sucesso! (%d bytes)", nmArquivoCopia, fCopy.length());

        br.close();
        bw.close();
        pw.close();
    }
    public static void addInfoArquivo(String arquivo) throws IOException {

        // Preparando a entrada das informações com o metodo "BufferedReader"
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Abrindo o prompt para receber a entrada
        String line = br.readLine();
        // Preparando o arquivo para receber a entrada. (O atributo append: "true" informa que a linha deve ser adicionada sem sobrescrever o arquivo).
        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true));

        // Escrevendo no arquivo, linha a linha
        do {
            bw.write(line);
            bw.newLine();
            bw.flush();
            line = br.readLine();
        }while (!(line.equalsIgnoreCase("fim")));

    }

    public static void main(String[] args) throws IOException {

        // Abrindo o arquivo com metodo "File", recebendo como atributo o pathname do arquivo
        File f = new File("/home/david/Projeto_Java/curso-dio-intro-java-io/recomendacoes.txt");
        copiarArquivo(f);

    }
}
