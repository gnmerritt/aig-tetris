package net.gnmerritt.tetris.output

/**
 * Created by nathan on 7/10/15.
 */
object Action extends Enumeration {
  type Action = Value
  val LEFT, RIGHT, DOWN, TURNLEFT, TURNRIGHT, DROP = Value
}
