package top.cookie.event.player;

import com.nukkitx.protocol.bedrock.BedrockServerSession;
import top.cookie.event.Cancellable;
import top.cookie.util.ClientChainData;

public class PlayerPreLoginEvent extends PlayerEvent implements Cancellable {

    private ClientChainData clientChainData;
    private BedrockServerSession session;

    public PlayerPreLoginEvent(ClientChainData clientChainData, BedrockServerSession session){
        this.clientChainData = clientChainData;
        this.session = session;
    }

    public ClientChainData getClientChainData() {
        return clientChainData;
    }

    public BedrockServerSession getSession() {
        return session;
    }

}
