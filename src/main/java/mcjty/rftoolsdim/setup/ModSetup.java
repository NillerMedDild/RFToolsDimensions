package mcjty.rftoolsdim.setup;

import mcjty.lib.compat.MainCompatHandler;
import mcjty.lib.setup.DefaultModSetup;
import mcjty.rftoolsdim.RFToolsDim;
import mcjty.rftoolsdim.commands.ModCommands;
import mcjty.rftoolsdim.dimension.DimensionRegistry;
import mcjty.rftoolsdim.dimension.biomes.RFTBiomeProvider;
import mcjty.rftoolsdim.dimension.terraintypes.VoidChunkGenerator;
import mcjty.rftoolsdim.dimlets.DimletDictionary;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import static mcjty.rftoolsdim.dimension.DimensionRegistry.VOID_ID;
import static mcjty.rftoolsdim.dimension.DimensionRegistry.WAVES_ID;

@Mod.EventBusSubscriber(modid = RFToolsDim.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSetup extends DefaultModSetup {

    private DimletDictionary dimletDictionary;

    public ModSetup() {
        createTab("rftoolsdim", () -> new ItemStack(Items.DIAMOND));
    }   // @todo 1.15

    @Override
    public void init(FMLCommonSetupEvent e) {
        super.init(e);

        RFToolsDimMessage.registerMessages("rftoolsdim");
        dimletDictionary = new DimletDictionary();

        e.enqueueWork(() -> {
            Registry.register(Registry.CHUNK_GENERATOR_CODEC, VOID_ID, VoidChunkGenerator.CODEC);
            Registry.register(Registry.CHUNK_GENERATOR_CODEC, WAVES_ID, VoidChunkGenerator.CODEC);
            Registry.register(Registry.BIOME_PROVIDER_CODEC, DimensionRegistry.BIOMES_ID, RFTBiomeProvider.CODEC);
        });
    }

    public DimletDictionary getDimletDictionary() {
        return dimletDictionary;
    }

    @SubscribeEvent
    public static void serverLoad(RegisterCommandsEvent event) {
        ModCommands.register(event.getDispatcher());
    }

    @Override
    protected void setupModCompat() {
        MainCompatHandler.registerWaila();
        MainCompatHandler.registerTOP();
    }
}
