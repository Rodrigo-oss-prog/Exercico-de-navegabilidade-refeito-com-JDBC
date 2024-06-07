import Data.EstadioDAO;
import Data.JogadorDAO;
import Data.PartidaDAO;
import Data.TimeDAO;
import Model.Estadio;
import Model.Jogador;
import Model.Partida;
import Model.Time;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        TimeDAO timeDAO = new TimeDAO();
        Time time1 = new Time(1, "Brasil");
        Time time2 = new Time(2, "Argentina");
        Time time3 = new Time(3, "Uruguai");
        timeDAO.insert(time1);
        timeDAO.insert(time2);
        timeDAO.insert(time3);

        JogadorDAO jogadorDAO = new JogadorDAO();
        Jogador jogador1 = new Jogador(1, "Ronaldo", time1);
        Jogador jogador2 = new Jogador(2, "Messi", time2);
        Jogador jogador3 = new Jogador(3, "Sossa", time3);
        jogadorDAO.insert(jogador1);
        jogadorDAO.insert(jogador2);
        jogadorDAO.insert(jogador3);




        EstadioDAO estadioDAO = new EstadioDAO();
        Estadio estadio1 = new Estadio(1,"Sádio Mané");
        Estadio estadio2 = new Estadio(2,"Serra Dourada" );
        Estadio estadio3 = new Estadio(3,"Maracanã" );
        estadioDAO.insert(estadio1);
        estadioDAO.insert(estadio2);

        PartidaDAO partidaDAO = new PartidaDAO();
        Partida partida1 = new Partida(1, estadio1,time1, time2);
        Partida partida2 = new Partida(2, estadio2,time2, time3);
        Partida partida3 = new Partida(3, estadio3,time3, time1);
        partidaDAO.insert(partida1);
        partidaDAO.insert(partida2);
        partidaDAO.insert(partida3);



        List<Time> times = timeDAO.findAll();
        for (Time time : times) {
            System.out.println(time);
        }

        List<Jogador> jogadores = jogadorDAO.findAll();
        for (Jogador jogador : jogadores) {
            System.out.println(jogador);
        }

        List<Estadio> estadios = estadioDAO.findAll();
        for (Estadio estadio : estadios) {
            System.out.println(estadio);
        }
    }
}