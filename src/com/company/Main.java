package com.company;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

public class Main {
    static int MAX = 10000;
    static int qntSalas;
    static int qntSalasOcup = 0;
    static int qntLaboratorio;
    static int qntLaboratorioOcup = 0;
    static int qntAuditorio;
    static int qntAuditorioOcup = 0;
    static int qntProjetor;
    static int qntProjetorOcup = 0;

    static int qntRecurso = 0;
    static String[] recursoId = new String[MAX];
    static String[] recursoStatus = new String[MAX];
    static String[] recursoData = new String[MAX];
    static String[] recursoHoraInicio = new String[MAX];
    static String[] recursoHoraTermino = new String[MAX];
    static String[] recursoResponsavel = new String[MAX];

    static int qntUsuario = 0;
    static String[] nomeUsuario = new String[MAX];
    static String[] cargoUsuario = new String[MAX];


    public static void cadastrarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o nome do usuario:");
        nomeUsuario[qntUsuario] = scanner.nextLine().toUpperCase();

        System.out.println("Insira o tipo de usuario:");
        System.out.println("1 - Aluno de graduacao");
        System.out.println("2 - Aluno de mestrado");
        System.out.println("3 - Aluno de Doutorado");
        System.out.println("4 - Professor");
        System.out.println("5 - Pesquisador");
        System.out.println("6 - Administrador");

        int comando = scanner.nextInt();
        switch (comando){
            case 1:
                cargoUsuario[qntUsuario] = "ALUNO DE GRADUACAO";
                break;
            case 2:
                cargoUsuario[qntUsuario] = "ALUNO DE MESTRADO";
                break;
            case 3:
                cargoUsuario[qntUsuario] = "ALUNO DE DOUTORADO";
                break;
            case 4:
                cargoUsuario[qntUsuario] = "PROFESSOR";
                break;
            case 5:
                cargoUsuario[qntUsuario] = "PESQUISADOR";
                break;
            case 6:
                cargoUsuario[qntUsuario] = "ADMINISTRADOR";
                break;
        }

        System.out.println("Parabens, voce esta cadastrado, o seu id é: " + qntUsuario);
        qntUsuario++;
    }

    public static void exibirUsuario() {
        for (int i = 0; i < qntUsuario; i++) {
            System.out.println((i + 1) + "- " + "Nome: " + nomeUsuario[i] + " Cargo: " + cargoUsuario[i] + "ID: " + i);
        }
        System.out.println("\n");
    }

    public static void cadastrarRecurso(int qntAuditorio, int qntLaboratorio, int qntProjetor, int qntSalas) {
        Scanner scanner = new Scanner(System.in);
        int comando;
        int id;
        System.out.println("Insira seu id:");
        id = scanner.nextInt();
        recursoResponsavel[qntRecurso] = nomeUsuario[id];
        if(cargoUsuario[id].equals("ALUNO DE GRADUACAO") || cargoUsuario[id].equals("ALUNO DE MESTRADO") || cargoUsuario[id].equals("ALUNO DE DOUTORADO")){
            System.out.println("Apenas administradores, professores ou pesquisadores podem alocar algum recurso");
            return;
        }
        else{
            System.out.println("Insira qual tipo de recurso voce deseja alocar:");
            System.out.println("1 - Auditorio");
            System.out.println("2 - Laboratorio");
            System.out.println("3 - Projetor");
            System.out.println("4 - Sala");
            comando = scanner.nextInt();
            switch (comando){
                case 1:
                    recursoId[id] = "Auditorio";
                    break;
                case 2:
                    recursoId[id] = "Laboratorio";
                    break;
                case 3:
                    recursoId[id] = "Projetor";
                    break;
                case 4:
                    recursoId[id] = "Sala";
                    break;
            }
            System.out.println("Recurso cadastrado com sucesso!");
            qntRecurso++;
        }


    }

    public static void alocarRecurso() {

    }

    public static void editarAlocacao() {

    }

    public static void pularLinha() {
        for (int i = 0; i < 10; i++)
            System.out.println("\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira a quantidade de salas:");
        qntSalas = scanner.nextInt();
        System.out.println("Insira a quantidade de laboratorios:");
        qntLaboratorio = scanner.nextInt();
        System.out.println("Insira a quantidade de auditorios:");
        qntAuditorio = scanner.nextInt();
        System.out.println("Insira a quantidade de projetores:");
        qntProjetor = scanner.nextInt();


        int comando;
        int n = 1;
        while (n == 1) {

            System.out.println("1 - Cadastrar Usuario");
            System.out.println("2 - Cadastrar Recurso");
            System.out.println("3 - Alocar Recurso");
            System.out.println("4 - Editar Alocacao");
            System.out.println("5 - Exibir Usuarios");
            System.out.println("6 - Sair ");

            comando = scanner.nextInt();
            pularLinha();

            switch (comando) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    cadastrarRecurso(qntAuditorio, qntLaboratorio, qntProjetor, qntSalas);
                    break;
                case 3:
                    alocarRecurso();
                    break;
                case 4:
                    editarAlocacao();
                    break;
                case 5:
                    exibirUsuario();
                case 6:
                    n = 0;
                    break;

            }

        }
    }
}
