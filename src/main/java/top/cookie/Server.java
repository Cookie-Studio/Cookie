package top.cookie;

import com.nukkitx.protocol.bedrock.BedrockPong;
import com.nukkitx.protocol.bedrock.BedrockServer;
import com.nukkitx.protocol.bedrock.v422.Bedrock_v422;
import top.cookie.network.SimpleBedrockServerEventHandler;
import top.cookie.scheduler.ServerTicker;
import top.cookie.util.yml.Yml;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Cookie服务端类&启动类
 */
public class Server {

    private InetSocketAddress bindAddress = null;
    private Path serverPath = Paths.get(System.getProperty("user.dir"));
    private BedrockServer BedrockServer = null;
    private BedrockPong pong = new BedrockPong();
    private int serverTick = 20;
    private Map<UUID,Player> players = new HashMap<>();
    private Thread tickScheduler;
    private int protocolVersion = Bedrock_v422.V422_CODEC.getProtocolVersion();
    private static Server cookieServer = new Server();
    private Yml serverSets;

    private Server(){
        System.out.println("Server starting...");
        cookieServer.loadServerYml();
        cookieServer.bindAddress = new InetSocketAddress(serverSets.<String>get("ip"), serverSets.<Integer>get("port"));
        cookieServer.BedrockServer = new BedrockServer(cookieServer.bindAddress);
        cookieServer.pong.setMotd(serverSets.get("motd"));
        cookieServer.pong.setMaximumPlayerCount(serverSets.get("maxplayercount"));
        cookieServer.pong.setGameType(serverSets.get("gamemode"));
        cookieServer.pong.setEdition("MCPE");
        cookieServer.pong.setPlayerCount(0);
        cookieServer.pong.setProtocolVersion(Bedrock_v422.V422_CODEC.getProtocolVersion());
        cookieServer.BedrockServer.setHandler(new SimpleBedrockServerEventHandler());
        cookieServer.BedrockServer.bind().join();
        startTickScheduler();
        System.out.println("Server started!");
    }

    public static void main(String[] args){
        cookieServer = new Server();
    }

    public int getServerTick(){
        return this.serverTick;
    }

    public BedrockPong getPong(){
        return this.pong;
    }

    public Map<UUID,Player> getPlayers(){
        return this.players;
    }

    public Path getServerRunningPath(){
        return this.serverPath;
    }

    public int getServerProtocolVersion(){
        return this.protocolVersion;
    }

    public static Server getInstance(){
        return cookieServer;
    }

    private void loadServerYml(){
        System.out.println("Load server.yml...");
        Path ymlPath = Paths.get(cookieServer.serverPath.toString(), "server.yml");
        if (!Files.exists(ymlPath)){
            try {
                Files.copy(Server.class.getClassLoader().getResourceAsStream("server.yml"),ymlPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        serverSets = new Yml(ymlPath);
        System.out.println("server.yml loaded!");
    }

    private void startTickScheduler(){
        System.out.println("Starting TickScheduler...");
        cookieServer.tickScheduler = new Thread(new ServerTicker());
        cookieServer.tickScheduler.start();
        System.out.println("TickScheduler Started!");
    }
}
