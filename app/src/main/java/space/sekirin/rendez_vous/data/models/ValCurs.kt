package space.sekirin.rendez_vous.data.models

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root
data class ValCurs @JvmOverloads constructor(

    @param:Attribute(name = "Date")
    @get:Attribute(name = "Date")
    var date: String,
    @param:Attribute(name = "name")
    @get:Attribute(name = "name")
    var name: String,

    @param:ElementList(
        required = false,
        name = "Valute",
        entry = "Valute",
        inline = true,
        empty = true
    )
    @get:ElementList(
        required = false,
        name = "Valute",
        entry = "Valute",
        inline = true,
        empty = true
    )
    var valutes: List<Valute>

) {
}