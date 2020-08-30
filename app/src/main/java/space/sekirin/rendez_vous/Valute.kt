package space.sekirin.rendez_vous

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "Valute", strict = false)
data class Valute (

    @param:Attribute(name = "ID", required = false)
    @get:Attribute(name = "ID", required = false)
    var id: String,
    @param:Element(name = "NumCode", required = false)
    @get:Element(name = "NumCode", required = false)
    var numCode: Int,
    @param:Element(name = "CharCode", required = false)
    @get:Element(name = "CharCode", required = false)
    var charCode: String,
    @param:Element(name = "Nominal", required = false)
    @get:Element(name = "Nominal", required = false)
    var nominal: Int,
    @param:Element(name = "Name", required = false)
    @get:Element(name = "Name", required = false)
    var name: String,
    @param:Element(name = "Value", required = false)
    @get:Element(name = "Value", required = false)
    var value: String
) {

}