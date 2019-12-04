def curriedSum(x: Int)(y: Int) = x+y

curriedSum(1)(2)

def first(x:Int) =(y : Int) => x+y
def second = first(1)

second(2)

val onePlus = curriedSum(1)_
onePlus(5)
val twoPlus = curriedSum(2)_
twoPlus(5)