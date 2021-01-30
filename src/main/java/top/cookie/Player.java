package top.cookie;

import com.nukkitx.protocol.bedrock.BedrockServerSession;
import com.nukkitx.protocol.bedrock.data.skin.SerializedSkin;
import top.cookie.network.CookiePacketHandler;

import java.net.InetSocketAddress;
import java.util.UUID;

public class Player {
    private InetSocketAddress address;
    private String playerName;
    private UUID uuid;
    private SerializedSkin skinData;

    public Player(BedrockServerSession session){
        this.address = session.getAddress();
        session.setPacketHandler(new CookiePacketHandler(session));
    }

    public InetSocketAddress getAddress(){
        return this.address;
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public UUID getUuid() {
        return uuid;
    }
}
