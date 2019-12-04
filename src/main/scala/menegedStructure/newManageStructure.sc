import java.io.{File, PrintWriter}

def twice(op: Double => Double , x : Double) = op(op(x))

twice(_ + 2 , 5



def withPrintWriter(file: File, op: PrintWriter => Unit) =
{val writer = new PrintWriter(file)
  try{
    op(writer)
  }finally {
    writer.close()
  }
}

withPrintWriter(
  new File("date.txt"),
  writer => writer.println(new java.util.Date)
)

def withPrintWriter(file: File)(op: PrintWriter => Unit) = {
  val writer = new PrintWriter(file)
  try {
    op(writer)
  } finally {
    writer.close()
  }
}
//Эта технология называется
//шаблоном временного пользования (loan pattern), поскольку функция управляющей
//абстракции, такая как withPrintWriter , открывает ресурс и отдает его функции во
//временное пользование
val file = new File("date.txt")
withPrintWriter(file) { writer =>
  writer.println(new java.util.Date)
}




