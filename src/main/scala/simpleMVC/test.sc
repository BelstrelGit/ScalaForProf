
abstract class Food(val name: String) {
  override def toString = name
}

object Apple extends Food("Apple")
object Orange extends Food("Orange")
object Cream extends Food("Cream")
object Sugar extends Food("Sugar")

class Recipe (
               val name: String,
               val ingredients: List[Food],
               val instructions: String
             ){
  override def toString = name
}

object FruitSalad extends Recipe(
  "fruit salad",
  List(Apple, Orange, Cream, Sugar),
  "Stir it all together."
)
//Для использования Hibernate или JPA, потребуется  добавление закрытого поля id
// типа Long и конструктора, не исполь-
//зующего аргументов, помещение в отношении полей аннотации scala.reflect.BeanProperty

object SimpleDatabase {
  def allFoods = List(Apple, Orange, Cream, Sugar)
  def foodNamed(name: String): Option[Food] =
    allFoods.find(_.name == name )
  def allRecipes: List[Recipe] = List(FruitSalad)
  case class FoodCategory(name: String, foods: List[Food])

  private var categories = List(
    FoodCategory("fruits", List(Apple, Orange)),
    FoodCategory("misc", List(Cream, Sugar)))
  def allCategories = categories
}


object SimpleBrowser {
  def recipesUsing(food: Food) =
    SimpleDatabase.allRecipes
      .filter(recipe =>
        recipe.ingredients.contains(food))
  def displayCategory(category: SimpleDatabase.FoodCategory) = {
    println(category)
  }
}


val apple = SimpleDatabase.foodNamed("Apple").get
SimpleBrowser.recipesUsing(apple)