package app.proxy.dynamic;

public class BadApple {
  public String name;

  public BadApple(String name) {
    this.name = name;
  }

  public boolean equals(Object o) {
    if(!(o instanceof BadApple))
      return false;
    BadApple f = (BadApple) o;
    return name.equals(f.name);
  }

  public int hashCode() {
    try {
      Thread.sleep(1200);
    }
    catch(InterruptedException ignored) {
    }
    return name.hashCode();
  }

  public String toString() {
    return name;
  }
}
