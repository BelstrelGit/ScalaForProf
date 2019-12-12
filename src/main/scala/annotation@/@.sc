//@deprecated def bigMistake() = //...
@deprecated class QuickAndDirty {
  //...
}
//(e: @unchecked) match {
//}
//@ annot ( exp 1 , exp 2 , ... )
//@serial(1234)
//@cool val normal = "Hello"
//@coolerThan(normal) val fonzy = "Heeyyy"
 import annotation._
class strategy(arg: Annotation) extends Annotation
class delayed extends Annotation
//@strategy(@delayed) def f() = {}  // error
@strategy(new delayed) def f() = {} //custom

@deprecated("use newShinyMethod() instead")
@deprecated def bigMistake() = {???}
//@volatile
//@serializable
//@SerialVersionUID(1234)
//@transient

//@scala.reflect.BeanProperty
//@tailrec
//@unchecked


@native
def beginCountdown() = {}
//Аннотация @native информирует компилятор, что реализация метода предостав-
//  ляется средой выполнения, а не кодом Scala. Компилятор установит на выходе
//  соответствующие флаги, и разработчику достаточно будет обеспечить реализацию,
//используя такие механизмы, как интерфейс прямого доступа к виртуальной маши-
//  не Java (Java Native Interface (JNI)).