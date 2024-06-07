package Model;

public class Jogador {
    private int id;
    private String nome;
   private Time id_time;


    public Jogador(int id, String nome, Time id_time) {
        this.id = id;
        this.nome = nome;
        this.id_time = id_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Time getId_time() {
        return id_time;
    }

    public void setId_time(Time id_time) {
        this.id_time = id_time;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", id_time=" + id_time +
                '}';
    }


}
