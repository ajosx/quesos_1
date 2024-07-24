package pe.idat.quesosapp_2

data class Product(
    val name: String,
    val price: Double,
    var quantity: Int = 0
)

val products = listOf(
    Product("Queso fresco (480 gr)", 16.00),
    Product("Queso suizo (600 gr)", 24.00),
    Product("Queso mantecoso (300 gr)", 12.00),
    Product("Queso mantecoso (500 gr)", 16.00),
    Product("Queso paria (550 gr)", 25.00),
    Product("Queso ahumado (300 gr)", 20.00),
)