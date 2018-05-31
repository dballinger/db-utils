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

class TestType(value:String) extends DbType {
  override type ScalaType = String

  override def resolve = value
}

