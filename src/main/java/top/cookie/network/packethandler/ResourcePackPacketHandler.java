package top.cookie.network.packethandler;

import com.nukkitx.protocol.bedrock.handler.BedrockPacketHandler;
import com.nukkitx.protocol.bedrock.packet.ResourcePackChunkDataPacket;
import com.nukkitx.protocol.bedrock.packet.ResourcePackChunkRequestPacket;
import com.nukkitx.protocol.bedrock.packet.ResourcePackClientResponsePacket;
import com.nukkitx.protocol.bedrock.packet.ResourcePackDataInfoPacket;
import top.cookie.Server;
import top.cookie.network.LoginData;
import top.cookie.pack.Pack;

public class ResourcePackPacketHandler implements BedrockPacketHandler {
    private LoginData loginData;
    public ResourcePackPacketHandler(LoginData loginData){
        this.loginData = loginData;
    }

    public LoginData getLoginData() {
        return loginData;
    }

    @Override
    public boolean handle(ResourcePackClientResponsePacket packet) {

        switch (packet.getStatus()) {
            case REFUSED:
                loginData.getSession().disconnect("disconnectionScreen.noReason");
                return true;
            case SEND_PACKS:
                for (String entry : packet.getPackIds()) {
                    Pack pack = Server.getInstance().getPackManager().getPackByIdVersion(entry);
                    if (pack == null) {
                        loginData.getSession().disconnect("disconnectionScreen.resourcePack");
                        return true;
                    }

                    ResourcePackDataInfoPacket dataInfoPacket = new ResourcePackDataInfoPacket();
                    dataInfoPacket.setPackId(pack.getId());
                    dataInfoPacket.setPackVersion(pack.getVersion().toString());
                    dataInfoPacket.setMaxChunkSize(1048576); //megabyte
                    dataInfoPacket.setChunkCount(pack.getSize() / dataInfoPacket.getMaxChunkSize());
                    dataInfoPacket.setCompressedPackSize(pack.getSize());
                    dataInfoPacket.setHash(pack.getHash());
                    dataInfoPacket.setType(pack.getType());
                    loginData.getSession().sendPacket(dataInfoPacket);
                }
                return true;
            case HAVE_ALL_PACKS:
                loginData.getSession().sendPacket(Server.getInstance().getPackManager().getPackStack());
                return true;
            case COMPLETED:
                return true;
        }
        return true;
    }

    @Override
    public boolean handle(ResourcePackChunkRequestPacket packet) {
        Pack resourcePack = Server.getInstance().getPackManager().getPackByIdVersion(
                packet.getPackId() + "_" + packet.getPackVersion());
        if (resourcePack == null) {
            loginData.getSession().disconnect("disconnectionScreen.resourcePack");
            return true;
        }
        ResourcePackChunkDataPacket dataPacket = new ResourcePackChunkDataPacket();
        dataPacket.setPackId(packet.getPackId());
        dataPacket.setPackVersion(packet.getPackVersion());
        dataPacket.setChunkIndex(packet.getChunkIndex());
        dataPacket.setData(resourcePack.getChunk(1048576 * packet.getChunkIndex(), 1048576));
        dataPacket.setProgress(1048576 * packet.getChunkIndex());
        loginData.getSession().sendPacket(dataPacket);
        return true;
    }
}
