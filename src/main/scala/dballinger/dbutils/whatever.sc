import dballinger.dbutils.{DbType, TestType, Varchar}
import shapeless.{HList, HNil, LUBConstraint, Poly1}
import shapeless.poly._
import shapeless.syntax.std.tuple._

implicit object mapper extends Poly1 {
  implicit def caseVarchar = at[Varchar](v => v.resolve)
  implicit def caseTestType= at[TestType](v => v.resolve)
}


def tupMapper[L <: HList](tup: L)(implicit c: LUBConstraint[L, DbType]) = {
  tup.map(mapper)
}



val out = tupMapper(new TestType("a") :: new TestType("b") :: HNil)

//println(out)