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
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(AnimatePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(AnvilDamagePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(AvailableEntityIdentifiersPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(BlockEntityDataPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(BlockPickRequestPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(BookEditPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ClientCacheBlobStatusPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ClientCacheMissResponsePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ClientCacheStatusPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ClientToServerHandshakePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(CommandBlockUpdatePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(CommandRequestPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(CompletedUsingItemPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ContainerClosePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(CraftingEventPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(EducationSettingsPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(EmotePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(EntityEventPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(EntityFallPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(EntityPickRequestPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(EventPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(FilterTextPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(InteractPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(InventoryContentPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(InventorySlotPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(InventoryTransactionPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ItemFrameDropItemPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(LabTablePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(LecternUpdatePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(LevelEventGenericPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(LevelSoundEvent1Packet packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(LevelSoundEventPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(LoginPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(MapInfoRequestPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(MobArmorEquipmentPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(MobEquipmentPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ModalFormResponsePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(MoveEntityAbsolutePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(MovePlayerPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(MultiplayerSettingsPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(NetworkStackLatencyPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(PhotoTransferPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(PlayerActionPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(PlayerAuthInputPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(PlayerHotbarPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(PlayerInputPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(PlayerSkinPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(PurchaseReceiptPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(RequestChunkRadiusPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ResourcePackChunkRequestPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ResourcePackClientResponsePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(RiderJumpPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ServerSettingsRequestPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(SetDefaultGameTypePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(SetLocalPlayerAsInitializedPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(SetPlayerGameTypePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(SubClientLoginPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(AddBehaviorTreePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(AddEntityPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(AddHangingEntityPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(AddItemEntityPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(AddPaintingPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(AddPlayerPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(AvailableCommandsPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(BlockEventPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(BossEventPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(CameraPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ChangeDimensionPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ChunkRadiusUpdatedPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ClientboundMapItemDataPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(CommandOutputPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ContainerOpenPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ContainerSetDataPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(CraftingDataPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(DisconnectPacket packet) {
        Server.getInstance().getPlayers().remove(this.player.getUuid());
        System.out.println(this.player.getPlayerName() + "disconnected");
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ExplodePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(LevelChunkPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(GameRulesChangedPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(GuiDataPickItemPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(HurtArmorPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(AutomationClientConnectPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(LevelEventPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(MapCreateLockedCopyPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(MobEffectPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ModalFormRequestPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(MoveEntityDeltaPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(NetworkSettingsPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(NpcRequestPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(OnScreenTextureAnimationPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(PlayerListPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(PlaySoundPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(PlayStatusPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(RemoveEntityPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(RemoveObjectivePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ResourcePackChunkDataPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ResourcePackDataInfoPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ResourcePacksInfoPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ResourcePackStackPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(RespawnPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ScriptCustomEventPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ServerSettingsResponsePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ServerToClientHandshakePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(SetCommandsEnabledPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(SetDifficultyPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(SetDisplayObjectivePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(SetEntityDataPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(SetEntityLinkPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(SetEntityMotionPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(SetHealthPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(SetLastHurtByPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(SetScoreboardIdentityPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(SetScorePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(SetSpawnPositionPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(SetTimePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(SettingsCommandPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(SetTitlePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ShowCreditsPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ShowProfilePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ShowStoreOfferPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(SimpleEventPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(SpawnExperienceOrbPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(SpawnParticleEffectPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(StartGamePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(StopSoundPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(StructureBlockUpdatePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(StructureTemplateDataRequestPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(StructureTemplateDataResponsePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(TakeItemEntityPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(TextPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(TickSyncPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(TransferPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(UpdateAttributesPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(UpdateBlockPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(UpdateBlockPropertiesPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(UpdateBlockSyncedPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(UpdateEquipPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(UpdateSoftEnumPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(UpdateTradePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(BiomeDefinitionListPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(LevelSoundEvent2Packet packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(NetworkChunkPublisherUpdatePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(VideoStreamConnectPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(CodeBuilderPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(EmoteListPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ItemStackRequestPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ItemStackResponsePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(PlayerArmorDamagePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(PlayerEnchantOptionsPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(CreativeContentPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(UpdatePlayerGameTypePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(PositionTrackingDBServerBroadcastPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(PositionTrackingDBClientRequestPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(PacketViolationWarningPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(DebugInfoPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(MotionPredictionHintsPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(AnimateEntityPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(CameraShakePacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(CorrectPlayerMovePredictionPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(PlayerFogPacket packet) {
        System.out.println(packet);
        return true;
    }

    @Override
    public boolean handle(ItemComponentPacket packet) {
        System.out.println(packet);
        return true;
    }
}
