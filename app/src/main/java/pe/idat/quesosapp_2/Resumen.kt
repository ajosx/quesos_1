package pe.idat.quesosapp_2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResumenScreen() {

    var selectedPaymentMethod by remember { mutableStateOf("Efectivo") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Resumen del pedido") }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Text(text = "Confirma tu pedido y selecciona el tipo de pago")
            // Lista de productos
            LazyColumn {
                items(products) { product ->
                    ProductItems(product)
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Total a pagar: S/ ${calculateTotal(products)}")
            // Opciones de pago
            Spacer(modifier = Modifier.weight(0.5f))
            RadioButtonGroup(
                options = listOf("Efectivo", "Yape", "Plin"),
                selectedOption = selectedPaymentMethod,
                onSelectedOptionChange = { selectedPaymentMethod = it }
            )
            Spacer(modifier = Modifier.weight(0.5f))
            Button(onClick = { /* Acción al generar el pedido */ }) {
                Text("Generar pedido")
            }
        }
    }
}

@Composable
fun ProductItems(product: Product) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = product.name)
        Spacer(modifier = Modifier.weight(0.5f))
        Text(text = "S/ ${product.price}")
    }
}


@Composable
fun RadioButtonGroup(
    options: List<String>,
    selectedOption: String,
    onSelectedOptionChange: (String) -> Unit
) {
    Column {
        options.forEach { option ->
            Row {
                RadioButton(
                    selected = selectedOption == option,
                    onClick = { onSelectedOptionChange(option) }
                )
                Text(text = option)
            }
        }
    }
}

fun calculateTotal(products: List<Product>): Double {
    return products.sumOf { it.price }
}