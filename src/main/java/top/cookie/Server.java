package top.cookie;

import com.nukkitx.protocol.bedrock.BedrockPacketCodec;
import com.nukkitx.protocol.bedrock.BedrockPong;
import com.nukkitx.protocol.bedrock.BedrockServer;
import com.nukkitx.protocol.bedrock.v422.Bedrock_v422;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.cookie.event.listener.ListenerManager;
import top.cookie.network.CookieServerEventHandler;
import top.cookie.scheduler.Scheduler;
import top.cookie.scheduler.tasks.PeriodTask;
import top.cookie.scheduler.tasks.ServerTask;
import top.cookie.scheduler.timer.Timer;
import top.cookie.util.Config;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Cookie服务端类&启动类
 */
public class Server {

    private InetSocketAddress bindAddress;
    private Path serverPath = Paths.get(System.getProperty("user.dir"));
    private BedrockServer BedrockServer;
    private BedrockPong pong = new BedrockPong();
    private int serverTick = 20;
    private Map<UUID,Player> players = new HashMap<>();
    private ListenerManager listenerManager = new ListenerManager();
    private BedrockPacketCodec serverPacketCodec = Bedrock_v422.V422_CODEC;
    private static Server cookieServer;
    private Config serverSets;
    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    private Scheduler scheduler;

    public static void main(String[] args) {
        Server.initServer();
    }

    public Path getServerPath() {
        return serverPath;
    }

    public static void initServer(){
        Server.cookieServer = new Server();
    }

    private Server(){
        logger.info("Server starting...");
        Server.cookieServer = this;//avoid null
        this.loadServerYml();
        this.initServerInfo();
        this.setHandlers();
        this.BedrockServer.bind().join();
        this.scheduler = new Scheduler();
        this.scheduler.start();
        logger.info("Server started!");
    }

    public static Server getInstance(){
        return cookieServer;
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

    public BedrockPacketCodec getServerPacketCodec(){
        return this.serverPacketCodec;
    }

    public Config getServerSets() {
        return serverSets;
    }

    public ListenerManager getListenerManager(){
        return this.listenerManager;
    }

    public Logger getLogger(){
        return logger;
    }

    public Scheduler getScheduler() {
        return scheduler;
    }

    public void stop(int status){
        if (status == 0){
            logger.info("Server is closed");
            System.exit(0);
        }else{
            logger.fatal("Server is crashed");
            System.exit(1);
        }
    }

    private void loadServerYml(){
        Path ymlPath = Paths.get(this.serverPath.toString(), "server.yml");
        if (!Files.exists(ymlPath)){
            logger.error("Can't find server.yml,creating new file....");
            try {
                Files.copy(Server.class.getClassLoader().getResourceAsStream("server.yml"),ymlPath);
            } catch (IOException e) {
                e.printStackTrace();
                logger.fatal("Can't create file,server will crash...");
                this.stop(1);
            }
        }
        serverSets = new Config(ymlPath);
    }

    private void setHandlers(){
        this.BedrockServer.setHandler(new CookieServerEventHandler());
    }

    private void initServerInfo(){
        this.bindAddress = new InetSocketAddress((String)serverSets.<String>get("ip"), (int)serverSets.<Integer>get("port"));
        this.BedrockServer = new BedrockServer(this.bindAddress);
        this.pong.setMotd((String)serverSets.get("motd"));
        this.pong.setMaximumPlayerCount((int)serverSets.get("maxplayercount"));
        this.pong.setGameType((String)serverSets.get("gamemode"));
        this.pong.setEdition("MCPE");
        this.pong.setPlayerCount(0);
        this.pong.setProtocolVersion(Bedrock_v422.V422_CODEC.getProtocolVersion());
        this.serverTick = (int)serverSets.get("servertick");
    }
}
