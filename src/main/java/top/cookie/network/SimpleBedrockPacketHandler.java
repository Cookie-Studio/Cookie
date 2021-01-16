package top.cookie.network;

import com.nukkitx.network.util.DisconnectReason;
import com.nukkitx.protocol.bedrock.BedrockServerSession;
import com.nukkitx.protocol.bedrock.handler.BedrockPacketHandler;
import com.nukkitx.protocol.bedrock.packet.*;
import top.cookie.Player;
import top.cookie.Server;

public class SimpleBedrockPacketHandler implements BedrockPacketHandler {
    private BedrockServerSession session;
    private Player player;
    public SimpleBedrockPacketHandler(BedrockServerSession session){
        this.session = session;
    }
    @Override
    public boolean handle(AdventureSettingsPacket packet) {
        return true;
    }

    @Override
    public boolean handle(AnimatePacket packet) {
        return true;
    }

    @Override
    public boolean handle(AnvilDamagePacket packet) {
        return true;
    }

    @Override
    public boolean handle(AvailableEntityIdentifiersPacket packet) {
        return true;
    }

    @Override
    public boolean handle(BlockEntityDataPacket packet) {
        return true;
    }

    @Override
    public boolean handle(BlockPickRequestPacket packet) {
        return true;
    }

    @Override
    public boolean handle(BookEditPacket packet) {
        return true;
    }

    @Override
    public boolean handle(ClientCacheBlobStatusPacket packet) {
        return true;
    }

    @Override
    public boolean handle(ClientCacheMissResponsePacket packet) {
        return true;
    }

    @Override
    public boolean handle(ClientCacheStatusPacket packet) {
        return true;
    }

    @Override
    public boolean handle(ClientToServerHandshakePacket packet) {
        return true;
    }

    @Override
    public boolean handle(CommandBlockUpdatePacket packet) {
        return true;
    }

    @Override
    public boolean handle(CommandRequestPacket packet) {
        return true;
    }

    @Override
    public boolean handle(CompletedUsingItemPacket packet) {
        return true;
    }

    @Override
    public boolean handle(ContainerClosePacket packet) {
        return true;
    }

    @Override
    public boolean handle(CraftingEventPacket packet) {
        return true;
    }

    @Override
    public boolean handle(EducationSettingsPacket packet) {
        return true;
    }

    @Override
    public boolean handle(EmotePacket packet) {
        return true;
    }

    @Override
    public boolean handle(EntityEventPacket packet) {
        return true;
    }

    @Override
    public boolean handle(EntityFallPacket packet) {
        return true;
    }

    @Override
    public boolean handle(EntityPickRequestPacket packet) {
        return true;
    }

    @Override
    public boolean handle(EventPacket packet) {
        return true;
    }

    @Override
    public boolean handle(FilterTextPacket packet) {
        return true;
    }

    @Override
    public boolean handle(InteractPacket packet) {
        return true;
    }

    @Override
    public boolean handle(InventoryContentPacket packet) {
        return true;
    }

    @Override
    public boolean handle(InventorySlotPacket packet) {
        return true;
    }

    @Override
    public boolean handle(InventoryTransactionPacket packet) {
        return true;
    }

    @Override
    public boolean handle(ItemFrameDropItemPacket packet) {
        return true;
    }

    @Override
    public boolean handle(LabTablePacket packet) {
        return true;
    }

    @Override
    public boolean handle(LecternUpdatePacket packet) {
        return true;
    }

    @Override
    public boolean handle(LevelEventGenericPacket packet) {
        return true;
    }

    @Override
    public boolean handle(LevelSoundEvent1Packet packet) {
        return true;
    }

    @Override
    public boolean handle(LevelSoundEventPacket packet) {
        return true;
    }

    @Override
    public boolean handle(LoginPacket packet) {
        if (packet.getProtocolVersion() != Server.getServerProtocolVersion()){
            this.session.disconnect(DisconnectReason.INCOMPATIBLE_PROTOCOL_VERSION.name());
        }
        System.out.println(this.session.getAddress() + " logined");
        return true;
    }

