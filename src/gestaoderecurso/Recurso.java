package gestaoderecurso;

import java.util.List;
import java.util.Scanner;

public class Recurso {
    static int MAX = 10000;
    static Scanner scanner = new Scanner(System.in);

    private String id;
    private String status;
    private String responsavel;
    private String responsavelCargo;
    private String atividade;
    private String titulo;
    private String descricao;
    private int QntParticipantes;
    private String participantes;
    private String recursoMaterialApoio;
    private Horario horario;
    private int qntRecursoEmProcesso = 0;
    private int qntRecursoAlocado = 0;
    private int qntRecursoAndamento = 0;
    private int qntRecursoConcluido = 0;
    private int qntAtividadeAula = 0;
    private int qntAtividadeApresentacao = 0;
    private int qntAtividadeLaboratorio = 0;

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public String getResponsavelCargo() {
        return responsavelCargo;
    }

    public String getAtividade() {
        return atividade;
    }

    public Recurso(List<Usuario> usuarioList) {

        int comando;
        int id;
        System.out.println("------Cadastro de Recurso-----");
        System.out.println("Insira o id do usuario no qual voce quer cadastrar o recurso");
        exibirUsuariosNaoAlunos(usuarioList);
        id = scanner.nextInt();
        Usuario usuario = usuarioList.get(id);
        System.out.println("Insira qual tipo de recurso voce deseja alocar:");
        System.out.println("1 - Auditorio");
        System.out.println("2 - Laboratorio");
        System.out.println("3 - Projetor");
        System.out.println("4 - Sala");
        comando = scanner.nextInt();
        switch (comando) {
            case 1:
                this.id = "Auditorio";
                break;
            case 2:
                this.id = "Laboratorio";
                break;
            case 3:
                this.id = "Projetor";
                break;
            case 4:
                this.id = "Sala";
                break;
        }
        this.responsavel = usuario.getNome();
        this.responsavelCargo = usuario.getCargo();
        this.status = "Em processo de alocacao";
        System.out.println("Recurso cadastrado com sucesso!");
    }


}