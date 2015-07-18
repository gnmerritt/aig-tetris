package net.gnmerritt.tetris.output

import net.gnmerritt.tetris.UnitSpec
import net.gnmerritt.tetris.output.Action.Action

/**
 * Make sure we format actions correctly
 */
class ActionTest extends UnitSpec {
  "Action outputs" should "be formatted correctly" in {
    val actions = Array(Action.LEFT, Action.LEFT, Action.DROP)
    assert(Action.say(actions) == "left,left,drop")
  }

  it should "not explode" in {
    assert(Action.say(Array[Action]()) == "")
  }
}
