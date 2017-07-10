package com.company;


import java.util.Calendar;
import java.text.*;
import java.util.Scanner;

public class Main {
    static int MAX = 10000;
    static int qntSalas;
    static int qntLaboratorio;
    static int qntAuditorio;
    static int qntProjetor;

    static int      qntRecurso = 0;
    static String[] recursoId = new String[MAX];
    static String[] recursoStatus = new String[MAX];
    static int[]    recursoDataDia = new int[MAX];
    static int[]    recursoDataMes = new int[MAX];
    static int[]    recursoDataAno = new int[MAX];
    static int[]    recursoHoraInicio = new int[MAX];
    static int[]    recursoHoraTermino = new int[MAX];
    static int[]    recursoMinutoInicio = new int[MAX];
    static int[]    recursoMinutoTermino = new int[MAX];
    static String[] recursoResponsavel = new String[MAX];

    static int      qntUsuario = 0;
    static String[] nomeUsuario = new String[MAX];
    static String[] emailUsuario = new String[MAX];
    static String[] cargoUsuario = new String[MAX];

    public static void exibirMenu(){

    }

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
        scanner.nextLine();
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

        System.out.println("Insira o email do usuario:");
        emailUsuario[qntUsuario] = scanner.nextLine().toLowerCase();
        System.out.println("Parabens, cadastrou o usuario com sucesso");
        pularLinha();
        qntUsuario++;
    }



    public static void cadastrarRecurso(int qntAuditorio, int qntLaboratorio, int qntProjetor, int qntSalas) {
        Scanner scanner = new Scanner(System.in);
        int comando;
        int id;
        System.out.println("Insira a qual usuario voce quer cadastrar o recurso");
        exibirUsuariosNaoAlunos();
        id = scanner.nextInt();
        id = id - 1;
        recursoResponsavel[qntRecurso] = nomeUsuario[id];
        System.out.println("Insira qual tipo de recurso voce deseja alocar:");
        System.out.println("1 - Auditorio");
        System.out.println("2 - Laboratorio");
        System.out.println("3 - Projetor");
        System.out.println("4 - Sala");
        comando = scanner.nextInt();
        switch (comando){
            case 1:
                recursoId[qntRecurso] = "Auditorio";
                break;
            case 2:
                recursoId[qntRecurso] = "Laboratorio";
                break;
            case 3:
                recursoId[qntRecurso] = "Projetor";
                break;
            case 4:
                recursoId[qntRecurso] = "Sala";
                break;
            }
        recursoStatus[qntRecurso] = "Em processo de alocacao";
        System.out.println("Recurso cadastrado com sucesso!");
        qntRecurso++;
    }

    public static void alocarRecurso(int qntAuditorio, int qntLaboratorio, int qntProjetor, int qntSalas) {
        Scanner scanner = new Scanner(System.in);
        int id;
        System.out.println("Insira a qual recurso voce deseja alocar");
        exibirRecursosEmAlocacao();
        id = scanner.nextInt();
        System.out.println("Insira o mes em que o recurso sera usado");
        recursoDataMes[id] = scanner.nextInt();
        System.out.println("Insira o dia em que o recurso sera usado");
        recursoDataDia[id] = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Insira a hora em que o recurso comecara a ser usado (ex: 13:30)");
        String timeStringBegin = scanner.nextLine();
        int time[] = new int[2];
        time = convertStringToTime(timeStringBegin);
        recursoHoraInicio[id] = time[0];
        recursoMinutoInicio[id] = time[1];

        System.out.println("Insira o minuto em que o recurso acabara de ser usado (ex: 13:30)");
        String timeStringEnd = scanner.nextLine();
        time = convertStringToTime(timeStringEnd);
        recursoHoraInicio[id] = time[0];
        recursoMinutoInicio[id] = time[1];

        recursoStatus[id] = "Alocado";
    }


    public static int[] convertStringToTime(String timeString){
        int time[] = new int[2];
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            sdf.setLenient(false);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(timeString));
            time[0] = calendar.get(Calendar.HOUR_OF_DAY);
            time[1] = calendar.get(Calendar.MINUTE);
            return time;
        } catch (java.text.ParseException ex)
        {

        }
        return time;
    }



    public static void exibirUsuario() {
        for (int i = 0; i < qntUsuario; i++) {
            System.out.println((i + 1) + "- " + "Nome: " + nomeUsuario[i] + " Cargo: " + cargoUsuario[i]);
        }
        System.out.println("\n");
    }

    public static void exibirUsuariosNaoAlunos() {
        for(int i = 0, j = 1; i < qntUsuario; i++)
        {
            if(!(cargoUsuario[i].equals("ALUNO DE GRADUACAO") || cargoUsuario[i].equals("ALUNO DE MESTRADO") || cargoUsuario[i].equals("ALUNO DE DOUTORADO")))
            {
                System.out.println(j + "- Nome: " + nomeUsuario[i] + "; Cargo: " + cargoUsuario[i]);
                j++;
            }
        }
    }

    public static void exibirRecursosEmAlocacao() {
        int j = 1;
        for(int i = 0; i < qntRecurso; i++)
        {
            if(recursoStatus[i].equals("Em processo de alocacao"))
            {
                System.out.println(j + "-Responsavel: " + recursoResponsavel[i] + "; Tipo: " + recursoId[i]);
                j++;
            }
        }

    }

    public static void editarAlocacao() {

    }

    public static void consultarUsuario()
    {
        Scanner scanner = new Scanner(System.in);
        int id;
        System.out.println("Qual usuario voce deseja consultar?");
        exibirUsuario();
        id = scanner.nextInt();
        id = id - 1;

        System.out.println("Nome: " + nomeUsuario[id] + "/n" + "Cargo: " + cargoUsuario[id] + "/n" + emailUsuario[id] + "/n");
    }

    public static void consultarRecurso()
    {

    }

    public static void pularLinha()
    {
        for (int i = 0; i < 10; i++)
            System.out.println("\n");
    }

    public static void main(String[] args)
    {
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
        while (n == 1)
        {

            System.out.println("1 - Cadastrar Usuario");
            System.out.println("2 - Cadastrar Recurso");
            System.out.println("3 - Alocar Recurso");
            System.out.println("4 - Editar Alocacao");
            System.out.println("5 - Consultar Usuario");
            System.out.println("6 - Consultar Recurso");
            System.out.println("7 - Exibir Usuarios");
            System.out.println("8 - Sair ");

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
                    alocarRecurso(qntAuditorio, qntLaboratorio, qntProjetor, qntSalas);
                    break;
                case 4:
                    editarAlocacao();
                    break;
                case 5:
                    consultarUsuario();
                case 6:
                    consultarRecurso();
                case 7:
                    exibirUsuario();
                case 8:
                    n = 0;
                    break;

            }

        }
    }
}
