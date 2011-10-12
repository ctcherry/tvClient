import java.io.*;

public class TvClient {

  public static void main(String[] args) throws IOException {

    if (args.length < 1) {
      System.out.println("Parameter(s): <url>");
      System.exit(0);
    }
    
    VlcClient vlc = new VlcClient("nyx", 4111);
    
    if (args[0] == "stop") {
      vlc.stop();
    } else {
      vlc.play(args[0]);
    }
    
    vlc.close();
    
  }
  
}