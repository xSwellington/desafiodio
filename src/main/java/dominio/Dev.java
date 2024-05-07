package dominio;

import exception.ContentNotFoundException;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Dev {
    private String nome;
    private final Set<Conteudo> conteudosInscritos = new HashSet<>();
    private final Set<Conteudo> conteudosConcluidos = new HashSet<>();

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevInscritos().add(this);
    }
    public void progredir() throws ContentNotFoundException {
       var conteudo = conteudosInscritos.stream().findFirst();
       if (conteudo.isPresent()){
           conteudosConcluidos.add(conteudo.get());
           conteudosInscritos.remove(conteudo.get());
       } else {
           throw new ContentNotFoundException();
       }
    }
    public double calculaTotalXp(){
        return conteudosConcluidos.stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();

    }

    @Override
    public String toString() {
        return "Dev{" +
                "nome='" + nome + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}
