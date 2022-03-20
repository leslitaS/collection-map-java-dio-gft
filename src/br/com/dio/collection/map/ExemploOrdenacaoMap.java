package br.com.dio.collection.map;

import java.util.*;

public class ExemploOrdenacaoMap {

    public static void main(String[] args) {

        System.out.println();
        Map<String, Livro> meusLivros = new HashMap<>() {{

            put("Hawking , Stephen", new Livro("Uma breve historia do Tempo", 256));
            put("Duhigg , Charles", new Livro("O poder do habito", 408));
            put("Horari , Yuval Noah", new Livro("21 licoes para o Seculo 21", 432));

        }};

        for (Map.Entry<String, Livro> livro : meusLivros.entrySet()) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println("Ordem de insercao: ");
        Map<String, Livro> meusLivros1 = new LinkedHashMap<>() {{

            put("Hawking , Stephen", new Livro("Uma breve historia do Tempo", 256));
            put("Duhigg , Charles", new Livro("O poder do habito", 408));
            put("Horari , Yuval Noah", new Livro("21 licoes para o Seculo 21", 432));

        }};

        for (Map.Entry<String, Livro> livro : meusLivros1.entrySet()) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println("Ordem alfabetica nome autores: ");
        Map<String, Livro> meusLivros2 = new LinkedHashMap<>(meusLivros);

        for (Map.Entry<String, Livro> livro : meusLivros2.entrySet()) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println("=== Ordem alfabetica nome Livros: ===");
        Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
        meusLivros3.addAll(meusLivros.entrySet());

        for (Map.Entry<String, Livro> livro : meusLivros3) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println("=== Ordenar por numero de pagina: ===== ");

        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorPagina());
        meusLivros4.addAll(meusLivros.entrySet());

        for (Map.Entry<String, Livro> livro : meusLivros4) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getPaginas());
        }
    }

}



    class Livro {
        private String nome;
        private Integer paginas;

        public Livro(String nome, Integer paginas) {
            this.nome = nome;
            this.paginas = paginas;
        }

        public String getNome() {
            return nome;
        }

        public Integer getPaginas() {
            return paginas;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setPaginas(Integer paginas) {
            this.paginas = paginas;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Livro livro = (Livro) o;
            return nome.equals(livro.nome) && paginas.equals(livro.paginas);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nome, paginas);
        }

        @Override
        public String toString() {
            return "{" +
                    "nome='" + nome + '\'' +
                    ", paginas=" + paginas +
                    '}';
        }
    }



class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{


    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}

class ComparatorPagina implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getPaginas().compareTo(l2.getValue().getPaginas());
    }
}