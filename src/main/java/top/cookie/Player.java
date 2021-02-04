package top.cookie;


import top.cookie.network.LoginData;
import top.cookie.network.packethandler.PlayerPacketHandler;

public class Player {
    private LoginData loginData;

    public Player(LoginData loginData){
        this.loginData = loginData;
        loginData.getSession().setPacketHandler(new PlayerPacketHandler(this));
    }
}
