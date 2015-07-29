package net.gnmerritt.tetris.player

import net.gnmerritt.tetris.UnitSpec
import net.gnmerritt.tetris.engine.{Field, Piece}

/**
 * Test that the placement generator comes up with all the options
 */
class PlacementGeneratorTest extends UnitSpec {
  val field = new Field(10, 20)
  val generator = new PlacementGenerator(field, Piece.OPiece)
  val allPlacements = generator.all

  "The placement generator" should "make placements" in {
    assert(allPlacements.length == 200)
  }

  it should "not repeat placements" in {
    assert(allPlacements.distinct == allPlacements)
  }

  "allLegal" should "filter to only legal" in {
    val legal = generator.allLegal
    legal.foreach(p => assert(p.isLegal))
  }
}
