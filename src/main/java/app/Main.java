package app;

import dominio.Bootcamp;
import dominio.Curso;
import dominio.Dev;
import dominio.Mentoria;
import exception.ContentNotFoundException;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {

            Curso curso1 = new Curso();
            curso1.setTitulo("Curso de Java POO");
            curso1.setDescricao("Curso de Java");
            curso1.setCargaHoraria(15);

            Curso curso2 = new Curso();
            curso2.setTitulo("Curso de C#");
            curso2.setDescricao("Curso de C#");
            curso2.setCargaHoraria(45);

            Mentoria mentoria1 = new Mentoria();
            mentoria1.setTitulo("Mentoria de Java");
            mentoria1.setDescricao("Mentoria de Java");

            Bootcamp bootcamp = new Bootcamp();
            bootcamp.setNome("Bootcamp Java Developer");
            bootcamp.setDescricao("Bootcamp Java Developer");
            bootcamp.getConteudos().add(curso1);
            bootcamp.getConteudos().add(curso2);
            bootcamp.getConteudos().add(mentoria1);

            Dev dev1 = new Dev();
            dev1.setNome("Swellington Soares");
            dev1.inscreverBootcamp(bootcamp);
            System.out.println("Conteúdos inscritos de Swellington: " + dev1.getConteudosInscritos());
            dev1.progredir();
            dev1.progredir();
            System.out.println("Conteúdos inscritos de Swellington: " + dev1.getConteudosInscritos());
            System.out.println("Conteúdos concluídos de Swellington: " + dev1.getConteudosConcluidos());
            System.out.println("XP: " + dev1.calculaTotalXp());

            System.out.println();
            System.out.println();

            Dev dev2 = new Dev();
            dev2.setNome("João");
            dev2.inscreverBootcamp(bootcamp);
            System.out.println("Conteúdos inscritos de João: " + dev2.getConteudosInscritos());
            dev2.progredir();
            System.out.println("Conteúdos inscritos de João: " + dev2.getConteudosInscritos());
            System.out.println("Conteúdos concluídos de João: " + dev2.getConteudosConcluidos());
            System.out.println("XP: " + dev2.calculaTotalXp());


        } catch (ContentNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }
}
