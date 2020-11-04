package entidades;

public class Trabajador extends Persona {
    public Trabajador(){
    }

    private int pin;
    private String areaT;
    private String nameUser;
    private String password;

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getAreaT() {
        return areaT;
    }

    public void setAreaT(String areaT) {
        this.areaT = areaT;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
