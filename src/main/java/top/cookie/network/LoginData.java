package top.cookie.network;

import com.nukkitx.protocol.bedrock.BedrockServerSession;
import top.cookie.util.ClientChainData;

public class LoginData {//封装登录信息和玩家客户端,方便传参~
    private ClientChainData clientChainData;
    private BedrockServerSession session;
    public LoginData(ClientChainData clientChainData, BedrockServerSession session){
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
