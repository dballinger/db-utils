package dballinger.dbutils

import java.sql.ResultSet

trait DbType {
  type ScalaType
}

trait Varchar extends DbType {
  override type ScalaType = String
}

case object Varchar extends Varchar {

  implicit val extractor: Extractor[Varchar] = new Extractor[Varchar] {

    override def extract(resultSet: ResultSet, position: Int): String = resultSet.getString(position)

    override val t: Varchar = Varchar
  }
}

trait Extractor[T <: DbType] {
  val t: T

  def extract(resultSet: ResultSet, position: Int): t.ScalaType
}
