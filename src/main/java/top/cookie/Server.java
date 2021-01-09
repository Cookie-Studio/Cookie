package top.cookie;

import com.nukkitx.protocol.bedrock.BedrockPong;
import com.nukkitx.protocol.bedrock.BedrockServer;
import com.nukkitx.protocol.bedrock.BedrockServerEventHandler;
import com.nukkitx.protocol.bedrock.BedrockServerSession;
import com.nukkitx.protocol.bedrock.v422.Bedrock_v422;
import top.cookie.network.SimpleBedrockPacketHandler;
import top.cookie.util.yml.Yml;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

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

    public static void main(String[] args) throws IOException{
        System.out.println("Server starting...");
        Path ymlPath = Paths.get(serverPath.toString(), "server.yml");
        Yml serverSets = new Yml(ymlPath);
        if (!Files.exists(ymlPath)){
            Files.write(ymlPath,Files.readAllBytes(Paths.get(Server.class.getClassLoader().getResource("server.yml").toString())));
        }
        bindAddress = new InetSocketAddress(serverSets.<String>get("ip"), serverSets.<Integer>get("port"));
        server =  new BedrockServer(bindAddress);
        pong.setEdition("MCPE");
        pong.setMotd(serverSets.get("motd"));
        pong.setPlayerCount(0);
        pong.setMaximumPlayerCount(serverSets.get("maxplayercount"));
        pong.setGameType(serverSets.get("gamemode"));
        pong.setProtocolVersion(Bedrock_v422.V422_CODEC.getProtocolVersion());

        server.setHandler(new BedrockServerEventHandler() {
            @Override
            public boolean onConnectionRequest(InetSocketAddress address) {
                return true;
            }

            @Override
            public BedrockPong onQuery(InetSocketAddress address) {
                return pong;
            }

            @Override
            public void onSessionCreation(BedrockServerSession session) {
                session.addDisconnectHandler((reason) -> System.out.println("Disconnect"));
                session.setPacketHandler(new SimpleBedrockPacketHandler());
            }
        });
        server.bind().join();
        System.out.println("Server start!");
    }

    static int getServerTick(){
        return serverTick;
    }
}
