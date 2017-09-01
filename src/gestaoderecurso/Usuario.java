package gestaoderecurso;
import java.util.*;

public class Usuario {
    static Scanner scanner = new Scanner(System.in);
    static int MAX = 10000;
    private String nome;
    private String email;
    private String cargo;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCargo() {
        return cargo;
    }

    public Usuario() {
        System.out.println("------Cadastro de Usuario-----");
        System.out.println("Insira o nome do usuario:");

        this.nome = scanner.nextLine().toUpperCase();

        System.out.println("Insira o tipo de usuario:");
        System.out.println("1 - Aluno de graduacao");
        System.out.println("2 - Aluno de mestrado");
        System.out.println("3 - Aluno de Doutorado");
        System.out.println("4 - Professor");
        System.out.println("5 - Pesquisador");

        int comando = scanner.nextInt();
        scanner.nextLine();

        switch (comando) {
            case 1:
                this.cargo = "ALUNO DE GRADUACAO";
                break;
            case 2:
                this.cargo = "ALUNO DE MESTRADO";
                break;
            case 3:
                this.cargo = "ALUNO DE DOUTORADO";
                break;
            case 4:
                this.cargo = "PROFESSOR";
                break;
            case 5:
                this.cargo = "PESQUISADOR";
                break;
        }

        System.out.println("Insira o email do usuario:");
        this.email = scanner.nextLine().toLowerCase();
        System.out.println("Parabens, cadastrou o usuario com sucesso");
    }



    public static void exibirTodosUsuarios(List<Usuario> usuarioList) {
        int qntUsuario = usuarioList.size();
        for (int i = 0; i < qntUsuario; i++) {
            Usuario usuario = usuarioList.get(i);
            System.out.println((i + 1) + "- Nome: " + usuario.nome + "; Cargo: " + usuario.cargo);
        }
        System.out.println("\n");
    }


    public static void consultarUsuario(List<Usuario> usuarioList, List<Recurso> recursoList) {
        Scanner scanner = new Scanner(System.in);
        int id;
        System.out.println("Qual usuario voce deseja consultar?");
        exibirTodosUsuarios(usuarioList);
        id = scanner.nextInt() - 1;
        scanner.nextLine();


        Usuario usuario = usuarioList.get(id);
        //usuario.exibirUsuario(recursoList, id);
    }

    public void exibirUsuario(List<Recurso> recursoList, int id){
        System.out.println("Nome: " + this.nome + "\n" + "Cargo: " + this.cargo + "\n" + this.email + "/n");
        System.out.println("Atividades:");

        int qntRecurso = recursoList.size();

        Recurso recurso = recursoList.get(id);
        for (int i = 0, j = 1; i < qntRecurso; i++) {
            if (recurso.getResponsavel().equals(this.nome)) {
                System.out.println(j + "- Recurso: " + recurso.getId() + "; Tipo: " + recurso.getAtividade());
                j++;
            }
        }
    }
}