//leading содержит
//  элементы, которые располагаются от конца к началу, а элементы списка trailing
//  следуют из начала в конец очереди, то есть в обратном порядке.
 //чтобы добавить элемент, следует просто провести конс-операцию в от-
//  ношении списка trailing , воспользовавшись оператором :: , и тогда операция
//enqueue будет выполняться за постоянное время. Это означает, что, если изначально
//  пустая очередь выстраивается на основе последовательно проведенных операций
//  enqueue , список trailing будет расти, а список leading останется пустым. Затем
//перед выполнением первой операции head или tail в отношении пустого списка
//leading весь список trailing копируется в leading в обратном порядке следования
//элементов. Это делается с помощью операции по имени mirror .

class Queue[+T] private (
                          private[this] var leading: List[T],
                          private[this] var trailing: List[T]
                        ) {
  private def mirror() =
    if (leading.isEmpty) {
      while (!trailing.isEmpty) {
        leading = trailing.head :: leading
        trailing = trailing.tail
      }
    }
  def head: T = {
    mirror()
    leading.head
  }
  def tail: Queue[T] = {
    mirror()
    new Queue(leading.tail, trailing)
  }
  def enqueue[U >: T](x: U) =
    new Queue[U](leading, x :: trailing)
}

object Queue {
  def apply[T](xs: T*) = new Queue[T](xs.toList, Nil)
}
//Queue(1, 2, 3)
// Queue.apply(1, 2, 3)
// Операция mirror может занять время, пропорциональное количеству элементов очереди, но только
//  если список leading пуст. Если список leading не пуст, возвращение из метода про-
//  исходит немедленно. Поскольку head и tail вызывают mirror , их вычислительная
//  сложность также может иметь линейную зависимость от размера очереди. Но чем
//  длиннее становится очередь, тем реже вызывается mirror . Подробнее стр 359
