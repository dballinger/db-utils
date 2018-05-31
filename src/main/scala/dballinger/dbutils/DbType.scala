package dballinger.dbutils

import java.sql.ResultSet

sealed trait DbType {
  type ScalaType
  def resolve:ScalaType
}

class Varchar(resultSet: ResultSet, position: Int) extends DbType {
  override type ScalaType = String

  override def resolve: String = resultSet.getString(position)
}

class DbLong(resultSet: ResultSet, position: Int) extends DbType {
  override type ScalaType = Long

  override def resolve: Long = resultSet.getLong(position)
}


