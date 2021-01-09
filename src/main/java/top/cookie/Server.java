package top.cookie;

import com.nukkitx.protocol.bedrock.BedrockPong;
import com.nukkitx.protocol.bedrock.BedrockServer;
import com.nukkitx.protocol.bedrock.v422.Bedrock_v422;
import top.cookie.network.SimpleBedrockServerEventHandler;
import top.cookie.scheduler.ServerTicker;
import top.cookie.util.yml.Yml;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Cookie服务端类&启动类
 */
public class Server {

    private static InetSocketAddress bindAddress = null;
    private static Path serverPath = Paths.get(System.getProperty("user.dir"));
    private static BedrockServer server = null;
    private static BedrockPong pong = new BedrockPong();
    private static int serverTick = 20;
    private static ArrayList<Player> players = new ArrayList<>();
    private static Thread ticker;

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println("Server starting...");
        System.out.println("Load server.yml...");
        Path ymlPath = Paths.get(serverPath.toString(), "server.yml");
        if (!Files.exists(ymlPath)){
            Files.copy(Server.class.getClassLoader().getResourceAsStream("server.yml"),ymlPath);
        }
        Yml serverSets = new Yml(ymlPath);
        System.out.println("server.yml loaded!");
        bindAddress = new InetSocketAddress(serverSets.<String>get("ip"), serverSets.<Integer>get("port"));
        server =  new BedrockServer(bindAddress);
        pong.setEdition("MCPE");
        pong.setMotd(serverSets.get("motd"));
        pong.setPlayerCount(0);
        pong.setMaximumPlayerCount(serverSets.get("maxplayercount"));
        pong.setGameType(serverSets.get("gamemode"));
        pong.setProtocolVersion(Bedrock_v422.V422_CODEC.getProtocolVersion());
        server.setHandler(new SimpleBedrockServerEventHandler());
        server.bind().join();
        System.out.println("Starting TickScheduler...");
        ticker = new Thread(new ServerTicker());
        System.out.println("TickScheduler Started!");
        System.out.println("Server started!");
    }

    public static int getServerTick(){
        return serverTick;
    }

    public static BedrockPong getPong(){
        return pong;
    }

    public static List<Player> getPlayers(){
        return players;
    }

    public static Path getServerRunningPath(){
        return serverPath;
    }
}
