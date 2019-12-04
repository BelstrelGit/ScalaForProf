var assertionsEnabled = true
//def myAssert(predicate: () => Boolean) =
def myAssert(predicate :  => Boolean)=
  if (assertionsEnabled && !predicate)
    throw new AssertionError

//myAssert(() => 5  > 3 )
myAssert( 5  > 3 )