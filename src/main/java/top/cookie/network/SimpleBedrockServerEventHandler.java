package top.cookie.network;

import com.nukkitx.protocol.bedrock.BedrockPong;
import com.nukkitx.protocol.bedrock.BedrockServerEventHandler;
import com.nukkitx.protocol.bedrock.BedrockServerSession;
import top.cookie.Server;

import java.net.InetSocketAddress;

public class SimpleBedrockServerEventHandler implements BedrockServerEventHandler {
    @Override
    public boolean onConnectionRequest(InetSocketAddress inetSocketAddress) {
        System.out.println(inetSocketAddress.getAddress().toString() + " connected");
        return true;
    }

    @Override
    public BedrockPong onQuery(InetSocketAddress inetSocketAddress) {
        return Server.getPong();
    }

    @Override
    public void onSessionCreation(BedrockServerSession bedrockServerSession) {
        bedrockServerSession.addDisconnectHandler((reason) -> {
            System.out.println("IP " + bedrockServerSession.getAddress() + "disconnect. Reason: " + reason.name());
        });
        bedrockServerSession.setPacketHandler(new SimpleBedrockPacketHandler(bedrockServerSession));
    }
}
