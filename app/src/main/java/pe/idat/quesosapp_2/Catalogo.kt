package pe.idat.quesosapp_2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductCatalogScreen() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Catálogo de productos") }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            Text(text = "Selecciona los productos que deseas comprar")
            LazyColumn {
                items(products) { product ->
                    ProductItem(product)
                }
            }
            Button(onClick = { /* Acción al continuar el pedido */ }) {
                Text("Continuar pedido")
            }
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = product.name)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "S/${product.price}")
        Spacer(modifier = Modifier.weight(4f))
        Contador(count = product.quantity, onIncrement = { /* Incrementar cantidad */ }, onDecrement = { /* Decrementar cantidad */ })
    }
}

@Composable
fun Contador(count: Int, onIncrement: () -> Unit, onDecrement: () -> Unit) {
    Row {
        Button(onClick = onDecrement) { Text("-") }
        Text(text = count.toString())
        Button(onClick = onIncrement) { Text("+") }
    }
}