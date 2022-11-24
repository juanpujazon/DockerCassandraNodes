package cassandra.java.client;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class CassandraConnector {

    private Cluster cluster;
    private Session session;

    public void connect(String node, Integer port) {
        Cluster.Builder b = Cluster.builder().addContactPoint(node);
        if (port != null) {
            b.withPort(port);
        }
        cluster = b.build();
        session = cluster.connect();
    }

    public void connectNodes(String[] nodes, Integer port) {
        StringBuilder sb = new StringBuilder("");
        for (String node : nodes) {
            sb.append("\""+node+"\";");
        }
        sb.deleteCharAt(sb.length() - 1);
        String allNodes = sb.toString();
        System.out.println(allNodes);
        Cluster.Builder b = Cluster.builder().addContactPoint(allNodes);
        if (port != null) {
            b.withPort(port);
        }
        cluster = b.build();
        session = cluster.connect();
    }

    public Session getSession() {
        return this.session;
    }

    public void close() {
        session.close();
        cluster.close();
    }
}
