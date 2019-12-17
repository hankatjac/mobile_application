package ca.hank.finalexam;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataCollection implements Serializable {

    protected List<Client> clientArray = new ArrayList<>();

    public List<Client> getClientArray() {
        return clientArray;
    }
}