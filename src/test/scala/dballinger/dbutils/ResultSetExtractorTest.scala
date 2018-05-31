package dballinger.dbutils

import java.sql.ResultSet

import org.mockito.Mockito.when
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FreeSpec, FunSuite, Matchers}
import shapeless.{HList, HNil}

class ResultSetExtractorTest extends FreeSpec with Matchers with MockitoSugar {

  "ResultSetExtractor" - {
    "should extract different types" in {
      val resultSet = mock[ResultSet]
      when(resultSet.getString(1)).thenReturn("a")
      when(resultSet.getLong(2)).thenReturn(1L)
      val varchar = new Varchar(resultSet, 1)
      val long = new DbLong(resultSet, 2)
      val extracted = ResultSetExtractor.extract(varchar :: long :: HNil)
      extracted should be ("a" :: 1L :: HNil)
    }
  }

}
