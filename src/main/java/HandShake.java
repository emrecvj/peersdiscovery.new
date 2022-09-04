import java.net.InetSocketAddress;
import java.util.Arrays;

public class HandShake {
    private String applicationName;
    private int[] applicationVersion;
    private String nodeName;
    private long nodeNonce;

    private InetSocketAddress isa;

    public InetSocketAddress getIsa() {
        return isa;
    }

    public void setIsa(InetSocketAddress isa) {
        this.isa = isa;
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

    @Override
    public String toString() {
        return "HandShake{" +
                "applicationName='" + applicationName + '\'' +
                ", applicationVersion=" + Arrays.toString(applicationVersion) +
                ", nodeName='" + nodeName + '\'' +
                ", nodeNonce=" + nodeNonce +
                ", isa=" + isa +
                '}';
    }
}