    @Override
    public boolean handle(MapInfoRequestPacket packet) {
        return true;
    }

    @Override
    public boolean handle(MobArmorEquipmentPacket packet) {
        return true;
    }

    @Override
    public boolean handle(MobEquipmentPacket packet) {
        return true;
    }

    @Override
    public boolean handle(ModalFormResponsePacket packet) {
        return true;
    }

    @Override
    public boolean handle(MoveEntityAbsolutePacket packet) {
        return true;
    }

    @Override
    public boolean handle(MovePlayerPacket packet) {
        return true;
    }

    @Override
    public boolean handle(MultiplayerSettingsPacket packet) {
        return true;
    }

    @Override
    public boolean handle(NetworkStackLatencyPacket packet) {
        return true;
    }

    @Override
    public boolean handle(PhotoTransferPacket packet) {
        return true;
    }

    @Override
    public boolean handle(PlayerActionPacket packet) {
        return true;
    }

    @Override
    public boolean handle(PlayerAuthInputPacket packet) {
        return true;
    }

    @Override
    public boolean handle(PlayerHotbarPacket packet) {
        return true;
    }

    @Override
    public boolean handle(PlayerInputPacket packet) {
        return true;
    }

    @Override
    public boolean handle(PlayerSkinPacket packet) {
        return true;
    }

    @Override
    public boolean handle(PurchaseReceiptPacket packet) {
        return true;
    }

    @Override
    public boolean handle(RequestChunkRadiusPacket packet) {
        return true;
    }

    @Override
    public boolean handle(ResourcePackChunkRequestPacket packet) {
        return true;
    }

    @Override
    public boolean handle(ResourcePackClientResponsePacket packet) {
        return true;
    }

    @Override
    public boolean handle(RiderJumpPacket packet) {
        return true;
    }

    @Override
    public boolean handle(ServerSettingsRequestPacket packet) {
        return true;
    }

    @Override
    public boolean handle(SetDefaultGameTypePacket packet) {
        return true;
    }

    @Override
    public boolean handle(SetLocalPlayerAsInitializedPacket packet) {
        return true;
    }

    @Override
    public boolean handle(SetPlayerGameTypePacket packet) {
        return true;
    }

    @Override
    public boolean handle(SubClientLoginPacket packet) {
        return true;
    }

    @Override
    public boolean handle(AddBehaviorTreePacket packet) {
        return true;
    }

    @Override
    public boolean handle(AddEntityPacket packet) {
        return true;
    }

    @Override
    public boolean handle(AddHangingEntityPacket packet) {
        return true;
    }

    @Override
    public boolean handle(AddItemEntityPacket packet) {
        return true;
    }

    @Override
    public boolean handle(AddPaintingPacket packet) {
        return true;
    }

    @Override
    public boolean handle(AddPlayerPacket packet) {
        Player player = new Player(packet,this.session);
        this.player = player;
        Server.getPlayers().put(packet.getUuid(),player);
        System.out.println(this.player.getPlayerName() + " joined");
        return true;
    }

    @Override
    public boolean handle(AvailableCommandsPacket packet) {
        return true;
    }

    @Override
    public boolean handle(BlockEventPacket packet) {
        return true;
    }

    @Override
    public boolean handle(BossEventPacket packet) {
        return true;
    }

    @Override
    public boolean handle(CameraPacket packet) {
        return true;
    }

    @Override
    public boolean handle(ChangeDimensionPacket packet) {
        return true;
    }

    @Override
    public boolean handle(ChunkRadiusUpdatedPacket packet) {
        return true;
    }

    @Override
    public boolean handle(ClientboundMapItemDataPacket packet) {
        return true;
    }

    @Override
    public boolean handle(CommandOutputPacket packet) {
        return true;
    }

    @Override
    public boolean handle(ContainerOpenPacket packet) {
        return true;
    }

    @Override
    public boolean handle(ContainerSetDataPacket packet) {
        return true;
    }

    @Override
    public boolean handle(CraftingDataPacket packet) {
        return true;
    }

