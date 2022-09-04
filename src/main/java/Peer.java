import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class Peer {

    private SocketAddress remoteAddress;
    private InetSocketAddress declaredAddress;
    private String applicationName;
    private int [] applicationVersion;
    private String nodeName;
    private long nodeNonce;


    public SocketAddress getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(SocketAddress remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public InetSocketAddress getDeclaredAddress() {
        return declaredAddress;
    }

    public void setDeclaredAddress(InetSocketAddress declaredAddress) {
        this.declaredAddress = declaredAddress;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public int[] getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(int[] applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public long getNodeNonce() {
        return nodeNonce;
    }

    public void setNodeNonce(long nodeNonce) {
        this.nodeNonce = nodeNonce;
    }
}
