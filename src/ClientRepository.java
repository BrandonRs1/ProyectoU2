import java.util.ArrayList;

public class ClientRepository {
    private ArrayList<Client> clients = new ArrayList<>();


    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(Client clients) {
        this.clients.add(clients);
    }
}
