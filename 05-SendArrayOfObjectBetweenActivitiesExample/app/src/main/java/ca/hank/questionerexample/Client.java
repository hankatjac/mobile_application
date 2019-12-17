package ca.hank.questionerexample;

import java.io.Serializable;

public class Client implements Serializable {
    private int clientNumber;
    private String email;
    private String movieType;

    public Client() {
    }

    public Client(int clientNumber, String email, String movieType) {
        this.clientNumber = clientNumber;
        this.email = email;
        this.movieType = movieType;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    @Override
    public String toString() {
        return
                "clientNumber=" + clientNumber + "\n" +
                "email='" + email + "\n" +
                "movieType='" + movieType + "\n";
    }
}
