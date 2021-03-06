package alternativemods.alteng

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.Mod.EventHandler
import org.apache.logging.log4j.LogManager
import jk_5.commons.config.ConfigFile
import alternativemods.alteng.blocks.AltEngBlocks
import alternativemods.alteng.tileentities.AltEngTileEntities
import alternativemods.alteng.network.NetworkHandler
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemStack
import alternativemods.alteng.items.AltEngItems
import alternativemods.alteng.util.AlternativeElectricItemManager

@Mod(modid = "AltEng", name = "AlternativeEnergy", modLanguage = "scala")
object AlternativeEnergy {

  val logger = LogManager.getLogger("AltEng")
  val creativeTab = new CreativeTabs("altEng") {
    def getTabIconItem = new ItemStack(AltEngBlocks.blockConveyor, 1, 0).getItem
  }

  @EventHandler def preInit(event: FMLPreInitializationEvent){
    this.logger.info("Loading AlternativeEnergy")

    val config = ConfigFile.fromFile(event.getSuggestedConfigurationFile).setComment("AlternativeEnergy main config file")
    AltEngItems.load()
    AltEngBlocks.load()
    AltEngTileEntities.load()
    NetworkHandler.init(event.getSide)
  }
}
