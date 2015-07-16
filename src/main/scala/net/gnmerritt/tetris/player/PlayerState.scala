package net.gnmerritt.tetris.player

import net.gnmerritt.tetris.engine.Field

/**
 * The field, score, bonus, etc. for a player
 */
case class PlayerState(field: Field = new Field(0, 0), score: Score = new Score)

case class Score(rowPoints: Int = 0, comboPoints: Int = 0)
