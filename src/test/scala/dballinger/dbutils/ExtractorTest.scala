package dballinger.dbutils

import java.sql.ResultSet

import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FreeSpec, Matchers}
import org.mockito.Mockito._

class ExtractorTest extends FreeSpec with Matchers with MockitoSugar {

  "Extractor" - {
    "should extract a varchar as a string" in {
      val resultSet = mock[ResultSet]
      when(resultSet.getString(1)).thenReturn("aString")
      val result = Varchar.extractor.extract(resultSet, 1)
      result shouldBe "aString"
    }
  }
}
