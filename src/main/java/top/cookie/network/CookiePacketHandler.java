package top.cookie.network;

import com.nukkitx.protocol.bedrock.BedrockServerSession;
import com.nukkitx.protocol.bedrock.handler.BedrockPacketHandler;
import com.nukkitx.protocol.bedrock.packet.*;
import top.cookie.Player;
import top.cookie.Server;

public class CookiePacketHandler implements BedrockPacketHandler {
    private BedrockServerSession session;
    private Player player;
    public CookiePacketHandler(BedrockServerSession session){
        this.session = session;
    }
    @Override
    public boolean handle(AdventureSettingsPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(AnimatePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(AnvilDamagePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(AvailableEntityIdentifiersPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(BlockEntityDataPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(BlockPickRequestPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(BookEditPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ClientCacheBlobStatusPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ClientCacheMissResponsePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ClientCacheStatusPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ClientToServerHandshakePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(CommandBlockUpdatePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(CommandRequestPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(CompletedUsingItemPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ContainerClosePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(CraftingEventPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(EducationSettingsPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(EmotePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(EntityEventPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(EntityFallPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(EntityPickRequestPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(EventPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(FilterTextPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(InteractPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(InventoryContentPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(InventorySlotPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(InventoryTransactionPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ItemFrameDropItemPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(LabTablePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(LecternUpdatePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(LevelEventGenericPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(LevelSoundEvent1Packet packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(LevelSoundEventPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(MapInfoRequestPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(MobArmorEquipmentPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(MobEquipmentPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ModalFormResponsePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(MoveEntityAbsolutePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(MovePlayerPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(MultiplayerSettingsPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(NetworkStackLatencyPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(PhotoTransferPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(PlayerActionPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(PlayerAuthInputPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(PlayerHotbarPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(PlayerInputPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(PlayerSkinPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(PurchaseReceiptPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(RequestChunkRadiusPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ResourcePackChunkRequestPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ResourcePackClientResponsePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(RiderJumpPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ServerSettingsRequestPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(SetDefaultGameTypePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(SetLocalPlayerAsInitializedPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(SetPlayerGameTypePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(SubClientLoginPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(AddBehaviorTreePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(AddEntityPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(AddHangingEntityPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(AddItemEntityPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(AddPaintingPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(AddPlayerPacket packet) {
        return true;
    }

    @Override
    public boolean handle(AvailableCommandsPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(BlockEventPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(BossEventPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(CameraPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ChangeDimensionPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ChunkRadiusUpdatedPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ClientboundMapItemDataPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(CommandOutputPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ContainerOpenPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ContainerSetDataPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(CraftingDataPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(DisconnectPacket packet) {
        Server.getInstance().getPlayers().remove(this.player.getUuid());
        System.out.println(this.player.getPlayerName() + "disconnected");
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ExplodePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(LevelChunkPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(GameRulesChangedPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(GuiDataPickItemPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(HurtArmorPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(AutomationClientConnectPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(LevelEventPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(MapCreateLockedCopyPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(MobEffectPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ModalFormRequestPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(MoveEntityDeltaPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(NetworkSettingsPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(NpcRequestPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(OnScreenTextureAnimationPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(PlayerListPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(PlaySoundPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(PlayStatusPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(RemoveEntityPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(RemoveObjectivePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ResourcePackChunkDataPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ResourcePackDataInfoPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ResourcePacksInfoPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ResourcePackStackPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(RespawnPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ScriptCustomEventPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ServerSettingsResponsePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ServerToClientHandshakePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(SetCommandsEnabledPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(SetDifficultyPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(SetDisplayObjectivePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(SetEntityDataPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(SetEntityLinkPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(SetEntityMotionPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(SetHealthPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(SetLastHurtByPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(SetScoreboardIdentityPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(SetScorePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(SetSpawnPositionPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(SetTimePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(SettingsCommandPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(SetTitlePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ShowCreditsPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ShowProfilePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ShowStoreOfferPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(SimpleEventPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(SpawnExperienceOrbPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(SpawnParticleEffectPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(StartGamePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(StopSoundPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(StructureBlockUpdatePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(StructureTemplateDataRequestPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(StructureTemplateDataResponsePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(TakeItemEntityPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(TextPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(TickSyncPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(TransferPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(UpdateAttributesPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(UpdateBlockPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(UpdateBlockPropertiesPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(UpdateBlockSyncedPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(UpdateEquipPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(UpdateSoftEnumPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(UpdateTradePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(BiomeDefinitionListPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(LevelSoundEvent2Packet packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(NetworkChunkPublisherUpdatePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(VideoStreamConnectPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(CodeBuilderPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(EmoteListPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ItemStackRequestPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ItemStackResponsePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(PlayerArmorDamagePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(PlayerEnchantOptionsPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(CreativeContentPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(UpdatePlayerGameTypePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(PositionTrackingDBServerBroadcastPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(PositionTrackingDBClientRequestPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(PacketViolationWarningPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(DebugInfoPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(MotionPredictionHintsPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(AnimateEntityPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(CameraShakePacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(CorrectPlayerMovePredictionPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(PlayerFogPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }

    @Override
    public boolean handle(ItemComponentPacket packet) {
        Server.getInstance().getLogger().info(packet);
        return true;
    }
}
