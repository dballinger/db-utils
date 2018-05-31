package dballinger.dbutils

import shapeless.{HList, LUBConstraint, Poly1}
import shapeless.ops.hlist.Mapper

object ResultSetExtractor {

  object mapper extends Poly1 {
    implicit def caseVarchar = at[Varchar](v => v.resolve)

    implicit def caseLongType = at[DbLong](v => v.resolve)
  }

  def extract[L <: HList](dbTypes: L)
      (implicit
          c: LUBConstraint[L, DbType],
          m: Mapper[mapper.type, L]
      ) = {
    dbTypes.map(mapper)
  }
}