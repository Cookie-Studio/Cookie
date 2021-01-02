package top.cookie;

import com.nukkitx.protocol.bedrock.BedrockPong;
import com.nukkitx.protocol.bedrock.BedrockServer;
import com.nukkitx.protocol.bedrock.BedrockServerEventHandler;
import com.nukkitx.protocol.bedrock.BedrockServerSession;
import com.nukkitx.protocol.bedrock.v422.Bedrock_v422;
import top.cookie.network.SimpleBedrockPacketHandler;

import java.net.InetSocketAddress;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Cookie服务端类&启动类
 */
public class Server {

    private static InetSocketAddress bindAddress = null;
    private static Path serverPath = Paths.get(System.getProperty("user.dir"));
    private static BedrockServer server = null;
    private static BedrockPong pong = new BedrockPong();
    private static int serverTick = 20;

    public static void main(String[] args){
        System.out.println("Server starting...");
        bindAddress = new InetSocketAddress("127.0.0.1", 19132);
        server =  new BedrockServer(bindAddress);
        pong.setEdition("MCPE");
        pong.setMotd("My Server");
        pong.setPlayerCount(0);
        pong.setMaximumPlayerCount(20);
        pong.setGameType("Survival");
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
                session.addDisconnectHandler((reason) -> System.out.println("Disconnected"));
                session.setPacketHandler(new SimpleBedrockPacketHandler());
            }
        });

        System.out.println("Server start!");
        server.bind().join();
    }

    synchronized static int getServerTick(){
        return serverTick;
    }
}
