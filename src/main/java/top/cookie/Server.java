package top.cookie;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.nukkitx.protocol.bedrock.BedrockPacketCodec;
import com.nukkitx.protocol.bedrock.BedrockPong;
import com.nukkitx.protocol.bedrock.BedrockServer;
import com.nukkitx.protocol.bedrock.BedrockServerSession;
import com.nukkitx.protocol.bedrock.v422.Bedrock_v422;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.cookie.event.listener.ListenerManager;
import top.cookie.network.CookieServerEventHandler;
import top.cookie.pack.PackManager;
import top.cookie.scheduler.Scheduler;
import top.cookie.util.Config;
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

    private static JsonMapper JSON_MAPPER = new JsonMapper();
    private static YAMLMapper YAML_MAPPER = new YAMLMapper();
    private InetSocketAddress bindAddress;
    private Path serverPath = Paths.get(System.getProperty("user.dir"));
    private BedrockServer BedrockServer;
    private BedrockPong pong = new BedrockPong();
    private int serverTick = 20;
    private Map<BedrockServerSession,Player> players = new HashMap<>();
    private ListenerManager listenerManager = new ListenerManager();
    private BedrockPacketCodec serverPacketCodec = Bedrock_v422.V422_CODEC;
    private static Server cookieServer;
    private Config serverSets;
    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    private Scheduler scheduler;
    private PackManager packManager = new PackManager();

    public static void main(String[] args) {
        Server.initServer();
    }

    public static JsonMapper getJsonMapper() {
        return JSON_MAPPER;
    }

    public static YAMLMapper getYamlMapper() {
        return YAML_MAPPER;
    }

    public Path getServerPath() {
        return serverPath;
    }

    public static void initServer(){
        Server.cookieServer = new Server();
    }

    public PackManager getPackManager() {
        return packManager;
    }

    private Server(){
        logger.info("Server starting...");
        Server.cookieServer = this;//avoid null
        this.loadServerYml();
        this.initServerInfo();
        this.setServerEventHandler();
        this.BedrockServer.bind().join();
        this.scheduler = new Scheduler();
        this.scheduler.start();
        this.loadPacks();
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

    public Map<BedrockServerSession,Player> getPlayers(){
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

    public void addPlayer(BedrockServerSession session,Player player){
        this.players.put(session,player);
    }

    public void removePlayer(BedrockServerSession session){
        this.players.remove(session);
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

    private void setServerEventHandler(){
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

    private void loadPacks(){
        Path resourcePath = this.serverPath.resolve("resource_packs");
        if (Files.notExists(resourcePath)) {
            try {
                Files.createDirectory(resourcePath);
            } catch (IOException e) {
                throw new IllegalStateException("Unable to create resource_packs directory");
            }
        }
        this.packManager.loadPacks(resourcePath);
        this.packManager.closeRegistration();
    }
}
