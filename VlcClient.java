import java.net.*;  // for Socket
import java.io.*;   // for IOException and Input/OutputStream

public class VlcClient {

  public String host;
  public int port;
  
  private Socket socket;
  private OutputStream socketOut;
  private boolean connected;

  public VlcClient(String inputHost, int inputPort) {
    host = inputHost;
    port = inputPort;
  }
  
  public void stop() throws IOException {
    send_command("stop");
  }
  
  public void clear() throws IOException {
    send_command("clear");
  }
  
  public void add(String url) throws IOException {
    send_command(String.format("add %s", url));
  }
  
  public void play(String url) throws IOException {
    stop();
    clear();
    add(url);
  }
  
  private void connect() throws IOException {
    socket = new Socket(host, port);
    socketOut = socket.getOutputStream();
    connected = true;
  }
  
  private void send_command(String command) throws IOException {
    if (!connected) {
      connect();
    }
    byte[] byteBuffer = String.format("%s\r\n", command).getBytes();
    socketOut.write(byteBuffer);
  }
  
  public void close() throws IOException {
    socket.close();
  }
  
}