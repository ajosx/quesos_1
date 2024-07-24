package pe.idat.quesosapp_2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormularioScreen() {

    var nombre by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var comentario by remember { mutableStateOf("") }



    Scaffold(
        topBar = { TopAppBar(title = { Text("Información del cliente") }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Text(text = "Ingresa tus datos para ponernos en contacto contigo")
            Spacer(modifier = Modifier.weight(2f))
            TextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") }
            )
            Spacer(modifier = Modifier.weight(3f))
            TextField(
                value = direccion,
                onValueChange = { direccion = it },
                label = { Text("Dirección") }
            )
            Spacer(modifier = Modifier.weight(3f))
            TextField(
                value = comentario,
                onValueChange = { comentario = it },
                label = { Text("Comentario adicional") },
                maxLines = 4
            )
            Spacer(modifier = Modifier.weight(3f))
            Button(onClick = { /* Acción al continuar el pedido */ }) {
                Text("Continuar pedido")
            }
        }
    }
}