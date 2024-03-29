trait OutputChannel[-T] {
  def write(x: T)
}

//принципом подстановки Лисков - тип T является подтипом типа U , если
//значение типа T можно подставить там, где требуется значение типа U . Данный принцип соблюдается, если
//T поддерживает те же операции, что и U , и все принадлежащие T операции тре-
//  буют меньшего, а предоставляют большее, чем соответствующие операции в U .

trait Function1[-S, +T] {
  def apply(x: S): T }