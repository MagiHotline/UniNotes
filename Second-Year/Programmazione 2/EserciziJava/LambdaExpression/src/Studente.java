public class Studente {
    private String nome;
    private double voto;

    public Studente(String nome, double voto) {
        this.nome = nome;
        this.voto = voto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getVoto() {
        return voto;
    }

    public void setVoto(double voto) {
        this.voto = voto;
    }

    public String toString() {
        return "Nome: " + nome + "\nVoto: " + voto;
    }
}
