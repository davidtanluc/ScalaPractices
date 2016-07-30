package project1
import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

/* Property based testing */
object GetMessageSpec extends Properties("GetMessage") {
  val simpleMsg = new SimpleMsg

  property("simpleMsg") = forAll { (a: String) =>
    simpleMsg.getMessage(a) == a//tested for 100 samples
  }

}
