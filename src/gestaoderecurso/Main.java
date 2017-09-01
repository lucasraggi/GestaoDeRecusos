package gestaoderecurso;

import java.util.Scanner;
import gestaoderecurso.Usuario;
import gestaoderecurso.Recurso;
import java.util.*;

public class Main {
    public Main(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    private static List<Usuario> usuarioList = new ArrayList<>();
    private static List<Recurso> recursoList = new ArrayList<>();

    public static void pularLinha() {
        for (int i = 0; i < 10; i++)
            System.out.println("\n");
    }

    public static void menuPrincipal(){
        Scanner scanner = new Scanner(System.in);


        int comando;
        int n = 1;
        while (n == 1) {
            System.out.println("------Menu Principal------");
            System.out.println("1 - Cadastrar Usuario");
            System.out.println("2 - Cadastrar Recurso");
            System.out.println("3 - Alocar Recurso");
            System.out.println("4 - Editar Recurso");
            System.out.println("5 - Exibir Relatorio");
            System.out.println("6 - Consultar Usuario");
            System.out.println("7 - Consultar Recurso");
            System.out.println("8 - Sair ");

            comando = scanner.nextInt();
            pularLinha();

            switch (comando) {
                case 1:
                    usuarioList.add(new Usuario());
                    break;
                case 2:
                    recursoList.add(new Recurso(usuarioList));
                    break;
                case 3:
                    //Recurso.alocarRecurso();
                    break;
                case 4:
                    //Recurso.editarRecurso();
                    break;
                case 5:
                    //Recurso.relatorio();
                    break;
                case 6:
                    Usuario.consultarUsuario(usuarioList, recursoList);
                    break;
                case 7:
                    //Recurso.consultarRecurso();
                    break;
                case 8:
                    n = 0;
                    break;

            }

        }
    }


    public static void main(String[] args) {
	menuPrincipal();
    }
}
