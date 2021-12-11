package br.com.dio.java.io.IOBytes.IOObject;

/*
* Crie a classe Gato com as atributos nome, idade e cor:
* Instacie um objeto e serelialize
* Desserialize este objeto e mostre no console
* */

import java.io.*;

public class ExemploIOObject {

    public static void serealizacao() throws IOException {
        Gato gato = new Gato("Simba", 6,"Amarelado", true, false);

        File f = new File("gato");

        /*OutputStream os = new FileOutputStream(f.getPath());
        ObjectOutputStream oos = new ObjectOutputStream(os);*/
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f.getPath()));

        oos.writeObject(gato);

        PrintStream ps = new PrintStream(System.out);
        ps.printf("Arquivo \"%s\" criado com sucesso! (%d bytes)%n", f.getName(), f.length());

        oos.close();
        ps.close();
    }
    public static void desserializacao(String arquivo) throws IOException, ClassNotFoundException {

        /*InputStream is = new FileInputStream(arquivo);
        ObjectInputStream ois = new ObjectInputStream(is);*/
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));

        Gato objetoGato = (Gato) ois.readObject();

        System.out.printf("%nNome: %s%n",objetoGato.getNome());
        System.out.printf("Idade: %d%n",objetoGato.getIdade());
        System.out.printf("Cor: %s%n",objetoGato.getCor());
        System.out.println(objetoGato);

        ois.close();


    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //serealizacao();
        desserializacao("/home/david/Projeto_Java/curso-dio-intro-java-io/gato");
    }
}
