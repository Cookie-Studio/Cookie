package top.cookie.network;

import com.nukkitx.protocol.bedrock.BedrockPong;
import com.nukkitx.protocol.bedrock.BedrockServerEventHandler;
import com.nukkitx.protocol.bedrock.BedrockServerSession;
import top.cookie.Server;
import java.net.InetSocketAddress;

public class CookieServerEventHandler implements BedrockServerEventHandler {
    @Override
    public boolean onConnectionRequest(InetSocketAddress inetSocketAddress) {
        Server.getInstance().getLogger().info(inetSocketAddress.getAddress().toString() + " connected");
        return true;
    }

    @Override
    public BedrockPong onQuery(InetSocketAddress inetSocketAddress) {
        return Server.getInstance().getPong();
    }

    @Override
    public void onSessionCreation(BedrockServerSession bedrockServerSession) {
        bedrockServerSession.addDisconnectHandler((reason) -> {
            Server.getInstance().getLogger().info(bedrockServerSession.getAddress() + " disconnect. Reason: " + reason.name());
        });
        bedrockServerSession.setPacketHandler(new LoginPacketHandler(bedrockServerSession));
    }
}