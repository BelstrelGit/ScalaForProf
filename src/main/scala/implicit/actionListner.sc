

import java.awt.event.{ActionEvent, ActionListener}

import javax.swing.JButton

implicit def function2ActionListener(f: ActionEvent => Unit) =
  new ActionListener {
    def actionPerformed(event: ActionEvent) = f(event)
  }
val button = new JButton
//button.addActionListener(
//  new ActionListener {
//    def actionPerformed(event: ActionEvent) = {
//      println("pressed!")
//    }
//  }
//)
//button.addActionListner(
//  function2ActionListener(
//    (_: ActionEvent) =>println("pressed!")
//  )
//)
button.addActionListener(
  (_: ActionEvent) => println("pressed!")
)