    @Override
    public boolean handle(DisconnectPacket packet) {
        Server.getPlayers().remove(this.player.getUuid());
        System.out.println(this.player.getPlayerName() + "disconnected");
        return true;
    }

    @Override
    public boolean handle(ExplodePacket packet) {
        return true;
    }

    @Override
    public boolean handle(LevelChunkPacket packet) {
        return true;
    }

    @Override
    public boolean handle(GameRulesChangedPacket packet) {
        return true;
    }

    @Override
    public boolean handle(GuiDataPickItemPacket packet) {
        return true;
    }

    @Override
    public boolean handle(HurtArmorPacket packet) {
        return true;
    }

    @Override
    public boolean handle(AutomationClientConnectPacket packet) {
        return true;
    }

    @Override
    public boolean handle(LevelEventPacket packet) {
        return true;
    }

    @Override
    public boolean handle(MapCreateLockedCopyPacket packet) {
        return true;
    }

    @Override
    public boolean handle(MobEffectPacket packet) {
        return true;
    }

    @Override
    public boolean handle(ModalFormRequestPacket packet) {
        return true;
    }

    @Override
    public boolean handle(MoveEntityDeltaPacket packet) {
        return true;
    }

    @Override
    public boolean handle(NetworkSettingsPacket packet) {
        return true;
    }

    @Override
    public boolean handle(NpcRequestPacket packet) {
        return true;
    }

    @Override
    public boolean handle(OnScreenTextureAnimationPacket packet) {
        return true;
    }

    @Override
    public boolean handle(PlayerListPacket packet) {
        return true;
    }

    @Override
    public boolean handle(PlaySoundPacket packet) {
        return true;
    }

    @Override
    public boolean handle(PlayStatusPacket packet) {
        return true;
    }

    @Override
    public boolean handle(RemoveEntityPacket packet) {
        return true;
    }

    @Override
    public boolean handle(RemoveObjectivePacket packet) {
        return true;
    }

    @Override
    public boolean handle(ResourcePackChunkDataPacket packet) {
        return true;
    }

    @Override
    public boolean handle(ResourcePackDataInfoPacket packet) {
        return true;
    }

    @Override
    public boolean handle(ResourcePacksInfoPacket packet) {
        return true;
    }

    @Override
    public boolean handle(ResourcePackStackPacket packet) {
        return true;
    }

    @Override
    public boolean handle(RespawnPacket packet) {
        return true;
    }

    @Override
    public boolean handle(ScriptCustomEventPacket packet) {
        return true;
    }

    @Override
    public boolean handle(ServerSettingsResponsePacket packet) {
        return true;
    }

    @Override
    public boolean handle(ServerToClientHandshakePacket packet) {
        return true;
    }

    @Override
    public boolean handle(SetCommandsEnabledPacket packet) {
        return true;
    }

    @Override
    public boolean handle(SetDifficultyPacket packet) {
        return true;
    }

    @Override
    public boolean handle(SetDisplayObjectivePacket packet) {
        return true;
    }

    @Override
    public boolean handle(SetEntityDataPacket packet) {
        return true;
    }

    @Override
    public boolean handle(SetEntityLinkPacket packet) {
        return true;
    }

    @Override
    public boolean handle(SetEntityMotionPacket packet) {
        return true;
    }

    @Override
    public boolean handle(SetHealthPacket packet) {
        return true;
    }

    @Override
    public boolean handle(SetLastHurtByPacket packet) {
        return true;
    }

    @Override
    public boolean handle(SetScoreboardIdentityPacket packet) {
        return true;
    }

    @Override
    public boolean handle(SetScorePacket packet) {
        return true;
    }

    @Override
    public boolean handle(SetSpawnPositionPacket packet) {
        return true;
    }

    @Override
    public boolean handle(SetTimePacket packet) {
        return true;
    }

    @Override
    public boolean handle(SettingsCommandPacket packet) {
        return true;
    }

    @Override
    public boolean handle(SetTitlePacket packet) {
        return true;
    }

    @Override
    public boolean handle(ShowCreditsPacket packet) {
        return true;
    }

