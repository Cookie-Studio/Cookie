package top.cookie.network.packethandler;

import com.nukkitx.protocol.bedrock.handler.BedrockPacketHandler;
import top.cookie.Player;

public class PlayerPacketHandler implements BedrockPacketHandler {
    private Player player;
    public PlayerPacketHandler(Player player){
        this.player = player;
    }


}
