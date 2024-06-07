package Model;

public class Partida {
    private int idPartida;


    private Estadio estadio;
    private Time time1;
    private Time time2;

    public Partida(int idPartida, Estadio estadio, Time time1, Time time2) {
        this.idPartida = idPartida;
        this.estadio = estadio;
        this.time1 = time1;
        this.time2 = time2;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public Time getTime1() {
        return time1;
    }

    public void setTime1(Time time1) {
        this.time1 = time1;
    }

    public Time getTime2() {
        return time2;
    }

    public void setTime2(Time time2) {
        this.time2 = time2;
    }
    @Override
    public String toString() {
        return "Partida{" +
                "idPartida=" + idPartida +
                ", estadio=" + estadio +
                ", time1=" + time1 +
                ", time2=" + time2 +
                '}';
    }
}
