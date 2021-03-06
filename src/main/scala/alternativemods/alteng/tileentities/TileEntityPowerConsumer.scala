package alternativemods.alteng.tileentities

import alternativemods.alteng.powertraits.tile.UniversalPowerTile
import net.minecraft.tileentity.TileEntity

/**
 * Drains power, creates fluid
 *
 * @author jk-5
 */
class TileEntityPowerConsumer extends TileEntity with UniversalPowerTile {

  var energy = 0d
  val maxEnergy = 5000d
  val bcRatio = 1.0
  val ic2Ratio = 0.5

  override def updateEntity(){
    super.updateEntity()

    //Consume 10 energy each tick
    this.energy -= 10
  }
}
