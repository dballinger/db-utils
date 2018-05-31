package dballinger.dbutils

import java.sql.ResultSet

import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FreeSpec, Matchers}
import org.mockito.Mockito._

class DbTypeTest extends FreeSpec with Matchers with MockitoSugar {

  "DbType" - {
    "should extract a varchar as a string" in {
      val resultSet = mock[ResultSet]
      when(resultSet.getString(1)).thenReturn("aString")
      val result = new Varchar(resultSet, 1).resolve
      result shouldBe "aString"
    }
    "should extract a long as a long" in {
      val resultSet = mock[ResultSet]
      when(resultSet.getLong(1)).thenReturn(1L)
      val result = new DbLong(resultSet, 1).resolve
      result shouldBe 1L
    }
  }
}
