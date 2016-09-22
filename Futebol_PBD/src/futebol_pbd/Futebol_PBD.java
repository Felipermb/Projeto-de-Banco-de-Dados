package futebol_pbd;

import Modelo.*;
import DAO.*;
import java.io.IOException;
import java.util.Scanner;

public class Futebol_PBD {

    Scanner ler = new Scanner(System.in);

    // Instancias Modelo
    Estadio estadio = new Estadio();
    Jogador jogador = new Jogador();
    Jogo jogo = new Jogo();
    Pais pais = new Pais();
    Tecnico tecnico = new Tecnico();
    Time time = new Time();

    // Instancias Hibernate (DAO)
    Estadio_DAO estadio_DAO = new Estadio_DAO();
    Jogador_DAO jogador_DAO = new Jogador_DAO();
    Jogo_DAO jogo_DAO = new Jogo_DAO();
    Pais_DAO pais_DAO = new Pais_DAO();
    Tecnico_DAO tecnico_DAO = new Tecnico_DAO();
    Time_DAO time_DAO = new Time_DAO();

    public static void main(String[] args) throws IOException {
        Scanner ler = new Scanner(System.in);
        Futebol_PBD f = new Futebol_PBD();
        int x = 1;
        while (x != 0) {
            System.out.println("Menu:\n\n1- Inserir\n2- Exluir\n3- Atualizar\n4- Sair");
            System.out.println("Escolha:");
            x = ler.nextInt();
            switch (x) {
                case 1:
                    f.inserir();
                    break;
                case 2:
                    f.excluir();
                    break;
                case 3:
                    f.atualizar();
                    break;
                case 4:
                    x = 0;
                    break;
                default:
                    break;
            }
        }

    }

    public void inserir() throws IOException {
        try {
            int i = 1;
            System.out.println(" Menu Inserir: \n\n1- Pais\n2- Estadio\n3- Jogo\n4- Time\n5- Jogador\n6- Tecnico\n7- Sair");
            while (i != 0) {
                System.out.println("Escolha: ");
                i = ler.nextInt();
                switch (i) {
                    case 1:
                        System.out.println("Insira o nome: ");
                        pais.setNome(ler.next());
                        System.out.println("Insira a sigla: ");
                        pais.setSigla(ler.next());
                        pais = pais_DAO.salvar(pais);
                        break;
                    case 2:
                        System.out.println("Insira o nome: ");
                        estadio.setNome(ler.next());
                        System.out.println("Insira o publico: ");
                        estadio.setPublico(Double.parseDouble(ler.next()));
                        estadio_DAO.salvar(estadio);
                        break;
                    case 3:
                        break;
                    case 4:
                        System.out.println("Insira o nome: ");
                        time.setNome(ler.next());
                        System.out.println("Insira a sigla: ");
                        time.setSigla(ler.next());
                        time.setIdPais(pais_DAO.consultarPorId(1));
                        System.out.println("Insira o id do estadio");
                        time.setIdEstadio(estadio_DAO.consultarPorId(Integer.parseInt(ler.next())));

                        time_DAO.salvar(time);
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        i = 0;
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void excluir() {
        try {
            int i = 1;
            System.out.println(" Menu Excluir: \n\n1- Pais\n2- Estadio\n3- Jogo\n4- Time\n5- Jogador\n6- Tecnico\n7- Sair");
            while (i != 0) {
                System.out.println("Escolha: ");
                i = ler.nextInt();
                switch (i) {
                    case 1:
                        System.out.println("Insira o ID: ");
                        pais_DAO.excluir(ler.nextInt());
                        break;
                    case 2:

                        break;
                    case 3:
                        break;
                    case 4:

                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        i = 0;
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void atualizar() {
        try {
            int i = 1;
            System.out.println(" Menu Atualizar: \n\n1- Pais\n2- Estadio\n3- Jogo\n4- Time\n5- Jogador\n6- Tecnico\n7- Sair");
            while (i != 0) {
                System.out.println("Escolha: ");
                i = ler.nextInt();
                switch (i) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:
                        break;
                    case 4:

                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        i = 0;
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
