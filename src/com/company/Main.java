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
    static int[]    recursoDataDiaInicio = new int[MAX];
    static int[]    recursoDataMesInicio = new int[MAX];
    static int[]    recursoDataAnoInicio = new int[MAX];
    static int[]    recursoHoraInicio = new int[MAX];
    static int[]    recursoMinutoInicio = new int[MAX];
    static int[]    recursoDataInicio = new int[MAX];
    static int[]    recursoDataDiaTermino = new int[MAX];
    static int[]    recursoDataMesTermino = new int[MAX];
    static int[]    recursoDataAnoTermino = new int[MAX];
    static int[]    recursoHoraTermino = new int[MAX];
    static int[]    recursoMinutoTermino = new int[MAX];
    static int[]    recursoDataTermino = new int[MAX];
    static String[] recursoResponsavel = new String[MAX];
    static String[] recursoResponsavelCargo = new String[MAX];
    static String[] recursoAtividade = new String[MAX];
    static String[] recursoTitulo = new String[MAX];
    static String[] recursoDescricao = new String[MAX];
    static String[][] recursoParticipantes = new String[MAX][1000];
    static int[]    recursoQntParticipantes = new int[MAX];
    static String[] recursoMaterialApoio = new String[MAX];

    static int      qntUsuario = 0;
    static String[] nomeUsuario = new String[MAX];
    static String[] emailUsuario = new String[MAX];
    static String[] cargoUsuario = new String[MAX];

    static int qntRecursoEmProcesso = 0;
    static int qntRecursoAlocado = 0;
    static int qntRecursoAndamento = 0;
    static int qntRecursoConcluido = 0;
    static int qntAtividadeAula = 0;
    static int qntAtividadeApresentacao = 0;
    static int qntAtividadeLaboratorio = 0;


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
        System.out.println("Insira o id do usuario no qual voce quer cadastrar o recurso");
        exibirUsuariosNaoAlunos();
        id = scanner.nextInt();
        recursoResponsavel[qntRecurso] = nomeUsuario[id];
        recursoResponsavelCargo[qntRecurso] = cargoUsuario[id];
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
        System.out.println("Insira o id do recurso voce deseja alocar");
        exibirRecursosEmAlocacao();
        id = scanner.nextInt();
        System.out.println("Insira o ano em que o recurso sera usado");
        recursoDataAnoInicio[id] = scanner.nextInt();
        System.out.println("Insira o mes em que o recurso sera usado");
        recursoDataMesInicio[id] = scanner.nextInt();
        System.out.println("Insira o dia em que o recurso sera usado");
        recursoDataDiaInicio[id] = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Insira o ano em que o recurso terminara de ser usado");
        recursoDataAnoTermino[id] = scanner.nextInt();
        System.out.println("Insira o mes em que o recurso terminara de ser usado");
        recursoDataMesTermino[id] = scanner.nextInt();
        System.out.println("Insira o dia em que o recurso terminara de ser usado");
        recursoDataDiaTermino[id] = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Insira a hora em que o recurso comecara a ser usado (ex: 13:30)");
        String timeStringBegin = scanner.nextLine();
        int time[] = new int[2];
        time = convertStringToTime(timeStringBegin);
        recursoHoraInicio[id] = time[0];
        recursoMinutoInicio[id] = time[1];
        recursoDataInicio[id] = (recursoDataAnoInicio[id] * 365 * 24 * 60) + (recursoDataMesInicio[id] * 30 * 24 * 60) + (recursoDataDiaInicio[id] * 24 * 60) + (recursoHoraInicio[id] * 60) + (recursoMinutoInicio[id]);

        System.out.println("Insira o minuto em que o recurso acabara de ser usado (ex: 13:30)");
        String timeStringEnd = scanner.nextLine();
        time = convertStringToTime(timeStringEnd);
        recursoHoraTermino[id] = time[0];
        recursoMinutoTermino[id] = time[1];
        recursoDataTermino[id] = (recursoDataAnoTermino[id] * 365 * 24 * 60) + (recursoDataMesTermino[id] * 30 * 24 * 60) + (recursoDataDiaTermino[id] * 24 * 60) + (recursoHoraTermino[id] * 60) + (recursoMinutoTermino[id]);

        int i;
        for(i = 0; i < qntRecurso; i++)
        {
            if(!recursoStatus[i].equals("Em processo de alocacao") && (id != i))
            {
                if(!recursoId[id].equals(recursoId[i]))
                {
                    if((recursoDataInicio[id] > recursoDataInicio[i] && recursoDataInicio[id] < recursoDataTermino[i]) || (recursoDataTermino[id] < recursoDataTermino[i] && recursoDataTermino[id] > recursoDataInicio[i]))
                    {
                        System.out.println("Existe outro recurso marcado para esse horario.");
                        return;
                    }
                }
            }
        }

        int comando;
        System.out.println("Insira o tipo de atividade");
        System.out.println("1 - Aula Tradicional");
        System.out.println("2 - Aprensentacao");
        System.out.println("3 - Laboratorio");
        comando = scanner.nextInt();
        scanner.nextLine();
        switch(comando)
        {
            case 1:
                if(recursoResponsavelCargo[id].equals("PROFESSOR"))
                {
                    recursoAtividade[id] = "Aula Tradicional";
                    qntAtividadeAula++;
                }
                else
                    {
                    System.out.println("Apenas professores podem alocar este tipo de atividade");
                    return;
                }
                break;
            case 2:
                recursoAtividade[id] = "Apresentacao";
                qntAtividadeApresentacao++;
                break;
            case 3:
                if(recursoResponsavelCargo[id].equals("PROFESSOR"))
                {
                    recursoAtividade[id] = "Laboratorio";
                    qntAtividadeLaboratorio++;
                }
                else{
                    System.out.println("Apenas professores podem alocar este tipo de atividade");
                    return;
                }
                break;
        }

        System.out.println("Insira o titulo da atividade");
        recursoTitulo[id] = scanner.nextLine();
        System.out.println("Insira a descricao da atividade");
        recursoDescricao[id] = scanner.nextLine();

        recursoQntParticipantes[id] = 0;
        System.out.println("Insira os usuarios participantes do recurso (digite \"SAIR\" quando tiver inserido todos os participantes");
        String participantes;
        while(true){
            participantes = scanner.nextLine();
            if(!participantes.equals("SAIR"))
                recursoParticipantes[id][recursoQntParticipantes[id]] = participantes;
            else
                break;
            recursoQntParticipantes[id]++;
        }

        System.out.println("Insira o material de apoio");
        recursoMaterialApoio[id] = scanner.nextLine();

        recursoStatus[id] = "Alocado";
    }

    public static void relatorio(){
        System.out.println("Numero de usuarios: " + qntUsuario);
        for(int i = 0; i < qntRecurso; i++)
        {
            if(recursoStatus[i].equals("Em processo de alocacao"))
                qntRecursoEmProcesso++;
            if(recursoStatus[i].equals("Alocado"))
                qntRecursoAlocado++;
            if(recursoStatus[i].equals("Em andamento"))
                qntRecursoAndamento++;
            if(recursoStatus[i].equals("Concluido"))
                qntRecursoConcluido++;
        }
        System.out.println("Numero de recursos em processo de alocacao: " + qntRecursoEmProcesso);
        System.out.println("Numero de recursos alocados: " + qntRecursoAlocado);
        System.out.println("Numero de recursos em andamento: " + qntRecursoAndamento);
        System.out.println("Numero de recursos concluido: " + qntRecursoConcluido);
        System.out.println("Numero de atividade de aula: " +  qntAtividadeAula);
        System.out.println("Numero de atividade de laboratorio: " +  qntAtividadeLaboratorio);
        System.out.println("Numero de atividade de apresentacao: " +  qntAtividadeApresentacao);
    }

    public static void consultarUsuario()
    {
        Scanner scanner = new Scanner(System.in);
        int id;
        System.out.println("Qual usuario voce deseja consultar?");
        exibirUsuario();
        id = scanner.nextInt();
        scanner.nextLine();
        id = id - 1;

        System.out.println("Nome: " + nomeUsuario[id] + "/n" + "Cargo: " + cargoUsuario[id] + "/n" + emailUsuario[id] + "/n");
        System.out.println("Atividades:");
        for(int i = 0, j = 1; i < qntRecurso; i++)
        {
            if(recursoResponsavel[i].equals(nomeUsuario[id]))
            {
                System.out.println(j + "- Recurso: " + recursoId[i] + "; Tipo: " + recursoAtividade[i]);
                j++;
            }
        }
    }

    public static void consultarRecurso()
    {
        Scanner scanner = new Scanner(System.in);
        int id;
        System.out.println("Qual recurso voce deseja consultar?");
        exibirRecurso();
        id = scanner.nextInt();
        scanner.nextLine();
        id = id - 1;

        if(!recursoStatus[id].equals("Em processo de alocacao"))
        {
            System.out.println("Atividade: " + recursoAtividade[id]);
            System.out.println("Titulo: " + recursoTitulo[id]);
            System.out.println("Descicao: " + recursoDescricao[id]);
            System.out.println("Material de apoio: " + recursoMaterialApoio[id]);
            System.out.println("Data de inicio: " + recursoDataDiaInicio[id] + "/" + recursoDataMesInicio[id] + "/" + recursoDataAnoInicio[id]);
            System.out.println("Data de termino " + recursoDataDiaTermino[id] + "/" + recursoDataMesTermino[id] + "/" + recursoDataAnoTermino[id]);
            System.out.println("Horario de inicio: " + recursoHoraInicio[id] + ":" + recursoMinutoInicio[id]);
            System.out.println("Horario de termino: " + recursoHoraTermino[id] + ":" + recursoMinutoTermino[id]);
        }
    }



    public static void exibirUsuario() {
        for (int i = 0; i < qntUsuario; i++)
        {
            System.out.println((i + 1) + "- Nome: " + nomeUsuario[i] + "; Cargo: " + cargoUsuario[i]);
        }
        System.out.println("\n");
    }

    public static void exibirRecurso() {
        for(int i = 0; i < qntRecurso; i++)
        {
            System.out.println((i + 1) + "- " + "Recurso: " + recursoId[i] + "; Responsavel: " + recursoResponsavel[i] + "; Status: " + recursoStatus[i]);
        }

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

    public static void exibirUsuariosNaoAlunos() {
        for(int i = 0; i < qntUsuario; i++)
        {
            if(!(cargoUsuario[i].equals("ALUNO DE GRADUACAO") || cargoUsuario[i].equals("ALUNO DE MESTRADO") || cargoUsuario[i].equals("ALUNO DE DOUTORADO")))
            {
                System.out.println("Id: "+ i + "; Nome: " + nomeUsuario[i] + "; Cargo: " + cargoUsuario[i]);
            }
        }
    }

    public static void exibirRecursosEmAlocacao() {
        for(int i = 0; i < qntRecurso; i++)
        {
            if(recursoStatus[i].equals("Em processo de alocacao"))
            {
                System.out.println("Id: "+ i + "; Responsavel: " + recursoResponsavel[i] + "; Tipo: " + recursoId[i]);
            }
        }

    }



    public static void pularLinha()
    {
        for (int i = 0; i < 10; i++)
            System.out.println("\n");
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int comando;
        int n = 1;
        while (n == 1)
        {

            System.out.println("1 - Cadastrar Usuario");
            System.out.println("2 - Cadastrar Recurso");
            System.out.println("3 - Alocar Recurso");
            System.out.println("4 - Exibir Relatorio");
            System.out.println("5 - Consultar Usuario");
            System.out.println("6 - Consultar Recurso");
            System.out.println("7 - Sair ");

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
                    relatorio();
                    break;
                case 5:
                    consultarUsuario();
                    break;
                case 6:
                    consultarRecurso();
                    break;
                case 7:
                    n = 0;
                    break;

            }

        }
    }
}
