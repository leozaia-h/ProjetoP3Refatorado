
public class id {
    private int id = 0;
    private int idSindicato = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSindicato() {
        return idSindicato;
    }
    
    public void setIdSindicato(int idSindicato) {
        this.idSindicato = idSindicato;
    }

    public void incrementId() {
        this.id++;
    }

    public void incrementIdSindicato() {
        this.idSindicato++;
    }
}
