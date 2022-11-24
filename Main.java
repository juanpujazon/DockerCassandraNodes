
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;



public class Main {
    public static void main(String args[]) throws IOException, InvalidFormatException{ 

    CassandraConnector connector = new CassandraConnector();
    String[] nodes = new String[]{"127.0.0.1","172.30.0.2","172.30.0.3","172.30.0.4","172.30.0.5","172.30.0.6"};
    connector.connectNodes(nodes, 9043); //This gives errors and does not connect
    //connector.connect("192.168.3.19", 9042); //this makes CRUD possible although with network errors
    }
}
