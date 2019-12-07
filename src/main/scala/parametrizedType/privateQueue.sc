trait Queue[T] {   //конструктор типа
 def  head: T
 def  tail: Queue[T]
 def  enqueue(x: T): Queue[T]
}

  object Queue {
    def apply[T](xs: T*): Queue[T] =
      new QueueImpl[T](xs.toList, Nil)
    private class QueueImpl[T](
                                private val leading: List[T],
                                private val trailing: List[T]
                              ) extends Queue[T] {
      def mirror =
        if (leading.isEmpty)
          new QueueImpl(trailing.reverse, Nil)
        else
          this
      def head: T = mirror.leading.head
      def tail: QueueImpl[T] = {
        val q = mirror
        new QueueImpl(q.leading.tail, q.trailing)
      }
      def enqueue(x: T) =
        new QueueImpl(leading, x :: trailing)
    }
  }


//в Scala у обобщенных типов изначально имеется невариантное (или
//  жесткое) подтипирование.

//ковариантность (гибкость) подтипирования очередей
//trait Queue[+T] { ... }

//- показывает контрвариантность подтипирования
//trait Queue[-T] { ... }

//подробнeе о проверке компиляторов аннотаций вариативности стр 367

//class Queue[+T] (private val leading: List[T],
//                 private val trailing: List[T] ) {
//  def enqueue[U >: T](x: U) =   //T определяется как нижний ограничитель для U
//    new Queue[U](leading, x :: trailing) // ...
//}