package lexical.analyzer;


public class ArithmaticEx {
private String string;
private String besaran;
private int token;

    public ArithmaticEx(String string, String besaran, int token) {
        this.string = string;
        this.besaran = besaran;
        this.token = token;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getBesaran() {
        return besaran;
    }

    public void setBesaran(String besaran) {
        this.besaran = besaran;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

@Override
    public String toString() {
        return "ArithmaticEx{" + "string=" + string + ", besaran=" + besaran + ", token=" + token + '}';
    }


    
}
