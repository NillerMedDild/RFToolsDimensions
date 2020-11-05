package mcjty.rftoolsdim.datagen;

import mcjty.lib.datagen.BaseItemModelProvider;
import mcjty.rftoolsdim.RFToolsDim;
import mcjty.rftoolsdim.modules.dimensionbuilder.DimensionBuilderSetup;
import mcjty.rftoolsdim.modules.dimlets.DimletSetup;
import mcjty.rftoolsdim.modules.enscriber.EnscriberSetup;
import mcjty.rftoolsdim.modules.workbench.WorkbenchSetup;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class Items extends BaseItemModelProvider {

    public Items(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, RFToolsDim.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        parentedBlock(DimensionBuilderSetup.DIMENSION_BUILDER.get(), "block/dimension_builder");
        parentedBlock(WorkbenchSetup.WORKBENCH.get(), "block/dimlet_workbench");
        parentedBlock(EnscriberSetup.ENSCRIBER.get(), "block/enscriber");

        itemGenerated(DimletSetup.EMPTY_DIMLET.get(), "item/dimlets/empty_dimlet");
        itemGenerated(DimletSetup.EMPTY_TERRAIN_DIMLET.get(), "item/dimlets/empty_terrain_dimlet");
        itemGenerated(DimletSetup.EMPTY_FEATURE_DIMLET.get(), "item/dimlets/empty_feature_dimlet");
        itemGenerated(DimletSetup.EMPTY_BIOME_MODIFIER_DIMLET.get(), "item/dimlets/empty_biome_modifier_dimlet");
        itemGenerated(DimletSetup.EMPTY_MATERIAL_DIMLET.get(), "item/dimlets/empty_material_dimlet");
        itemGenerated(DimletSetup.TERRAIN_DIMLET.get(), "item/dimlets/terrain_dimlet");
        itemGenerated(DimletSetup.FEATURE_DIMLET.get(), "item/dimlets/feature_dimlet");
        itemGenerated(DimletSetup.BIOME_MODIFIER_DIMLET.get(), "item/dimlets/biome_modifier_dimlet");
        itemGenerated(DimletSetup.MATERIAL_DIMLET.get(), "item/dimlets/material_dimlet");

        itemGenerated(DimletSetup.PART_ENERGY_0.get(), "item/parts/part_energy_0");
        itemGenerated(DimletSetup.PART_ENERGY_1.get(), "item/parts/part_energy_1");
        itemGenerated(DimletSetup.PART_ENERGY_2.get(), "item/parts/part_energy_2");
        itemGenerated(DimletSetup.PART_ENERGY_3.get(), "item/parts/part_energy_3");
        itemGenerated(DimletSetup.PART_MEMORY_0.get(), "item/parts/part_memory_0");
        itemGenerated(DimletSetup.PART_MEMORY_1.get(), "item/parts/part_memory_1");
        itemGenerated(DimletSetup.PART_MEMORY_2.get(), "item/parts/part_memory_2");
        itemGenerated(DimletSetup.PART_MEMORY_3.get(), "item/parts/part_memory_3");

        itemGenerated(DimletSetup.COMMON_ESSENCE.get(), "item/parts/common_essence");
        itemGenerated(DimletSetup.RARE_ESSENCE.get(), "item/parts/rare_essence");
        itemGenerated(DimletSetup.LEGENDARY_ESSENCE.get(), "item/parts/legendary_essence");

    }

    @Override
    public String getName() {
        return "RFTools Dimensions Item Models";
    }
}
