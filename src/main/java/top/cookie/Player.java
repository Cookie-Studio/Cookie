package top.cookie;

import com.nukkitx.protocol.bedrock.BedrockServerSession;
import com.nukkitx.protocol.bedrock.packet.AddPlayerPacket;
import java.net.InetSocketAddress;
import java.util.UUID;

public class Player {
    private InetSocketAddress address;
    private String playerName;
    private UUID uuid;

    public Player(AddPlayerPacket packet, BedrockServerSession session){
        this.playerName = packet.getUsername();
        this.address = session.getAddress();
        this.uuid = packet.getUuid();
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
