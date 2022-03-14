package model.interfaces

import model.BoardImpl
import model.ui.Cell
import util.assertNineSq

interface Board : List<Cell>, BoardVisitor {
  val rows: List<List<Cell>>
  val columns: List<List<Cell>>
  val houses: List<List<Cell>>

  val rowSets: List<NumbersSet>
  val colSets: List<NumbersSet>
  val houseSets: List<NumbersSet>

  fun setCell(index: Int, cell: Cell): Board

  val isSolved: Boolean

  companion object {
    fun fromString(str: String): Board {
      str.length.assertNineSq()
      return BoardImpl(str
        .map { it.digitToInt() }
        .map { if (it == 0) Cell.Empty else Cell.Single(it) })
    }
  }
}