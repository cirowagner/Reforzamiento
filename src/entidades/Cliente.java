package entidades;

public class Cliente extends Persona {
    public Cliente (){
    }

    private int codC;
    private String tipoC;

    public int getInt() {
        return codC;
    }

    public void setCodC(int codC) {
        this.codC = codC;
    }

    public String getTipoC() {
        return tipoC;
    }

    public void setTipoC(String tipoC) {
        this.tipoC = tipoC;
    }
}
