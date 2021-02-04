package top.cookie.network.packethandler;

import com.nukkitx.protocol.bedrock.BedrockPacketCodec;
import com.nukkitx.protocol.bedrock.BedrockServerSession;
import com.nukkitx.protocol.bedrock.handler.BedrockPacketHandler;
import com.nukkitx.protocol.bedrock.packet.LoginPacket;
import com.nukkitx.protocol.bedrock.packet.PlayStatusPacket;
import top.cookie.Player;
import top.cookie.Server;
import top.cookie.network.LoginData;
import top.cookie.util.ClientChainData;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginPacketHandler implements BedrockPacketHandler {

    private static final Pattern NAME_PATTERN = Pattern.compile("^[aA-zZ\\s\\d_]{3,16}+$");
    private BedrockServerSession session;

    public LoginPacketHandler(BedrockServerSession session){
        this.session = session;
    }

    @Override
    public boolean handle(LoginPacket packet) {
        BedrockPacketCodec packetCodec = Server.getInstance().getServerPacketCodec();
        int protocolVersion = packet.getProtocolVersion();

        if (packetCodec.getProtocolVersion() != protocolVersion){
            PlayStatusPacket playStatusPacket = new PlayStatusPacket();
            if (packetCodec.getProtocolVersion() > protocolVersion){
                playStatusPacket.setStatus(PlayStatusPacket.Status.LOGIN_FAILED_CLIENT_OLD);
            }else{
                playStatusPacket.setStatus(PlayStatusPacket.Status.LOGIN_FAILED_SERVER_OLD);
            }
            this.session.sendPacketImmediately(playStatusPacket);
            return true;
        }

        session.setPacketCodec(packetCodec);

        ClientChainData clientChainData = ClientChainData.read(packet);

        if (!clientChainData.isXboxAuthed() && (boolean)Server.getInstance().getServerSets().get("xbox-auth")){
            session.disconnect("disconnectionScreen.notAuthenticated");
            return true;
        }//check xbox

        String username = clientChainData.getUsername();
        Matcher matcher = NAME_PATTERN.matcher(username);

        if (!matcher.matches() || username.equalsIgnoreCase("rcon") || username.equalsIgnoreCase("console")) {
            session.disconnect("disconnectionScreen.invalidName");
            return true;
        }//check name

        if (!clientChainData.getSkin().isValid()) {
            session.disconnect("disconnectionScreen.invalidSkin");
            return true;
        }//check skin

        PlayStatusPacket statusPacket = new PlayStatusPacket();
        statusPacket.setStatus(PlayStatusPacket.Status.LOGIN_SUCCESS);
        session.sendPacket(statusPacket);//successed login

        LoginData loginData = new LoginData(clientChainData,session);
        Server.getInstance().addPlayer(session,new Player(loginData));

        session.setPacketHandler(new ResourcePackPacketHandler(loginData));

        session.sendPacket(Server.getInstance().getPackManager().getPacksInfos());
        return true;
    }
}
