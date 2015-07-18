package net.gnmerritt.tetris.output

/**
 * Actions our bot can return
 */
object Action extends Enumeration {
  type Action = Value
  val LEFT, RIGHT, DOWN, TURNLEFT, TURNRIGHT, DROP = Value

  def say(actions: Seq[Action]): String = {
    actions.map(a => a.toString.toLowerCase).mkString(",")
  }
}

