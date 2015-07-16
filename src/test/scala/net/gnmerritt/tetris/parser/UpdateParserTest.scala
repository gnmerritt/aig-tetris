package net.gnmerritt.tetris.parser

import net.gnmerritt.tetris.UnitSpec
import net.gnmerritt.tetris.engine.Position
import net.gnmerritt.tetris.player.GameState

/**
 * Tests for round-by-roud updates
 */
class UpdateParserTest extends UnitSpec {
  def line(line: String): GameState = {
    UpdateParser.update(new GameState, line)
  }

  "The update parser" should "parse round #" in {
    val round = line("update game round 11")
    assert(round.round.roundNum == 11)
  }

  it should "parse this piece" in {
    val thisPieceType = line("update game this_piece_type I")
    assert(thisPieceType.round.thisPiece.name == "I")
  }

  it should "place this piece" in {
    val thisPiecePos = line("update game this_piece_position 3,5")
    assert(thisPiecePos.round.thisPiecePosition == new Position(3, 5))
  }

  it should "parse the next piece" in {
    val next = line("update game next_piece_type Z")
    assert(next.round.nextPiece.name == "Z")
  }

  it should "parse the field" in {
    val fieldState = line("update player1 field 0,0,0,0,1,1,0,0,0,0;0,0,0,0,0,0,0,0,0,0;0,0,0,0,0,0,0,0,0,0;0,0,0,0,0,0,0,0,0,0;0,0,0,0,0,0,0,0,0,0;0,0,0,0,0,0,0,0,0,0;0,0,0,0,0,0,0,0,0,0;0,0,0,0,0,0,0,0,0,0;0,0,0,0,0,0,0,0,0,0;0,0,0,0,0,0,0,0,0,0;0,0,0,0,0,0,0,0,0,0;0,0,0,0,0,0,0,0,0,0;0,0,0,0,0,0,0,0,0,0;0,0,0,0,0,0,0,0,0,0;0,0,0,0,0,0,0,0,0,0;0,0,0,0,0,0,0,0,0,0;0,0,0,0,0,0,0,0,0,0;0,0,0,0,0,0,0,0,0,0;0,0,0,0,0,0,0,0,0,0;0,0,0,0,0,0,0,0,0,0")
  }
}
