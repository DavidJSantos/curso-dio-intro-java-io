package br.com.dio.java.io.IOCharacter;

import java.io.*;

//Faça uma cópia do arquivo "recomendações.txt" e agora adicione 3 recomendações de livros.
public class Exercicio3IOCharacter {

    public static void copiarArquivo() throws IOException {

        // Abri o arquivo com metodo "File", recebendo como atributo o pathname do arquivo
        File f = new File("/home/david/Projeto_Java/curso-dio-intro-java-io/recomendacoes.txt");

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
        System.out.printf("Arquivo \"%s\" criado com sucesso! (%d bytes)", nmArquivoCopia, fCopy.length());
    }
    public static void AddInfoArquivo(){

    }

    public static void main(String[] args) throws IOException {
        copiarArquivo();
    }
}