    @Override
    public boolean handle(ShowProfilePacket packet) {
        return true;
    }

    @Override
    public boolean handle(ShowStoreOfferPacket packet) {
        return true;
    }

    @Override
    public boolean handle(SimpleEventPacket packet) {
        return true;
    }

    @Override
    public boolean handle(SpawnExperienceOrbPacket packet) {
        return true;
    }

    @Override
    public boolean handle(SpawnParticleEffectPacket packet) {
        return true;
    }

    @Override
    public boolean handle(StartGamePacket packet) {
        return true;
    }

    @Override
    public boolean handle(StopSoundPacket packet) {
        return true;
    }

    @Override
    public boolean handle(StructureBlockUpdatePacket packet) {
        return true;
    }

    @Override
    public boolean handle(StructureTemplateDataRequestPacket packet) {
        return true;
    }

    @Override
    public boolean handle(StructureTemplateDataResponsePacket packet) {
        return true;
    }

    @Override
    public boolean handle(TakeItemEntityPacket packet) {
        return true;
    }

    @Override
    public boolean handle(TextPacket packet) {
        return true;
    }

    @Override
    public boolean handle(TickSyncPacket packet) {
        return true;
    }

    @Override
    public boolean handle(TransferPacket packet) {
        return true;
    }

    @Override
    public boolean handle(UpdateAttributesPacket packet) {
        return true;
    }

    @Override
    public boolean handle(UpdateBlockPacket packet) {
        return true;
    }

    @Override
    public boolean handle(UpdateBlockPropertiesPacket packet) {
        return true;
    }

    @Override
    public boolean handle(UpdateBlockSyncedPacket packet) {
        return true;
    }

    @Override
    public boolean handle(UpdateEquipPacket packet) {
        return true;
    }

    @Override
    public boolean handle(UpdateSoftEnumPacket packet) {
        return true;
    }

    @Override
    public boolean handle(UpdateTradePacket packet) {
        return true;
    }

    @Override
    public boolean handle(BiomeDefinitionListPacket packet) {
        return true;
    }

    @Override
    public boolean handle(LevelSoundEvent2Packet packet) {
        return true;
    }

    @Override
    public boolean handle(NetworkChunkPublisherUpdatePacket packet) {
        return true;
    }

    @Override
    public boolean handle(VideoStreamConnectPacket packet) {
        return true;
    }

    @Override
    public boolean handle(CodeBuilderPacket packet) {
        return true;
    }

    @Override
    public boolean handle(EmoteListPacket packet) {
        return true;
    }

    @Override
    public boolean handle(ItemStackRequestPacket packet) {
        return true;
    }

    @Override
    public boolean handle(ItemStackResponsePacket packet) {
        return true;
    }

    @Override
    public boolean handle(PlayerArmorDamagePacket packet) {
        return true;
    }

    @Override
    public boolean handle(PlayerEnchantOptionsPacket packet) {
        return true;
    }

    @Override
    public boolean handle(CreativeContentPacket packet) {
        return true;
    }

    @Override
    public boolean handle(UpdatePlayerGameTypePacket packet) {
        return true;
    }

    @Override
    public boolean handle(PositionTrackingDBServerBroadcastPacket packet) {
        return true;
    }

    @Override
    public boolean handle(PositionTrackingDBClientRequestPacket packet) {
        return true;
    }

    @Override
    public boolean handle(PacketViolationWarningPacket packet) {
        return true;
    }

    @Override
    public boolean handle(DebugInfoPacket packet) {
        return true;
    }

    @Override
    public boolean handle(MotionPredictionHintsPacket packet) {
        return true;
    }

    @Override
    public boolean handle(AnimateEntityPacket packet) {
        return true;
    }

    @Override
    public boolean handle(CameraShakePacket packet) {
        return true;
    }

    @Override
    public boolean handle(CorrectPlayerMovePredictionPacket packet) {
        return true;
    }

    @Override
    public boolean handle(PlayerFogPacket packet) {
        return true;
    }

    @Override
    public boolean handle(ItemComponentPacket packet) {
        return true;
    }
}
