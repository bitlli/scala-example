import org.scalatest.{Matchers, WordSpec}

class TreeSpec extends WordSpec with Matchers with Tree {


  "Tree intersect " should {

    "A result" when {

      "be empty" in {
        val tree = new Leaf(Set[Int]());
        (tree intersect) should be(Set[Int]())
      }

      "be one element" in {
        val tree = new Leaf(Set[Int](1));
        (tree intersect) should be(Set[Int](1))
      }

      "be one empty when get Node" in {
        val tree = new Node(Leaf(Set[Int](1)));
        (tree intersect) should be(Set[Int](1))
      }

      "be one  when get Node" in {
        val tree = new Node(Leaf(Set[Int](1)), Leaf(Set[Int](1, 2)));
        (tree intersect) should be(Set[Int](1))
      }

      "be one  when get Nodes" in {
        val tree = new Node(Node(Leaf(Set[Int](1, 2)), Node(Leaf(Set[Int](1)), Leaf(Set[Int](1, 2)))));
        (tree intersect) should be(Set[Int](1))
      }
    }
  }
}


