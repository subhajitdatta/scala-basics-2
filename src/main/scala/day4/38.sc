

class Cat {
  def speak1 = "dog"
}

class Dog {
  def speak = "dog"
}

class Duck {
  def speak = "duck"
}

type Speaker  = {
  def speak: String
}

def m(speaker: Speaker) = speaker.speak

m(new Dog)
m(new Duck)
m(new Cat)
