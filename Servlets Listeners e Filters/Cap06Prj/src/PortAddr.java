public class PortAddr {
    String hostname;
    int portnum;
    public PortAddr(String s, int i) {
        hostname = new String(s);
        portnum = i;
    }
    public String getHostName() {
        return hostname;
    }
    public int getPort() {
        return portnum;
    }
}

