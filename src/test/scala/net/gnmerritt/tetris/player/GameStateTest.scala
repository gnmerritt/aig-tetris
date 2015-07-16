package net.gnmerritt.tetris.player

import net.gnmerritt.tetris.UnitSpec

/**
 * Make sure we can update values in the game state
 */
class GameStateTest extends UnitSpec {
  var state = new GameState

  "The game state" should "start empty" in {
    assert(state.round == new Round)
    assert(state.settings == new GameSettings)
    assert(state.you == new PlayerState)
    assert(state.opponent == new PlayerState)
  }

  it should "update rationally" in {
    val newRound = new Round(round = 2)
    val newState = state.copy(round = newRound)
    assert(state != newState)
    assert(newState.round == newRound)

    // second update
    val newSettings = GameSettings(fieldHeight = 10, fieldWidth = 5)
    val thirdState = newState.copy(settings = newSettings)
    assert(thirdState != newState)
    assert(thirdState.settings == newSettings)
    assert(thirdState.round == newRound)
  }
}
